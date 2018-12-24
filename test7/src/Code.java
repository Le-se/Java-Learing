import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Code {
    int codeNum=0;//代码行数
    int fileNum=0;//文件数量
    public void count(String path){
        fileNum++;
        String str;
        try {
            BufferedReader br=new BufferedReader(new FileReader(path));
            while(true){
                str=br.readLine();
                if(str==null){
                    break;
                }
                codeNum++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
