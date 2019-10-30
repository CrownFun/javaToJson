package pl.filewicz.foosball;

public class Game {

    private static final int DRAW = 1;
    private static final int WIN = 3;

    void encounter(Team host, Team visitor, Result result) {

        host.setPlayed(host.getPlayed() + DRAW);
        visitor.setPlayed(visitor.getPlayed() + DRAW);

        if (result.getHostPoints() == result.getVisitorPoints()) {
            host.setPoints(host.getPoints() + DRAW);
            host.setGoalsScored(host.getGoalsScored() + result.getHostPoints());
            host.setGoalsConceded(host.getGoalsConceded() + result.getVisitorPoints());
            visitor.setPoints(visitor.getPoints() + DRAW);
            visitor.setGoalsScored(result.getVisitorPoints());
            visitor.setGoalsConceded(result.getHostPoints());
        } else if (result.getHostPoints() > result.getVisitorPoints()) {
            host.setPoints(host.getPoints() + WIN);
            host.setGoalsScored(host.getGoalsScored() + result.getHostPoints());
            host.setGoalsConceded(host.getGoalsConceded() + result.getVisitorPoints());
            visitor.setGoalsScored(visitor.getGoalsScored() + result.getVisitorPoints());
            visitor.setGoalsConceded(visitor.getGoalsConceded() + result.getHostPoints());
        } else {
            host.setGoalsScored(host.getGoalsScored() + result.getHostPoints());
            host.setGoalsConceded(host.getGoalsConceded() + result.getVisitorPoints());
            visitor.setPoints(visitor.getPoints() + WIN);
            visitor.setGoalsScored(visitor.getGoalsScored() + result.getVisitorPoints());
            visitor.setGoalsConceded(visitor.getGoalsConceded() + result.getHostPoints());
        }
    }
}
