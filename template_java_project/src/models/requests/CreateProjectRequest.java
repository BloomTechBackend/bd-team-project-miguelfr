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


    private CreateProjectRequest(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.course = builder.course;
        this.gitUrl = builder.gitUrl;
        this.websiteUrl = builder.websiteUrl;
        this.year = builder.year;
        this.teamName = builder.teamName;
        this.dev1 = builder.dev1;
        this.dev2 = builder.dev2;
        this.dev3 = builder.dev3;
        this.dev4 = builder.dev4;
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

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder {
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

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withCourse(String course) {
            this.course = course;
            return this;
        }

        public Builder withGitUrl(String gitUrl) {
            this.gitUrl = gitUrl;
            return this;
        }

        public Builder withWebsiteUrl(String websiteUrl) {
            this.websiteUrl = websiteUrl;
            return this;
        }

        public Builder withYear(Integer year) {
            this.year = year;
            return this;
        }

        public Builder withTeamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        public Builder withDev1(String dev1) {
            this.dev1 = dev1;
            return this;
        }

        public Builder withDev2(String dev2) {
            this.dev2 = dev2;
            return this;
        }

        public Builder withDev3(String dev3) {
            this.dev3 = dev3;
            return this;
        }

        public Builder withDev4(String dev4) {
            this.dev4 = dev4;
            return this;
        }

        public CreateProjectRequest build() {
            return new CreateProjectRequest(this);
        }
    }
}
