package lesson1.obstacles;

import lesson1.pretenders.Runner;

public class Track implements Obstacle {
    private int lenght;

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public Track(int lenght) {
        this.lenght = lenght;
    }


    @Override
    public void printInfo() {
        System.out.println("Дорожка "+ this.lenght+ "м ***********");

    }
}
