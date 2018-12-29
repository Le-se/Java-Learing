import java.io.*;

public class Code {
    int codeNum=0;//代码行数
    int fileNum=0;//文件数量
    public void countCode(String path){
        fileNum++;
        String str;
        try {
            BufferedReader br=new BufferedReader(new FileReader(path));
            while(true){
                str=br.readLine();
                if(str==null){
                    break;
                }
                codeNum++;//计算行数
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void countFile(String path){
        File f = new File(path);
        if(!f.exists()) return ;
        if(f.isFile()&&f.length()>0){
            String name=f.getName().substring(f.getName().lastIndexOf("."));
            if(".java".lastIndexOf(name)>-1){
                countCode(f.getAbsolutePath());
                fileNum++;
            }
        }
        else{
            File dir[] = f.listFiles();
            for(int i=0;i<dir.length;i++){
                countFile(dir[i].getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        Code sample=new Code();
        sample.countFile("d:/project/src");
        System.out.println("文件数："+sample.fileNum);
        System.out.println("代码行数："+sample.codeNum);
    }
}
