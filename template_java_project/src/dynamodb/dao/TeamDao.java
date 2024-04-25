package dynamodb.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import dynamodb.models.Project;
import dynamodb.models.Team;
import exceptions.TeamNotFoundException;

import javax.inject.Inject;
import java.util.List;

public class TeamDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public TeamDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Team save(Team team) {
        this.dynamoDBMapper.save(team);
        return team;
    }

    public Team getTeam(String id) {
        Team team = dynamoDBMapper.load(Team.class, id);
        if(team == null) {
            throw new TeamNotFoundException("The project with id: "+ id + "was not found");
        }
        return team;
    }

    public List<Team> getAllTeams() {
        return dynamoDBMapper.scan(Team.class, new DynamoDBScanExpression());
    }
}
