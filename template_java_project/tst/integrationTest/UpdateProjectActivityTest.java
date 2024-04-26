package integrationTest;

import activity.UpdateProjectActivity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.DynamoDbClientProvider;
import dynamodb.dao.ProjectDao;
import dynamodb.dao.TeamDao;
import dynamodb.models.Project;
import dynamodb.models.Team;
import models.requests.UpdateProjectRequest;
import models.results.UpdateProjectResult;
import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UpdateProjectActivityTest {
    private TeamDao teamDao;
    private ProjectDao projectDao;
    private DynamoDBMapper dynamoDBMapper;
    private Team team;
    private Project project;
    private UpdateProjectRequest updateProjectRequest;
    private UpdateProjectResult updateProjectResult;
    private UpdateProjectActivity updateProjectActivity;

    @BeforeEach
    void setUp() {
        team = new Team();
        project = new Project();
        dynamoDBMapper = new DynamoDBMapper(DynamoDbClientProvider.REMOTE_CLIENT);
        teamDao = new TeamDao(dynamoDBMapper);
        projectDao = new ProjectDao(dynamoDBMapper);
        updateProjectActivity = new UpdateProjectActivity(teamDao,projectDao);
        updateProjectRequest = new UpdateProjectRequest();
        updateProjectRequest.setCourse("Data Science");
        updateProjectRequest.setDescription("Yes it is");
        updateProjectRequest.setYear(2024);
        updateProjectRequest.setGitUrl("Coming soon...");
        updateProjectRequest.setWebsiteUrl("Nadegas");
        updateProjectRequest.setTeamName("New Team");
        updateProjectRequest.setDev1("Draco");
        updateProjectRequest.setDev2("Draco");
        updateProjectRequest.setDev3("Draco");
        updateProjectRequest.setDev4("Draco");
    }

    @Test
    void handleRequest() {
        //Given
        updateProjectRequest.setId("rY9cE");
        updateProjectRequest.setDescription("Yes it is"+ new DateTime().toString());

        //When
        updateProjectResult = updateProjectActivity.handleRequest(updateProjectRequest,null);

        //Then
        assertEquals(updateProjectRequest.getDescription(), updateProjectResult.getProject().getDescription());


    }
}