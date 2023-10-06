package activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import converters.ModelConverter;
import dynamodb.dao.ProjectDao;
import dynamodb.dao.TeamDao;
import models.ProjectModel;
import models.TeamModel;
import models.requests.CreateProjectRequest;
import models.requests.CreateProjectRequest1;
import models.results.CreateProjectResult;
import util.ProjectServiceUtils;

import javax.inject.Inject;

public class CreateProjectActivity1 implements RequestHandler<CreateProjectRequest1, CreateProjectResult> {

    private final TeamDao teamDao;
    private final ProjectDao projectDao;

    @Inject
    public CreateProjectActivity1(TeamDao teamDao, ProjectDao projectDao) {
        this.teamDao = teamDao;
        this.projectDao = projectDao;
    }


    @Override
    public CreateProjectResult handleRequest(CreateProjectRequest1 request, Context context) {
        teamDao.save(new ModelConverter().toTeam(request.getTeamModel()));
        projectDao.save(new ModelConverter().toProject(request.getProjectModel()));

        return CreateProjectResult.builder()
                .withProject(request.getProjectModel())
                .build();
    }
}
