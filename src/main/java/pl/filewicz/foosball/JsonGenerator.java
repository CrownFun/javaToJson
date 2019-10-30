package pl.filewicz.foosball;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonGenerator {

    private static List<Team> createTeams() {

        Player player1 = new Player("Joe", "Doe", 34);
        Player player2 = new Player("Sam", "Smith", 27);

        List<Player> players1 = new ArrayList<>();
        players1.add(new Player(player1.getName(), player1.getLastname(), player1.getAge()));
        players1.add(new Player(player2.getName(), player2.getLastname(), player2.getAge()));

        Player player3 = new Player("Edward", "Fresh", 21);
        Player player4 = new Player("William", "Stroke", 29);

        List<Player> players2 = new ArrayList<>();
        players2.add(new Player(player3.getName(), player3.getLastname(), player3.getAge()));
        players2.add(new Player(player4.getName(), player4.getLastname(), player4.getAge()));

        Team team1 = new Team("Javatar", players1);
        Team team2 = new Team("Blinders", players2);

        List<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);

        return teams;
    }

    private static void play(Table table) {
        Game game = new Game();

        Team team1 = table.getTeams().get(0);
        Team team2 = table.getTeams().get(1);

        game.encounter(team1, team2, new Result(1, 3));
        table.updateTable();

        game.encounter(team1, team2, new Result(1, 5));
        table.updateTable();
    }

    public static void main(String[] args) {

        List<Team> teams = createTeams();

        Table table = new Table("Table A", teams);

        play(table);

        List<Table> tables = new ArrayList<>();
        tables.add(table);

        Tournament tournament = new Tournament("LONDON INTERNATIONAL TOURNAMENT", tables, "The Open Singles winner of each International tournament is automatically qualified for the World Championships taking place in Rome, Italy, October 25-28, 2020");

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            objectMapper.writeValue(new File("tournament.json"), tournament);

            String jsonPretty = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(tournament);
            System.out.println(jsonPretty);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
