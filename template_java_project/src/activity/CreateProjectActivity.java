package activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import converters.ModelConverter;
import dynamodb.dao.ProjectDao;
import dynamodb.dao.TeamDao;
import dynamodb.models.Team;
import models.ProjectModel;
import models.TeamModel;
import models.requests.CreateProjectRequest;
import models.results.CreateProjectResult;
import util.ProjectServiceUtils;

import javax.inject.Inject;

public class CreateProjectActivity implements RequestHandler<CreateProjectRequest, CreateProjectResult> {

    private final ProjectDao projectDao;

    @Inject
    public CreateProjectActivity(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }


    @Override
    public CreateProjectResult handleRequest(CreateProjectRequest request, Context context) {

        ProjectModel projectModel = ProjectModel.builder()
                .withId(ProjectServiceUtils.generateProjectId())
                .withTitle(request.getTitle())
                .withYear(request.getYear())
                .build();

        projectDao.save(new ModelConverter().toProject(projectModel));

        return CreateProjectResult.builder()
                .withProject(projectModel)
                .build();
    }
}
