import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final int SIZE = 1_000_000;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {

        int[] array = new int[SIZE];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        }

        ForkJoinPool pool = new ForkJoinPool();
        long result = pool.invoke(new SumTask(array, 0, array.length));

        System.out.println("Sum = " + result);
    }
}
