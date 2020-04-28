package lesson1.pretenders;

import lesson1.obstacles.Obstacle;

public interface Pretender {
    boolean tryToGet (Obstacle o);
    String getName();
    boolean getEliminated();
    void setEliminated(boolean eliminated);
}
