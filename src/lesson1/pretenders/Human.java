package lesson1.pretenders;

import lesson1.obstacles.Obstacle;
import lesson1.obstacles.Track;
import lesson1.obstacles.Wall;

public class Human implements Runner, Jumper, Pretender {
    private String name;
    private String color;
    private int age;
    private boolean eliminated = false;

    public boolean getEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    private int maxDistanceToRun;
    private int maxHightToJump;

    public Human(String name) {
        this.name = name;
        color="белый";
        age = 20;
        maxDistanceToRun = (int) (Math.random()*500+500);
        maxHightToJump = (int) (Math.random()*50+50);
    }

    public boolean run(Track track){
        if (maxDistanceToRun<(track.getLenght())){
            System.out.println("Человек " + name + " не пробежал дорожку и выбывает");
            eliminated = true;
            return false;
        }else {
            System.out.println("Человек " + name + " пробежал дорожку " + track.getLenght() + "м.");
        return true;
        }
    }

    public boolean jump(Wall wall){
        if (maxHightToJump<(wall.getHight())){
            System.out.println("Человек "+ name + " не перепрыгнул стену и выбывает");
            eliminated = true;
            return false;
        }else {
            System.out.println("Человек "+ name + " перепрыгнул стену " + wall.getHight() + "см.");
            return true;
        }
    }


    @Override
    public boolean tryToGet(Obstacle o) {

        if (o instanceof Wall){
            return this.jump((Wall) o);
        }else{
            if (o instanceof Track){
                return this.run((Track) o);
            }else{
                return false;
            }
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Человек " + name;
    }
}
