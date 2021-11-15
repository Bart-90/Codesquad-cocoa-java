package Day11;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

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
                System.out.println(str + " 실행합니다.");
                ProcessBuilder builder = new ProcessBuilder();
                builder.command("cmd.exe", "/c", str);
                builder.directory(new File(System.getProperty("user.home")));
                Process process = builder.start();

                StreamGetter streamGetter = new StreamGetter(process.getInputStream(), System.out::println);
                Executors.newSingleThreadExecutor().submit(streamGetter);
            }else if(str.equals("exit")){
                System.out.println("종료합니다.");
                br.close();
                flag = false;
            }
        }
    }

    private static class StreamGetter implements Runnable{
        private InputStream inputstream;
        private Consumer<String> consumer;

        public StreamGetter(InputStream inputStream, Consumer<String> consumer){
            this.inputstream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            try {
                new BufferedReader(new InputStreamReader(inputstream, "MS949")).lines().forEach(consumer);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
    }

}
