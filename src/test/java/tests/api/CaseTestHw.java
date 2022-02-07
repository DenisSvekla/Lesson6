package tests.api;

import baseEntity.BaseApiTest;
import enums.TestCaseTemplate;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.ProjectBuilder;
import models.Section;
import models.TestCase;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;
import utils.Randomization;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CaseTestHw extends BaseApiTest {
    public int projectID;
    ProjectBuilder project;
    Section firstSection;
    Section secondSection;
    public int firstSectionId;
    public int secondSectionId;
    TestCase testCase;
    public int testCaseId;
    TestCase updateTestCase;


    @Test
    public void addProject() {
        setUp();

        projectID = given()
                .body(project, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    @Test(dependsOnMethods = "addProject")
    public void addSections() {
        setUp();
        firstSectionId = given()
                .body(firstSection, ObjectMapperType.GSON)
                .pathParam("project_id", projectID)
                .when()
                .post(Endpoints.ADD_SECTION)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

        secondSectionId = given()
                .body(secondSection, ObjectMapperType.GSON)
                .pathParam("project_id", projectID)
                .when()
                .post(Endpoints.ADD_SECTION)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

    }


    @Test(dependsOnMethods = "addSections")
    public void addTestCase() {
        setUp();
        testCaseId = given()
                .pathParam("section_id", firstSectionId)
                .body(testCase, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_CASE)
                .then()
                .log().body()
                .extract().jsonPath().get("id");


    }


    @Test(dependsOnMethods = "addTestCase")
    public void getCase() {
        Response response = given()
                .pathParam("case_id", testCaseId)
                .get(Endpoints.GET_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        Assert.assertEquals(response.getBody().jsonPath().get("title"), testCase.getTitle());


    }

    @Test (dependsOnMethods = "getCase")
    public void updateTestCase() {
        given()
                .pathParam("case_id", testCaseId)
                .body(updateTestCase, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test (dependsOnMethods = "updateTestCase")
    public void moveCaseToSection() {
        String testCasesId = "" + testCaseId;

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("case_ids", testCasesId);
        given()
                .pathParam("section_id", secondSectionId)
                .body(jsonAsMap)
                .log().body()
                .when()
                .post(Endpoints.MOVE_CASES_TO_SECTION)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test (dependsOnMethods = "moveCaseToSection")
    public void deleteTestCase() {
        given()
                .pathParam("case_id", testCaseId)
                .post(Endpoints.DELETE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }



    public void setUp() {
        project = ProjectBuilder.builder()
                .name("For testik")
                .announcement("its real project with real test case")
                .typeOfProject(1)
                .build();

        firstSection = Section.builder()
                .name("corrent")
                .description("asdsad")
                .build();

        secondSection = Section.builder()
                .name("update")
                .description("ddd")
                .build();

        testCase = TestCase.builder()
                .title("check mmy test case")
                .template_id(TestCaseTemplate.TEST_CASE_STEPS)
                .type_id(Randomization.getRandomTestCaseType())
                .priority_id(3)
                .estimate("15m")
                .build();

        updateTestCase = TestCase.builder()
                .title("aupdatedTestCase")
                .template_id(TestCaseTemplate.TEST_CASE_TEXT)
                .type_id(Randomization.getRandomTestCaseType())
                .priority_id(3)
                .estimate("15m")
                .build();
    }
}
