package Day11;

import java.io.*;
import java.util.concurrent.Executors;

public class JavaCmd {

    public static void main(String[] args) {

        JavaCmd jc = new JavaCmd();
        try {
            jc.cmd();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void cmd() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        boolean flag = true;

        while (flag){
            System.out.print("Bart Java Shell>");

            str = br.readLine();

            if(!str.equals("exit")){
                process(str);
            }else if(str.equals("exit")){
                System.out.println("종료합니다.");
                br.close();
                flag = false;
                System.exit(0);
            }
        }
    }

    public void process(String str) throws IOException{
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("cmd.exe", "/c", str);
        builder.directory(new File(System.getProperty("user.home")));
        Process process = builder.start();

        StreamGetter streamGetter = new StreamGetter(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGetter);

    }


}
