package lesson2;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
        int SIZE = 3;// переменная для изменения размерности массива.
        String DATA = "е0";// ошибочное значение ячейки массива

        String[][] myArray = new String[4][SIZE];
        int summ = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < SIZE; j++) {
                myArray[i][j] = Integer.toString((i + j));
                myArray[2][2] = DATA;
                System.out.print(" | " + myArray[i][j] + " | ");
            }
            System.out.println();

        }
    try {
            System.out.println("Сумма элементов масива = "+ myArrayChecker(myArray));

    }catch (MyArrayDataExeption e){
        System.out.println(e.getMessage() + e.getCoordinates());
    }catch (MyArraySizeExeption e){
        System.out.println(e.getMessage());
    }


    }

    private static int myArrayChecker(String[][] myArray) throws MyArraySizeExeption, MyArrayDataExeption {
        int sum=0;

            if (myArray.length != 4) {
                throw new MyArraySizeExeption("допустимый размер массива 4х4");
            }
            for (int i = 0; i < 4; i++) {
                if (myArray[i].length != 4) {
                    throw new MyArraySizeExeption("допустимый размер массива 4х4");
                }
            }

        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                    try {
                        sum += Integer.parseInt(myArray[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataExeption("невозможно преобразовать в число значение ячейки ", i, j);
                    }
            }
        }
        return sum;
    }
}
