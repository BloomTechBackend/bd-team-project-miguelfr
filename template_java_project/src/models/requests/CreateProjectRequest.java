package models.requests;

import dynamodb.models.Project;
import models.ProjectModel;
import models.TeamModel;

import java.util.Objects;

public class CreateProjectRequest {

    private String title;
    private  String description;
    private String course;
    private String gitUrl;
    private String websiteUrl;
    private Integer year;
    private String teamName;
    private String dev1;
    private String dev2;
    private String dev3;
    private String dev4;

    public CreateProjectRequest() {
    }

    private CreateProjectRequest(String title, String description, String course, String gitUrl, String websiteUrl, Integer year, String teamName, String dev1, String dev2, String dev3, String dev4) {
        this.title = title;
        this.description = description;
        this.course = course;
        this.gitUrl = gitUrl;
        this.websiteUrl = websiteUrl;
        this.year = year;
        this.teamName = teamName;
        this.dev1 = dev1;
        this.dev2 = dev2;
        this.dev3 = dev3;
        this.dev4 = dev4;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCourse() {
        return course;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public Integer getYear() {
        return year;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getDev1() {
        return dev1;
    }

    public String getDev2() {
        return dev2;
    }

    public String getDev3() {
        return dev3;
    }

    public String getDev4() {
        return dev4;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setDev1(String dev1) {
        this.dev1 = dev1;
    }

    public void setDev2(String dev2) {
        this.dev2 = dev2;
    }

    public void setDev3(String dev3) {
        this.dev3 = dev3;
    }

    public void setDev4(String dev4) {
        this.dev4 = dev4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateProjectRequest that = (CreateProjectRequest) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(course, that.course) && Objects.equals(gitUrl, that.gitUrl) && Objects.equals(websiteUrl, that.websiteUrl) && Objects.equals(year, that.year) && Objects.equals(teamName, that.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, course, gitUrl, websiteUrl, year, teamName);
    }

    @Override
    public String toString() {
        return "CreateProjectRequest{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", course='" + course + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", year=" + year +
                ", teamName='" + teamName + '\'' +
                ", dev1='" + dev1 + '\'' +
                ", dev2='" + dev2 + '\'' +
                ", dev3='" + dev3 + '\'' +
                ", dev4='" + dev4 + '\'' +
                '}';
    }
}
