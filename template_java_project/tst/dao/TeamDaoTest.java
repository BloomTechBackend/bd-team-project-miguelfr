package dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.DynamoDbClientProvider;
import dynamodb.dao.TeamDao;
import dynamodb.models.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.ProjectServiceUtils;

import static org.junit.jupiter.api.Assertions.*;

class TeamDaoTest {
    Team team;
    DynamoDBMapper dynamoDBMapper;
    TeamDao teamDao;

    @BeforeEach
    void setUp() {
        team = new Team();
        team.setId(ProjectServiceUtils.generateTeamId());
        dynamoDBMapper = new DynamoDBMapper(DynamoDbClientProvider.REMOTE_CLIENT);
        teamDao = new TeamDao(dynamoDBMapper);
    }

    @Test
    void save() {
        //Given
        team.setName("The ABCD");
        team.setDev1("A");
        team.setDev2("B");
        team.setDev3("C");
        team.setDev4("D");

        //when
        Team team1 = teamDao.save(team);

        //Then
        assertEquals(team.getName(),team1.getName());

    }

    @Test
    void getTeam() {
        //Given
        String id = "82U8I";

        //when
        Team team1 = teamDao.getTeam(id);

        //Then
        assertNotNull(team1);
        assertEquals(id,team1.getId());
        System.out.println(team1.getName());
    }
}