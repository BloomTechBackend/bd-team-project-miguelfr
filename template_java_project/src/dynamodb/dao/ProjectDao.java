package dynamodb.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import dynamodb.models.Project;
import exceptions.ProjectNotFoundException;

import java.util.List;

public class ProjectDao {
    private final DynamoDBMapper dynamoDBMapper;

    public ProjectDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Project save(Project project) {
        dynamoDBMapper.save(project);
        return project;
    }

    public Project getProject(String id) {
        Project project = dynamoDBMapper.load(Project.class, id);
        if(project == null) {
            throw new ProjectNotFoundException("The project with id "+ id + "Was not found");
        }
        return project;
    }

    public List<Project> getAllProjects() {
        List<Project> projectList = dynamoDBMapper.scan(Project.class, new DynamoDBScanExpression());
        return projectList;
    }
}
