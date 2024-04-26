package models.results;

import dynamodb.models.Project;
import dynamodb.models.Team;

public class GetProjectResult {
    private Project project;
    private Team team;

    public GetProjectResult(Project project, Team team) {
        this.project = project;
        this.team = team;
    }

    public Project getProject() {
        return project;
    }

    public Team getTeam() {
        return team;
    }
}
