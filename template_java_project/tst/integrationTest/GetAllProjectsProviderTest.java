package integrationTest;

import activity.GetAllProjectsActivity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.DynamoDbClientProvider;
import dynamodb.dao.ProjectDao;
import dynamodb.dao.TeamDao;
import dynamodb.models.Project;
import dynamodb.models.Team;
import models.requests.GetAllProjectsRequest;
import models.results.GetAllProjectsResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetAllProjectsProviderTest {
    private TeamDao teamDao;
    private ProjectDao projectDao;
    private DynamoDBMapper dynamoDBMapper;
    private Team team;
    private Project project;
    private GetAllProjectsActivity getAllProjectsActivity;
    private GetAllProjectsResult getAllProjectsResult;
    private GetAllProjectsRequest getAllProjectsRequest;

    @BeforeEach
    void setUp() {
        team = new Team();
        project = new Project();
        dynamoDBMapper = new DynamoDBMapper(DynamoDbClientProvider.REMOTE_CLIENT);
        teamDao = new TeamDao(dynamoDBMapper);
        projectDao = new ProjectDao(dynamoDBMapper);
        getAllProjectsActivity = new GetAllProjectsActivity(teamDao, projectDao);
        getAllProjectsRequest = new GetAllProjectsRequest();
    }

    @Test
    void handleRequest() {
        //When Given
        getAllProjectsResult = getAllProjectsActivity.handleRequest(getAllProjectsRequest, null);

        //Then
        assertNotNull(getAllProjectsResult);
        for (Project project : getAllProjectsResult.getProjectList()){
            System.out.println(project.getTitle());
        }
        for (Team team : getAllProjectsResult.getTeamList()){
            System.out.println(team.getName());
        }
    }
}