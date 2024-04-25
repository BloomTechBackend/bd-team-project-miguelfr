package models.results;

import dynamodb.models.Project;
import dynamodb.models.Team;
import models.ProjectModel;
import models.TeamModel;
import java.util.List;

public class GetAllProjectsResult {
    private List<Team> teamList;
    private  List<Project> projectList;

    public GetAllProjectsResult(List<Project> projectList, List<Team> teamList) {
        this.teamList = teamList;
        this.projectList = projectList;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }
}
