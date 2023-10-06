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

    private final TeamDao teamDao;
    private final ProjectDao projectDao;

    @Inject
    public CreateProjectActivity(TeamDao teamDao, ProjectDao projectDao) {
        this.teamDao = teamDao;
        this.projectDao = projectDao;
    }


    @Override
    public CreateProjectResult handleRequest(CreateProjectRequest request, Context context) {
        TeamModel teamModel = TeamModel.builder()
                .withId(ProjectServiceUtils.generateTeamId())
                .withName(request.getTeamName())
                .withDev1(request.getDev1())
                .withDev2(request.getDev2())
                .withDev3(request.getDev3())
                .withDev4(request.getDev4())
                .build();
        ProjectModel projectModel = ProjectModel.builder()
                .withId(ProjectServiceUtils.generateProjectId())
                .withCourse(request.getCourse())
                .withDescription(request.getDescription())
                .withGitUrl(request.getGitUrl())
                .withTeamId(teamModel.getId())
                .withTitle(request.getTitle())
                .withWebsiteUrl(request.getWebsiteUrl())
                .withYear(request.getYear())
                .build();

        teamDao.save(new ModelConverter().toTeam(teamModel));
        projectDao.save(new ModelConverter().toProject(projectModel));

        return CreateProjectResult.builder()
                .withProject(projectModel)
                .build();
    }
}
