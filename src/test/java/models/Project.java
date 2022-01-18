package models;

import enums.ProjectType;

public class Project {
    private String name;
    private String anouncement;
    private boolean isShowAnnouncement;
    private ProjectType typeOfProject;
    private boolean isCompleted;

    public static class BuilderProject {
        private Project newProject;

        public static class Builder {
            private Project newProject;

            public Builder() {
                newProject = new Project();
            }

            public Builder withName(String name) {
                newProject.name = name;
                return this;
            }

            public Builder withAnouncement(String anouncement) {
                newProject.anouncement = anouncement;
                return this;
            }
            public Builder wihtIsShowAnnouncement(boolean isShowAnnouncement) {
                newProject.isShowAnnouncement = isShowAnnouncement ;
                return this;
            }

            public Project build() {
                return newProject;
            }
        }


    }

    public String getName() {
        return name;
    }

    public String getAnouncement() {
        return anouncement;
    }

    public boolean isShowAnnouncement() {
        return isShowAnnouncement;
    }

    public ProjectType getTypeOfProject() {
        return typeOfProject;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
