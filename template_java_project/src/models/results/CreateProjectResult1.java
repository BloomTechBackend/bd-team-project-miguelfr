package models.results;

import models.ProjectModel;
import models.TeamModel;

public class CreateProjectResult1 {
    private ProjectModel projectModel;
    private TeamModel teamModel;

    private CreateProjectResult1(TeamModel teamModel, ProjectModel projectModel) {
        this.teamModel = teamModel;
        this.projectModel = projectModel;
    }

    public ProjectModel getProjectModel() {
        return projectModel;
    }

    public void setProjectModel(ProjectModel projectModel) {
        this.projectModel = projectModel;
    }

    public TeamModel getTeamModel() {
        return teamModel;
    }

    public void setTeamModel(TeamModel teamModel) {
        this.teamModel = teamModel;
    }
}
