package integrationTest;

import activity.CreateProjectActivity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import converters.ModelConverter;
import dynamodb.DynamoDbClientProvider;
import dynamodb.dao.ProjectDao;
import dynamodb.dao.TeamDao;
import dynamodb.models.Project;
import models.ProjectModel;
import models.TeamModel;
import models.requests.CreateProjectRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.ProjectServiceUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectIntegrationTests {
    //private TeamDao teamDao;
    private ProjectDao projectDao;
    private DynamoDBMapper dynamoDBMapper;
    //private TeamModel teamModel;
    private ProjectModel projectModel;

    @BeforeEach
    public void setup() {
        dynamoDBMapper = new DynamoDBMapper(DynamoDbClientProvider.REMOTE_CLIENT);
        //teamDao = new TeamDao(dynamoDBMapper);
        projectDao = new ProjectDao(dynamoDBMapper);
        /*teamModel = TeamModel.builder()
                .withId(ProjectServiceUtils.generateTeamId())
                .withName("Team A")
                .withDev1("Dave")
                .withDev2("Lucas")
                .withDev3("Nando")
                .withDev4("Carlos")
                .build();*/
        projectModel = ProjectModel.builder()
                .withId(ProjectServiceUtils.generateProjectId())
                .withTitle("Test1 - LBC Project Database")
                .withYear(2024)
                .build();
    }

   /* @Test
    public void saveProject_validProject_saveSuccessful(){
        //Given
        //Team team = new ModelConverter().toTeam(teamModel);
        Project project = new ModelConverter().toProject(projectModel);
        //CreateProjectRequest createProjectRequest = new CreateProjectRequest(projectModel);
        CreateProjectActivity createProjectActivity = new CreateProjectActivity(projectDao);
        //When
        //createProjectActivity.handleRequest(createProjectRequest, null);

        //Then
        //Team team1 = teamDao.getTeam(createProjectRequest.getTeamModel().getId()) ;
        //Project project1 = projectDao.getProject(createProjectRequest.getProjectModel().getId()) ;
       // assertEquals(team,team1);
        assertEquals(project,project1);
    }*/
}
