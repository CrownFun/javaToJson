package pl.filewicz.foosball;

import java.util.List;

public class Tournament {
    private String name;
    private String description;
    private List<Table> tables;


    public Tournament(String name, List<Table> tables, String description) {
        this.name = name;
        this.tables = tables;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "name='" + name + '\'' +
                ", tables=" + tables +
                ", description='" + description + '\'' +
                '}';
    }
}
