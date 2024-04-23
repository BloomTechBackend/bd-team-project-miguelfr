package converters;

import dynamodb.models.Project;
import dynamodb.models.Team;
import models.ProjectModel;
import models.TeamModel;

public class ModelConverter {

    public Team toTeam(TeamModel teamModel) {
        Team team = new Team();
        team.setId(teamModel.getId());
        team.setName(teamModel.getName());
        team.setDev1(teamModel.getDev1());
        team.setDev2(teamModel.getDev2());
        team.setDev3(teamModel.getDev3());
        team.setDev4(teamModel.getDev4());
        return team;
    }
    public TeamModel toTeamModel(Team team) {
        TeamModel teamModel = TeamModel.builder()
                .withId(team.getId())
                .withName(team.getName())
                .withDev1(team.getDev1())
                .withDev2(team.getDev2())
                .withDev3(team.getDev3())
                .withDev4(team.getDev4())
                .build();
        return teamModel;
    }
    public Project toProject(ProjectModel projectModel) {
        Project project = new Project();
        project.setId(projectModel.getId());
        project.setTitle(projectModel.getTitle());

        project.setYear(projectModel.getYear());

        return project;
    }

    public ProjectModel toProjectModel(Project project) {
        ProjectModel projectModel = ProjectModel.builder()
                .withId(project.getId())
        .withTitle(project.getTitle())


                .withYear(project.getYear())

                .build();
        return projectModel;
    }
}
