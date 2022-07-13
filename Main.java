import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class Main {

    static final int COUNT_THREAD = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        try {
            System.out.println("Task 1:\n");
            task_1();
            System.out.println("\n Task 2:\n");
            task_2_invokAny();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Finished");
    }

    public static void task_1() {
        ExecutorService execService = Executors.newFixedThreadPool(COUNT_THREAD);
        List<Future<String>> allFutures = new ArrayList<>();

        for (int i = 0; i < COUNT_THREAD; i++) {
            Future<String> future = execService.submit(new MyCallable());
            allFutures.add(future);
        }

        for (int i = 0; i < COUNT_THREAD; i++) {
            Future<String> future = allFutures.get(i);

            try {
                String result = future.get();
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        execService.shutdown();
    }

    public static void task_2_invokAny() throws ExecutionException, InterruptedException {
        ExecutorService execService = Executors.newFixedThreadPool(COUNT_THREAD);
        List<MyCallable> allFutures = new ArrayList<>();

        for (int i = 0; i < COUNT_THREAD; i++) {
            MyCallable myCallable = new MyCallable();
            allFutures.add(myCallable);
        }

        String result = execService.invokeAny(allFutures);
        System.out.println(result);

        execService.shutdown();
    }
}