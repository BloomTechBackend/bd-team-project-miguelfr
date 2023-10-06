package models.results;

import models.ProjectModel;

public class CreateProjectResult {
    private ProjectModel projectModel;

    private CreateProjectResult(Builder builder) {
        this.projectModel = builder.projectModel;
    }
    public static Builder builder() {
        return  new Builder();
    }

    public ProjectModel getProjectModel() {
        return projectModel;
    }

    public void setProjectModel(ProjectModel projectModel) {
        this.projectModel = projectModel;
    }


    public static final class Builder {
        private ProjectModel projectModel;

        public Builder withProject(ProjectModel projectModel) {
            this.projectModel = projectModel;
            return this;
        }

        public CreateProjectResult build() {
            return new CreateProjectResult(this);
        }
    }
}
