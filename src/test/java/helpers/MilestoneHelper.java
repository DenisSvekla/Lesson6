package helpers;

import baseEntity.BaseHelper;

import com.google.gson.Gson;
import configuration.UserType;
import io.restassured.response.Response;
import models.Milestone;
import org.apache.hc.core5.http.HttpStatus;
import utils.Endpoints;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.not;


public class MilestoneHelper extends BaseHelper {
    Response response;
    /**
     * Get a milestone by ID
     *
     * @param id ,milestone's id
     * @return milestone
     */
    public Milestone getMilestones(String id) {
        response = restManager.get(Endpoints.GET_MILESTONE+id,null, UserType.ADMIN, "");

         return  gson.fromJson(response.getBody().asString(), Milestone.class);

    }

    public Milestone getMilestone(int id) {
       given()
                .pathParam("milestone_id", id)
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
       return Milestone.builder().build();
    }

    public Milestone getMilestones (int id,Milestone milestone) {
        given()
                .pathParam("project_id", id)
                .when()
                .get(Endpoints.GET_MILESTONES)
                .then()
                .log().body()
                .statusCode(org.apache.http.HttpStatus.SC_OK);
       return Milestone.builder().build();

    }
    public int addMilestone(int milestoneID, Map<String,Object> jsonAsMap, int projectId, Milestone milestone) {
       return milestoneID = given()
                .body(jsonAsMap)
                .pathParam("project_id", projectId)
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .body("name", is(milestone.getName()))
                .body("description", equalTo(milestone.getDescription()))
                .statusCode(org.apache.http.HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    public int updateMilestone(int milestoneID, Map<String,Object> jsonAsMap,
                                Milestone milestoneNew,Milestone milestoneUpdate) {
       return  milestoneID =given()
                .body(jsonAsMap)
                .pathParam("milestone_id", milestoneID)
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .body("name", not(milestoneNew.getName()))
                .body("description", not(milestoneNew.getDescription()))
                .body("name", is(milestoneUpdate.getName()))
                .body("description", is(milestoneUpdate.getDescription()))
                .statusCode(org.apache.http.HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

    }

    public int getStatusCode() {
        return response.getStatusCode();
    }
}
