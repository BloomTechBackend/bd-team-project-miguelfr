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
    private TeamDao teamDao;
    @Mock
    private ProjectDao projectDao;
    CreateProjectRequest request;

    CreateProjectActivity createProjectActivity;

    @BeforeEach
    public void setUp() {
        initMocks(this);
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
    void handleRequest_validRequest_saveTheProject() {
        //Given
        String description = request.getDescription();

        //When
        CreateProjectResult createProjectResult = createProjectActivity.handleRequest(request, null);

        //Then
        //verify(teamDao).save(new Team());
        //verify(projectDao).save(new Project());

        assertEquals(description, createProjectResult.getProjectModel().getDescription());
    }
}