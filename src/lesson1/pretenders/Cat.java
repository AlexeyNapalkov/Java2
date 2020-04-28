package lesson1.pretenders;

import lesson1.obstacles.Obstacle;
import lesson1.obstacles.Track;
import lesson1.obstacles.Wall;

public class Cat implements Runner, Jumper, Pretender {
    private String name;
    private String color;
    private int age;
    private int maxDistanceToRun;
    private int maxHightToJump;

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    private boolean eliminated=false;

    public boolean getEliminated() {
        return eliminated;
    }

    public Cat(String name) {
        this.name = name;
        color="серый";
        age = 2;
        maxDistanceToRun = (int) (Math.random()*10+300);
        maxHightToJump = (int) (Math.random()*20+100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMaxDistanceToRun() {
        return maxDistanceToRun;
    }

    public void setMaxDistanceToRun(int maxDistanceToRun) {
        this.maxDistanceToRun = maxDistanceToRun;
    }

    public int getMaxHightToJump() {
        return maxHightToJump;
    }

    public void setMaxHightToJump(int maxHightToJump) {
        this.maxHightToJump = maxHightToJump;
    }

    @Override
    public String toString() {
        return "Кот" + name;
    }

    public boolean run(Track track){
        if (maxDistanceToRun<(track.getLenght())){
            System.out.println("Кот " + name + " не пробежал дорожку и выбывает");
            eliminated = true;
            return false;
        }else {
            System.out.println("Кот " + name + " пробежал дорожку " + track.getLenght() + "м.");
            return true;
        }
    }

    public boolean jump(Wall wall){
        if (maxHightToJump<(wall.getHight())){
            System.out.println("Кот "+ name + " не перепрыгнул стену и выбывает");
            eliminated = true;
            return false;
        }else {
            System.out.println("Кот "+ name + " перепрыгнул стену " + wall.getHight() + "см.");
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
}
