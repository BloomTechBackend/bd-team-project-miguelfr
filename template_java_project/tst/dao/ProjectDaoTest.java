package dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.DynamoDbClientProvider;
import dynamodb.dao.ProjectDao;
import dynamodb.models.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.ProjectServiceUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectDaoTest {
    Project project;
    DynamoDBMapper dynamoDBMapper;
    ProjectDao projectDao;

    @BeforeEach
    void setup(){
        project = new Project();
        project.setId(ProjectServiceUtils.generateProjectId());
        dynamoDBMapper = new DynamoDBMapper(DynamoDbClientProvider.REMOTE_CLIENT);
        projectDao = new ProjectDao(dynamoDBMapper);
    }

    @Test
    void save() {
        //Given
        project.setYear(2024);
        project.setTitle("Test2 LBC Project Save");

        //When
        Project project1 = projectDao.save(project);

        //Then
        assertEquals(project.getTitle(),project1.getTitle());
    }

    @Test
    void getProject() {
        //Given
        String id = "4a6pg";

        //When
        Project project1 = projectDao.getProject(id);

        //Then
        assertNotNull(project1);
        assertEquals(id,project1.getId());
        System.out.println(project1.getTitle());
    }

    @Test
    void getAllProjects() {
        //When Given
        List<Project> projectList = projectDao.getAllProjects();

        //Then
        assertNotNull(projectList);
        for (Project value : projectList) {
            System.out.println(value.getTitle());
        }

    }
}