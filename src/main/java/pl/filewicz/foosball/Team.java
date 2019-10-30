package pl.filewicz.foosball;

import java.util.List;

public class Team {
    private int position;
    private String temaName;
    private List<Player> players;
    private int played;
    private int points;
    private int goalsScored;
    private int goalsConceded;


    public Team(String temaName, List<Player> players) {
        this.temaName = temaName;
        this.players = players;
    }

    public String getTemaName() {
        return temaName;
    }

    public void setTemaName(String temaName) {
        this.temaName = temaName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    @Override
    public String toString() {
        return "Team{" +
                "position=" + position +
                ", temaName='" + temaName + '\'' +
                ", players=" + players +
                ", played=" + played +
                ", points=" + points +
                ", goalsScored=" + goalsScored +
                ", goalsConceded=" + goalsConceded +
                '}';
    }
}
