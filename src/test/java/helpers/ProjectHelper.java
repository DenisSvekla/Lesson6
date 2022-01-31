package helpers;

import baseEntity.BaseHelper;
import configuration.UserType;
import io.restassured.response.Response;
import models.ProjectBuilder;
import org.apache.tools.ant.Project;
import utils.Endpoints;
import utils.ObjectUtils;


public class ProjectHelper extends BaseHelper {
    Response response;

    /**
     * Add a project to the app
     *
     * @param project Project model
     * @return Project
     */

    public ProjectBuilder add(ProjectBuilder project) {
        response = restManager.post(Endpoints.ADD_PROJECT, null, UserType.ADMIN, ObjectUtils.getJsonFromObject(project, ProjectBuilder.class));
        return gson.fromJson(response.asString(), ProjectBuilder.class);
    }

    /**
     * Get a project by ID
     *
     * @param id project's id
     * @return Project
     */
    public Project getProject(int id) {
        response = restManager.get(Endpoints.GET_PROJECT + id, null, UserType.ADMIN, "");
        return gson.fromJson(response.asString(), Project.class);
    }

    public Response getResponse() {
        return response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

}
