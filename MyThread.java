public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                sleep(2500);
                System.out.println("Я поток " + Thread.currentThread().getName() + ". Всем привет!");
            }
        } catch (InterruptedException e) {

//        } finally{
//            System.out.printf("%s завершен\n", getName());
        }
    }
}
