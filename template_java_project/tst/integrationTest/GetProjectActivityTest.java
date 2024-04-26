package integrationTest;

import activity.GetProjectActivity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.DynamoDbClientProvider;
import dynamodb.dao.ProjectDao;
import dynamodb.dao.TeamDao;
import dynamodb.models.Project;
import dynamodb.models.Team;
import models.requests.GetProjectRequest;
import models.results.GetProjectResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetProjectActivityTest {

    private TeamDao teamDao;
    private ProjectDao projectDao;
    private DynamoDBMapper dynamoDBMapper;
    private Team team;
    private Project project;
    private GetProjectActivity getProjectActivity;
    private GetProjectResult getProjectResult;
    private GetProjectRequest getProjectRequest;

    @BeforeEach
    void setUp() {
        team = new Team();
        project = new Project();
        dynamoDBMapper = new DynamoDBMapper(DynamoDbClientProvider.REMOTE_CLIENT);
        teamDao = new TeamDao(dynamoDBMapper);
        projectDao = new ProjectDao(dynamoDBMapper);
        getProjectActivity = new GetProjectActivity(teamDao,projectDao);
    }

    @Test
    void handleRequest() {
        //Given
        getProjectRequest = new GetProjectRequest("mUtZq");

        //When
        getProjectResult = getProjectActivity.handleRequest(getProjectRequest, null);

        //Then
        assertEquals(getProjectRequest.getId(), getProjectResult.getProject().getId());
        System.out.println(getProjectResult.getProject().getDescription());
    }
}