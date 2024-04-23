import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.DynamoDbClientProvider;
import dynamodb.dao.ProjectDao;
import dynamodb.models.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.ProjectServiceUtils;

import static org.junit.jupiter.api.Assertions.*;

class ProjectDaoTest {
    private ProjectDao projectDao;
    private DynamoDBMapper dynamoDBMapper;
    private Project project;

    @BeforeEach
    public void setup(){
        dynamoDBMapper = new DynamoDBMapper(DynamoDbClientProvider.REMOTE_CLIENT);
        project = new Project();
        project.setId(ProjectServiceUtils.generateTeamId());
        projectDao = new ProjectDao(dynamoDBMapper);
    }

    @Test
    void save() {
        //Given
        project.setYear(2024);
        project.setTitle("Test1 LBC Project Save");

        //When
        Project project1 = projectDao.save(project);

        //Then
        assertEquals(project.getTitle(), project1.getTitle());
    }

    @Test
    void getProject() {
    }

    @Test
    void getAllProjects() {
    }
}