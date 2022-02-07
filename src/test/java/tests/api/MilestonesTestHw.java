package tests.api;

import baseEntity.BaseApiTest;
import helpers.MilestoneHelper;
import io.restassured.mapper.ObjectMapperType;
import models.Milestone;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MilestonesTestHw extends BaseApiTest {
    int milestoneID;
    int projectId;
    ProjectBuilder projectBuilder;
    Milestone milestoneNew;
    Milestone milestoneUpdate;
    Milestone milestoneDelete;

    @Test
    public void addProject() {
        setUp();
        projectId = given()
                .body(projectBuilder, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

    }


    @Test(dependsOnMethods = "addMilestone")
    public void getMilestones() {

        MilestoneHelper milestoneHelper = new MilestoneHelper();
        milestoneHelper.getMilestones(projectId, milestoneNew);

    }

    @Test(dependsOnMethods = "addProject")
    public void addMilestone() {
        MilestoneHelper milestoneHelper = new MilestoneHelper();
        setUp();
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", milestoneNew.getName());
        jsonAsMap.put("description", milestoneNew.getDescription());
        milestoneID = milestoneHelper.addMilestone(milestoneID, jsonAsMap, projectId, milestoneNew);

    }

    @Test(dependsOnMethods = "addMilestone")
    public void updateMilestone() {
        MilestoneHelper milestoneHelper = new MilestoneHelper();
        setUp();
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", milestoneUpdate.getName());
        jsonAsMap.put("description", milestoneUpdate.getDescription());
        milestoneHelper.updateMilestone(milestoneID, jsonAsMap, milestoneNew, milestoneUpdate);

    }

    @Test (dependsOnMethods = "updateMilestone")
    public void deleteMilestone () {
        given()
                .pathParam("milestone_id", milestoneID)
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
        given()
                .pathParam("milestone_id", milestoneID)
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_BAD_REQUEST);


    }


    public void setUp() {
        projectBuilder = ProjectBuilder.builder()
                .name("Hello Wolrd")
                .announcement("This is my project")
                .typeOfProject(3)
                .build();
        milestoneNew = Milestone.builder()
                .name("CorrectMilestone")
                .description("Hi, its cool, very cool, catch the wave")
                .build();
        milestoneUpdate = Milestone.builder()
                .name("CorrectUpdate")
                .description("New fsdfds")
                .build();
        milestoneDelete = milestoneUpdate;

    }


}
