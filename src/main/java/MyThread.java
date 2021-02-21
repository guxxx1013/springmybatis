/**
 * @author quanju.gu
 * @date 2018/8/8
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(10*555);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread running");
    }
}
