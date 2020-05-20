package lesson5.HomeWork;

public class Main extends Thread {
    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;

    public static void main(String[] args) {
        float[] sarr = singlethread(SIZE);
        float[] darr = doublethread(SIZE, HALF);

  //      darr[9000000] = 0f;
        int s=0;
    for (int i =0; i<SIZE; i++){
        if (sarr[i] != darr[i]) {
            s++;
            System.out.println("id " + i + "->"+sarr[i]+ "!="+darr[i]);
        }
    }
    System.out.printf("Проверка массивов завершена. Обнаружено %s различий \n", s);
    }

    private static float[] doublethread(int size, int half) {
        float[] arr1 = new float[size];
        for (int i=0; i<size;i++){
            arr1[i] = 1f;
        }
        long startTime = System.currentTimeMillis();
        float [] a1 = new float[half];
        float [] a2 = new float[half];
        System.arraycopy(arr1, 0, a1, 0, half);
        System.arraycopy(arr1, half, a2, 0, half);

//        new Thread(() -> drillarray(0, half, a1), "t1").start();
//        new Thread(() -> drillarray(half, half, a2), "t2").start();

        Thread t1 = new Thread(() -> {
            drillarray(0, half, a1);
        });
        Thread t2 = new Thread(()->{
            drillarray(half, half,a2);
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1,0,arr1,0,half);
        System.arraycopy(a2,0,arr1,half,half);
        System.out.println("Двухпоточный метод потратил " + (System.currentTimeMillis() - startTime) + "ms.");

        return arr1;
    }

    private static float[] singlethread(int size) {
        float[] arr = new float[size];
        for (int i=0; i<size;i++){
            arr[i] = 1f;
        }
        long startTime = System.currentTimeMillis();
        drillarray(0, size, arr);
        System.out.println("Простой метод потратил " + (System.currentTimeMillis() - startTime) + "ms.");
        return arr;
    }

    public static void drillarray(int start, int size, float[] arr) {
        for (int i=0; i<size; i++){
            int j = i+start;
            arr[i]=(float)(arr[i]*Math.sin(0.2f+j/5)*Math.cos(0.2f+j/5)*Math.cos(0.4f+j/2));
        }
    }
}
