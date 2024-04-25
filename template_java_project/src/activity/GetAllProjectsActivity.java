package activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamodb.dao.ProjectDao;
import dynamodb.dao.TeamDao;
import dynamodb.models.Project;
import dynamodb.models.Team;
import models.requests.GetAllProjectsRequest;
import models.results.GetAllProjectsResult;

import javax.inject.Inject;
import java.util.List;

public class GetAllProjectsActivity implements RequestHandler<GetAllProjectsRequest, GetAllProjectsResult> {
    private final TeamDao teamDao;
    private final ProjectDao projectDao;

    @Inject
    public GetAllProjectsActivity(TeamDao teamDao, ProjectDao projectDao) {
        this.teamDao = teamDao;
        this.projectDao = projectDao;
    }

    @Override
    public GetAllProjectsResult handleRequest(GetAllProjectsRequest request, Context context) {
        List<Project> projectList = projectDao.getAllProjects();
        List<Team> teamList = teamDao.getAllTeams();

        return new GetAllProjectsResult(projectList,teamList);
    }
}
