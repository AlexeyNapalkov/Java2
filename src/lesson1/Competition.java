package lesson1;

import lesson1.obstacles.Obstacle;
import lesson1.obstacles.Track;
import lesson1.obstacles.Wall;
import lesson1.pretenders.Cat;
import lesson1.pretenders.Human;
import lesson1.pretenders.Pretender;
import lesson1.pretenders.Robot;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Competition {
    private List<Pretender> pretenders = new LinkedList<>();
    private List<Obstacle> obstacles = new LinkedList<>();
    private List<Pretender> winers = new LinkedList<>();

    public void prepareCompetition(){
        // регистрация участников в лист претендентов
        pretenders.add(new Human("Ivanhoe"));
        pretenders.add(new Human("John"));
        pretenders.add(new Human("Barack"));
        pretenders.add(new Cat("Leon"));
        pretenders.add(new Robot());
        pretenders.add(new Robot());
        pretenders.add(new Robot());

        // генерация препядствий
        Random random = new Random();

        obstacles.add(new Track((random.nextInt(30)+1)*10));
        obstacles.add(new Wall((random.nextInt(5)+1)*5));
        obstacles.add(new Track((random.nextInt(40)+1)*10));
        obstacles.add(new Wall((random.nextInt(10)+1)*10));

        // очистка списка победителей
        winers.clear();
    }

    public void startCompetition() {

        //допуск всех участников к соревнованию

        System.out.println("************ Соревнования начинаются ************");
        for (Obstacle o : obstacles) {
            System.out.print("*****  Препядствие *******    ");
            o.printInfo();
            winers.clear();
            for (Pretender p : pretenders) {
                if (!p.getEliminated()){ // если претендент выбыл, то он не допускается к препядствию
                    if (p.tryToGet(o)) {
                        winers.add(p);
                    }
                }
            }

        }
        System.out.println("************* Соревнования завершены ***************");
        System.out.println("Список претендентов, прошедших соревнования:");
        for (Pretender p:winers){
            System.out.println(p.toString());
        }
    }
}