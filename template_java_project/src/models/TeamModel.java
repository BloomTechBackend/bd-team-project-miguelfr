package src.models;

import src.dynamodb.models.Team;

import java.util.Objects;

public class TeamModel {
    private String id;
    private String name;
    private String dev1;
    private String dev2;
    private String dev3;
    private String dev4;

    private TeamModel(TeamBuilder teamBuilder) {
        this.id = teamBuilder.id;
        this.name = teamBuilder.name;
        this.dev1 = teamBuilder.dev1;
        this.dev2 = teamBuilder.dev2;
        this.dev3 = teamBuilder.dev3;
        this.dev4 = teamBuilder.dev4;
    }

    public TeamModel(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.dev1 = team.getDev1();
        this.dev2 = team.getDev2();
        this.dev3 = team.getDev3();
        this.dev4 = team.getDev4();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamModel teamModel = (TeamModel) o;
        return Objects.equals(id, teamModel.id) && Objects.equals(name, teamModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "TeamModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dev1='" + dev1 + '\'' +
                ", dev2='" + dev2 + '\'' +
                ", dev3='" + dev3 + '\'' +
                ", dev4='" + dev4 + '\'' +
                '}';
    }

    public static TeamBuilder builder() {
        return new TeamBuilder();
    }

    public static class TeamBuilder {
        private String id;
        private String name;
        private String dev1;
        private String dev2;
        private String dev3;
        private String dev4;

        public TeamBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public TeamBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public TeamBuilder withDev1(String dev1) {
            this.dev1 = dev1;
            return this;
        }

        public TeamBuilder withDev2(String dev2) {
            this.dev2 = dev2;
            return this;
        }

        public TeamBuilder withDev3(String dev3) {
            this.dev3 = dev3;
            return this;
        }

        public TeamBuilder withDev4(String dev4) {
            this.dev4 = dev4;
            return this;
        }

        public TeamModel build() {
            return new TeamModel(this);
        }
    }
}
