package lesson1.pretenders;

import lesson1.obstacles.Obstacle;
import lesson1.obstacles.Track;
import lesson1.obstacles.Wall;

public class Robot implements Runner, Jumper, Pretender {
    static int robotNumerator;
    private int robotID;
    private String name;
    private int maxDistanceToRun;
    private int maxHightToJump;
    private boolean eliminated=false;

    public boolean getEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    public Robot() {
        robotID = robotNumerator++;
        maxDistanceToRun = 400;
        maxHightToJump =10;
        name = "Робот№"+robotID;
    }

    public int getRobotID() {
        return robotID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean run(Track track){
        if (maxDistanceToRun<(track.getLenght())){
            System.out.println("Робот " + robotID + " не пробежал дорожку и выбывает");
            eliminated = true;
            return false;
        }else {
            System.out.println("Робот " + robotID + " пробежал дорожку " + track.getLenght() + "м.");
            return true;
        }
    }

    public boolean jump(Wall wall){
        if (maxDistanceToRun<(wall.getHight())){
            System.out.println("Робот " + robotID + " не перепрыгнул стену и выбывает");
            eliminated = true;
            return false;
        }else {
            System.out.println("Робот " + robotID + " перепрыгнул стену " + wall.getHight() + "см.");
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
    @Override
    public String toString() {
        return name;
    }
}
