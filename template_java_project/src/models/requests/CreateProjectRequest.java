package models.requests;

import dynamodb.models.Project;
import models.ProjectModel;
import models.TeamModel;

import java.util.Objects;

public class CreateProjectRequest {

    private String title;
    private Integer year;

    public CreateProjectRequest() {
    }

    private CreateProjectRequest(Builder builder) {
        this.title = builder.title;
        this.year = builder.year;
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
        CreateProjectRequest that = (CreateProjectRequest) o;
        return Objects.equals(title, that.title)  && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }

    @Override
    public String toString() {
        return "CreateProjectRequest{" +
                "title='" + title + '\'' +
                ", year=" + year +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder {
        private String title;
        private Integer year;


        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withYear(Integer year) {
            this.year = year;
            return this;
        }

        public CreateProjectRequest build() {
            return new CreateProjectRequest(this);
        }
    }
}
