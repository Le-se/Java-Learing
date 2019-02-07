public class PrintThread extends Thread {
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(currentThread().getName()+"正在运行");
        }
    }
}
