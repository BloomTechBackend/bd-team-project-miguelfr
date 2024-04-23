package integrationTest;

import activity.CreateProjectActivity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.DynamoDbClientProvider;
import dynamodb.dao.ProjectDao;
import dynamodb.dao.TeamDao;
import models.ProjectModel;
import models.TeamModel;
import models.requests.CreateProjectRequest;
import models.results.CreateProjectResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectIntegrationTests {
    private TeamDao teamDao;
    private ProjectDao projectDao;
    private DynamoDBMapper dynamoDBMapper;
    private TeamModel teamModel;
    private ProjectModel projectModel;
    CreateProjectRequest request;
    CreateProjectActivity createProjectActivity;

    @BeforeEach
    public void setup() {
        dynamoDBMapper = new DynamoDBMapper(DynamoDbClientProvider.REMOTE_CLIENT);
        teamDao = new TeamDao(dynamoDBMapper);
        projectDao = new ProjectDao(dynamoDBMapper);
        createProjectActivity = new CreateProjectActivity(teamDao,projectDao);
        request = new CreateProjectRequest();
        request.setCourse("Backend");
        request.setDescription("LBC projects Test1");
        request.setDev1("Miguel Francisco");
        request.setDev2("Fernando");
        request.setDev3("Descriptor");
        request.setDev4("Lino");
        request.setGitUrl("https://github.com/BloomTechBackend/bd-team-project-miguelfr/tree/main");
        request.setTitle("LBC projects database");
        request.setWebsiteUrl("");
        request.setTeamName("MiguelFR");
        request.setYear(2024);
    }

    @Test
    public void saveProject_validProject_saveSuccessful(){
        //When Given
        CreateProjectResult createProjectResult = createProjectActivity.handleRequest(request, null);

        //Then
        assertEquals(request.getDescription(),createProjectResult.getProjectModel().getDescription());

    }
}
