public class PrintLetter1 extends Thread{
    private char item='a';
    public void run(){
        while(item<='z'){
            System.out.print(item);
            item++;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PrintLetter1 sample=new PrintLetter1();
        Thread win=new Thread(sample);
        sample.run();
    }
}
