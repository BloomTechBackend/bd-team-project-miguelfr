package models;

import dynamodb.models.Project;

import java.util.Objects;

public class ProjectModel {
    private String id;
    private String title;
    private Integer year;


    private ProjectModel(ProjectModelBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.year = builder.year;

    }

    public ProjectModel(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.year = project.getYear();

    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Integer getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectModel that = (ProjectModel) o;
        return Objects.equals(id, that.id) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year);
    }

    @Override
    public String toString() {
        return "ProjectModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +

                ", year=" + year +

                '}';
    }

    public static ProjectModelBuilder builder(){
        return new ProjectModelBuilder();
    }
    public static class ProjectModelBuilder {
        private String id;
        private String title;

        private Integer year;

        public ProjectModelBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public ProjectModelBuilder withTitle(String title) {
            this.title = title;
            return this;
        }



        public ProjectModelBuilder withYear(Integer year) {
            this.year = year;
            return this;
        }


        public ProjectModel build() {
            return new ProjectModel(this);
        }
    }
}
