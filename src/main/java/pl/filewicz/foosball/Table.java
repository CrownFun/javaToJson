package pl.filewicz.foosball;

import java.util.Comparator;
import java.util.List;

public class Table {

    private String name;
    private List<Team> teams;

    public Table() {
    }

    public Table(String name, List<Team> teams) {
        this.name = name;
        this.teams = teams;
        updateTable();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }


    void updateTable(){
        teams.sort(Comparator.comparingInt(Team::getPoints).reversed());
        for(int i = 0;i<teams.size();i++){
            teams.get(i).setPosition(i+1);
        }

    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", teams=" + teams +
                '}';
    }
}
