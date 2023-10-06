package dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

@DynamoDBTable(tableName = "teams")
public class Team {
    private String id;
    private String name;
    private String dev1;
    private String dev2;
    private String dev3;
    private String dev4;

    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "dev1")
    public String getDev1() {
        return dev1;
    }

    public void setDev1(String dev1) {
        this.dev1 = dev1;
    }

    @DynamoDBAttribute(attributeName = "dev2")
    public String getDev2() {
        return dev2;
    }

    public void setDev2(String dev2) {
        this.dev2 = dev2;
    }

    @DynamoDBAttribute(attributeName = "dev3")
    public String getDev3() {
        return dev3;
    }

    public void setDev3(String dev3) {
        this.dev3 = dev3;
    }

    @DynamoDBAttribute(attributeName = "dev4")
    public String getDev4() {
        return dev4;
    }

    public void setDev4(String dev4) {
        this.dev4 = dev4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(name, team.name) && Objects.equals(dev1, team.dev1) && Objects.equals(dev2, team.dev2) && Objects.equals(dev3, team.dev3) && Objects.equals(dev4, team.dev4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dev1, dev2, dev3, dev4);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dev1='" + dev1 + '\'' +
                ", dev2='" + dev2 + '\'' +
                ", dev3='" + dev3 + '\'' +
                ", dev4='" + dev4 + '\'' +
                '}';
    }
}
