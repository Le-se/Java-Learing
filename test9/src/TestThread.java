public class TestThread {
    public static void main(String[] args) {
        PrintThread pt1=new PrintThread();
        PrintThread pt2=new PrintThread();
        Thread pt1s=new Thread(pt1);
        Thread pt2s=new Thread(pt2);
        pt1s.setName("线程1");
        pt2s.setName("线程2");
        pt1s.start();
        pt2s.start();
    }
}
