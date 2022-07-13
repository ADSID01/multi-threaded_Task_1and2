import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    int min = 5;
    int max = 10;
    Random random = new Random();

    @Override
    public String call() throws Exception {
        int x = random.nextInt(max - min) + min;
        for (int i = 1; i <= x; i++) {
            Thread.sleep(1000);
            System.out.println("Сообщение " + String.valueOf(i) + " " + Thread.currentThread().getName());
        }
        return "Поток " + Thread.currentThread().getName() + ", кол-фо сообщений: " + String.valueOf(x);
    }
}
