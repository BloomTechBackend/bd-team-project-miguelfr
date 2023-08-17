package src.models;

import src.dynamodb.models.Project;

import java.util.Objects;

public class ProjectModel {
    private String id;
    private String title;
    private  String description;
    private String course;
    private String gitUrl;
    private String websiteUrl;
    private Integer year;
    private String teamId;

    private ProjectModel(ProjectModelBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.course = builder.course;
        this.gitUrl = builder.gitUrl;
        this.websiteUrl = builder.websiteUrl;
        this.year = builder.year;
        this.teamId = builder.teamId;
    }

    public ProjectModel(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.description = project.getDescription();
        this.course = project.getCourse();
        this.gitUrl = project.getGitUrl();
        this.websiteUrl = project.getWebsiteUrl();
        this.year = project.getYear();
        this.teamId = project.getTeamId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectModel that = (ProjectModel) o;
        return Objects.equals(id, that.id) && Objects.equals(gitUrl, that.gitUrl) && Objects.equals(websiteUrl, that.websiteUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gitUrl, websiteUrl);
    }

    @Override
    public String toString() {
        return "ProjectModel{" +
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

    public static ProjectModelBuilder builder(){
        return new ProjectModelBuilder();
    }
    public static class ProjectModelBuilder {
        private String id;
        private String title;
        private  String description;
        private String course;
        private String gitUrl;
        private String websiteUrl;
        private Integer year;
        private String teamId;

        public ProjectModelBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public ProjectModelBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ProjectModelBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ProjectModelBuilder withCourse(String course) {
            this.course = course;
            return this;
        }

        public ProjectModelBuilder withGitUrl(String gitUrl) {
            this.gitUrl = gitUrl;
            return this;
        }

        public ProjectModelBuilder withWebsiteUrl(String websiteUrl) {
            this.websiteUrl = websiteUrl;
            return this;
        }

        public ProjectModelBuilder withYear(Integer year) {
            this.year = year;
            return this;
        }

        public ProjectModelBuilder withTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }

        public ProjectModel build() {
            return new ProjectModel(this);
        }
    }
}
