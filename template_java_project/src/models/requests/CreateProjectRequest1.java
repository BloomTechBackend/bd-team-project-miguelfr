package models.requests;

import models.ProjectModel;
import models.TeamModel;

import java.util.Objects;

public class CreateProjectRequest1 {

    private TeamModel teamModel;
    private ProjectModel projectModel;

    public CreateProjectRequest1(TeamModel teamModel, ProjectModel projectModel) {
        this.teamModel = teamModel;
        this.projectModel = projectModel;
    }


    public TeamModel getTeamModel() {
        return teamModel;
    }

    public ProjectModel getProjectModel() {
        return projectModel;
    }

    public void setTeamModel(TeamModel teamModel) {
        this.teamModel = teamModel;
    }

    public void setProjectModel(ProjectModel projectModel) {
        this.projectModel = projectModel;
    }
}
