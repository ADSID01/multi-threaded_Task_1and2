import static java.lang.Thread.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("my_group");
        MyThread myThread = new MyThread();
        System.out.println("Создаю потоки...");
        for (int i = 1; i < 5; i++){
            createThread(threadGroup,myThread,String.valueOf(i));
        }

        sleep(15000);
        threadGroup.interrupt();
        System.out.println("Завершаю все потоки...");
    }

    public static void createThread(ThreadGroup threadGroup, MyThread myThread, String index){
        Thread thread = new Thread(threadGroup,myThread,index);
        thread.start();
    }
}