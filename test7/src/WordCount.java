import java.io.*;

public class WordCount {
    public static void main(String[] args) {
        File f=new File("article.txt");
        String sentence;
        int count=0;
        try {
            BufferedReader br=new BufferedReader(new FileReader(f));
            while (true){
                sentence=br.readLine();
                if(sentence==null){
                    break;
                }
                sentence=sentence.toLowerCase();
                int index=sentence.indexOf("hello");
                while(index>=0){
                    count++;
                    index=sentence.indexOf("hello",index+5);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("单词\"hello\"在文章\"article.txt\"中出现的次数为："+count);
    }
}
