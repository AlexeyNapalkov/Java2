package lesson3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class HomeWork {
    public static void main(String[] args){
//        task1();
        task2();
    }

    private static void task1() {
        // 1. Создать массив с набором слов (10-20 с повторениями).
        // Найти и вывести список уникальных слов.
        // посчитать сколько раз встечается каждое слово.

        String[] words = new String[]{"Метод", "экземпляра", "получит", "прямой", "доступ", "к", "методам", "экземпляра", "и", "переменным", "Метод", "экземпляра", "будет", "обращаться", "к", "статическим", "переменным", "и", "статическим", "методам", "напрямую",
                "Статические", "методы", "будут", "обращаться", "к", "статическим", "переменным", "и", "методам", "напрямую"};
        HashSet<String> hs = new HashSet<String>(Arrays.asList(words));
        System.out.println(hs);
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (String s:hs){
            int counter = 0;
              for (int i = 0; i<words.length; i++){
                  if (words[i].equals(s)){
                      counter++;
                  }
              }
            hm.put(s, counter);
            System.out.printf("'%s' встречается %d раз \n", s, counter);
        }
    }

    private static void task2() {
//        Написать простой класс Телефонный Справочник,
//        который хранит в себе список фамилий и телефонных номеров.
//        В этот телефонный справочник с помощью метода add() можно добавлять записи,
//        а с помощью метода get() искать номер телефона по фамилии. Следует учесть,
//        что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//        тогда при запросе такой фамилии должны выводиться все телефоны.
        PhoneList MyPhoneList = new PhoneList();

        MyPhoneList.add("+79154885030", "Байков" );
        MyPhoneList.add("+79104254511", "Напалков");
        MyPhoneList.add("+79035708059", "Напалков");

        MyPhoneList.get("Напалков");

    }
}
