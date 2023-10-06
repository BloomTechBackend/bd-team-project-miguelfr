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

    CreateProjectActivity createProjectActivity;

    @BeforeEach
    private void setUp() {
        initMocks(this);
        createProjectActivity = new CreateProjectActivity(teamDao,projectDao);

    }

    @Test
    void handleRequest_validRequest_saveTheProject() {
        //Given
        String description = "LBC projects database is a website where students can check the previous LBC projects so then can be more inspired for their own project ideas";
        CreateProjectRequest request = CreateProjectRequest.builder()
                .withCourse("Backend")
                .withDescription(description)
                .withDev1("Miguel Francisco")
                .withDev2("")
                .withDev3("")
                .withDev4("")
                .withGitUrl("https://github.com/BloomTechBackend/bd-team-project-miguelfr/tree/main")
                .withTitle("LBC projects database")
                .withWebsiteUrl("")
                .withTeamName("MiguelFR")
                .withYear(2023)
                .build();

        //When
        CreateProjectResult createProjectResult = createProjectActivity.handleRequest(request, null);

        //Then
        //verify(teamDao).save(new Team());
        //verify(projectDao).save(new Project());

        assertEquals(description, createProjectResult.getProjectModel().getDescription());
    }
}