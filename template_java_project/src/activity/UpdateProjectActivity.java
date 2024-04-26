package activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import converters.ModelConverter;
import dynamodb.dao.ProjectDao;
import dynamodb.dao.TeamDao;
import dynamodb.models.Project;
import dynamodb.models.Team;
import models.ProjectModel;
import models.TeamModel;
import models.requests.UpdateProjectRequest;
import models.results.UpdateProjectResult;
import util.ProjectServiceUtils;

import javax.inject.Inject;

public class UpdateProjectActivity implements RequestHandler<UpdateProjectRequest, UpdateProjectResult> {
    private final TeamDao teamDao;
    private final ProjectDao projectDao;

    @Inject
    public UpdateProjectActivity(TeamDao teamDao, ProjectDao projectDao) {
        this.teamDao = teamDao;
        this.projectDao = projectDao;
    }

    @Override
    public UpdateProjectResult handleRequest(UpdateProjectRequest request, Context context) {
        Project project = projectDao.getProject(request.getId());
                project.setCourse(request.getCourse());
                project.setDescription(request.getDescription());
                project.setGitUrl(request.getGitUrl());
                project.setTitle(request.getTitle());
                project.setWebsiteUrl(request.getWebsiteUrl());
                project.setYear(request.getYear());

        Team team = teamDao.getTeam(project.getTeamId());
             team.setName(request.getTeamName());
             team.setDev1(request.getDev1());
             team.setDev2(request.getDev2());
             team.setDev3(request.getDev3());
             team.setDev4(request.getDev4());

        teamDao.save(team);
        projectDao.save(project);
        return new UpdateProjectResult(project,team);
    }
}
