package lesson1.obstacles;

import lesson1.pretenders.Jumper;

public class Wall implements Obstacle {
    private int hight;

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public Wall(int hight) {
        this.hight = hight;
    }


    @Override
    public void printInfo() {
        System.out.println("Стена "+ this.hight+ "см ***********");

    }


}
