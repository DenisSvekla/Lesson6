package models;

import enums.ProjectType;

public class Project {
    private String name;
    private String anouncement;
    private boolean isShowAnnouncement;
    private ProjectType typeOfProject;
    private boolean isCompleted;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnouncement() {
        return anouncement;
    }

    public void setAnouncement(String anouncement) {
        this.anouncement = anouncement;
    }

    public boolean isShowAnnouncement() {
        return isShowAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        isShowAnnouncement = showAnnouncement;
    }

    public ProjectType getTypeOfProject() {
        return typeOfProject;
    }

    public void setTypeOfProject(ProjectType typeOfProject) {
        this.typeOfProject = typeOfProject;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
