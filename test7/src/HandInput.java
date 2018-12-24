import java.io.*;
import java.util.Scanner;

public class HandInput {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入文件路径与命名");
        File f = new File(s.next());
        if (f.exists()) {
            System.out.println("文件已存在！");
            return;
        }

        BufferedReader handin = new BufferedReader(new InputStreamReader(System.in));
        try {
            PrintWriter print = new PrintWriter(new FileWriter(f));
            while (true) {
                String item = handin.readLine();
                if (!item.equals("end#")) {
                    print.println(item);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
