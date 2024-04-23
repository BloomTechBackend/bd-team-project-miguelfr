package activity;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.dao.ProjectDao;
import dynamodb.dao.TeamDao;
import dynamodb.models.Project;
import dynamodb.models.Team;
import exceptions.ProjectNotFoundException;
import models.ProjectModel;
import models.requests.CreateProjectRequest;
import models.results.CreateProjectResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class CreateProjectActivityTest {
    @Mock
    private ProjectDao projectDao;

    CreateProjectActivity createProjectActivity;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        createProjectActivity = new CreateProjectActivity(projectDao);

    }

    @Test
    void handleRequest_validRequest_saveTheProject() {
        //Given
        CreateProjectRequest request = CreateProjectRequest.builder()
                .withTitle("LBC projects database")
                .withYear(2024)
                .build();

        //When
        CreateProjectResult createProjectResult = createProjectActivity.handleRequest(request, null);

        //Then
        verify(projectDao).save(new Project());

        assertEquals("LBC projects database", createProjectResult.getProjectModel().getTitle());
    }
}