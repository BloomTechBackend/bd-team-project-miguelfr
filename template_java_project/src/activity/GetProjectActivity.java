package activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamodb.dao.ProjectDao;
import dynamodb.dao.TeamDao;
import dynamodb.models.Project;
import dynamodb.models.Team;
import models.requests.GetAllProjectsRequest;
import models.requests.GetProjectRequest;
import models.results.GetAllProjectsResult;
import models.results.GetProjectResult;

import javax.inject.Inject;

public class GetProjectActivity implements RequestHandler<GetProjectRequest, GetProjectResult> {
    private final TeamDao teamDao;
    private final ProjectDao projectDao;

    @Inject
    public GetProjectActivity(TeamDao teamDao, ProjectDao projectDao) {
        this.teamDao = teamDao;
        this.projectDao = projectDao;
    }

    @Override
    public GetProjectResult handleRequest(GetProjectRequest getProjectRequest, Context context) {
        Project project = projectDao.getProject(getProjectRequest.getId());
        Team team = teamDao.getTeam(project.getTeamId());

        return new GetProjectResult(project,team);
    }
}
