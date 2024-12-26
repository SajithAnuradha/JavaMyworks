import java.util.HashMap;
import java.util.List;

abstract class Person {

    private String name;

    Person(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

}

class Scoreboard {
    HashMap<String, Integer> scores = new HashMap<String, Integer>();

    Scoreboard(List<String> names) {
        for (String name : names) {
            scores.put(name, 0);
        }
    }

    public void displayScoreboard() {
        System.out.println("Scoreboard");
        for (String name : scores.keySet()) {
            System.out.println(name + " : " + scores.get(name));
        }
    }

    public void touchPad(Swimmers swimmer, int score) {
        updateScore(swimmer.getName(), score);

    }

    private void updateScore(String name, int score) {
        scores.put(name, scores.get(name) + score);
    }

}

class Swimmers extends Person {
    String gender;

    Swimmers(String name, String gender) {
        super(name);
        this.gender = gender;

    }

    public void StartSwimming() {
        System.out.println("Swimming started by " + getName());
    }

    public void StopSwimming() {

        System.out.println("Swimming stopped by " + getName());

    }

}

class Spectators extends Person {

    Spectators(String name) {
        super(name);

    }

}

class judge extends Person {

    judge(String name) {
        super(name);

    }

    public void blowWhistle() {
        System.out.println("Whistle blown by " + getName());
    }

}

class SuuportStaff extends Person {

    SuuportStaff(String name) {
        super(name);

    }

}

public class SwimmingSimulate {

    public static void main(String[] args) {

        Swimmers swimmer1 = new Swimmers("Swimmer1", "Male");
        Swimmers swimmer2 = new Swimmers("Swimmer2", "Female");
        Scoreboard scoreboard = new Scoreboard(List.of("Swimmer1", "Swimmer2"));

        // add a for loop and start them and add a finishing time also

        judge judge1 = new judge("Judge1");
        judge1.blowWhistle();
        swimmer1.StartSwimming();
        swimmer2.StartSwimming();

        Scoreboard.touchPad(swimmer1, 10);
        Scoreboard.touchPad(swimmer2, 20);

    }
}