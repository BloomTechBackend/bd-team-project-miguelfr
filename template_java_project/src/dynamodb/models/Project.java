package dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

@DynamoDBTable(tableName = "projects")
public class Project {
    private String id;
    private String title;
    private  String description;
    private String course;
    private String gitUrl;
    private String websiteUrl;
    private Integer year;
    private String teamId;

    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute(attributeName = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBAttribute(attributeName = "course")
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @DynamoDBAttribute(attributeName = "gitUrl")
    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    @DynamoDBAttribute(attributeName = "websiteUrl")
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    @DynamoDBAttribute(attributeName = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @DynamoDBAttribute(attributeName = "teamId")
    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(title, project.title) && Objects.equals(description, project.description) && Objects.equals(course, project.course) && Objects.equals(gitUrl, project.gitUrl) && Objects.equals(websiteUrl, project.websiteUrl) && Objects.equals(year, project.year) && Objects.equals(teamId, project.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, course, gitUrl, websiteUrl, year, teamId);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", course='" + course + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", year=" + year +
                ", teamId='" + teamId + '\'' +
                '}';
    }
}
