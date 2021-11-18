package Day12;

import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class JavaShell {

    public static void main(String[] args) {

        JavaShell js = new JavaShell();
        try {
            js.mainMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void mainMenu() throws IOException, InterruptedException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        while (flag){
            System.out.print("Bart Java Shell>");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] strs = new String[st.countTokens()];
            for(int i = 0; i <= st.countTokens(); i++){
                strs[i] = st.nextToken();
            }

            if(strs.length == 0){
                strs[0] = "";
            }

            switch (strs[0]){
                case "dir" : showFolder(); break;
                case "pwd" : showPath(); break;
                case "open" : openFile(strs[1]); break;
                case "mk" : makeFile(strs[1]); break;
                case "mkdir" : makeFolder(strs[1]); break;
                case "rename" : rename(strs[1],strs[2]); break;
                case "del" : delete(strs[1]); break;
                case "exit" : flag = false; break;
            }
        }
    }



    public void showFolder(){

        File dir = new File(System.getProperty("user.home"));
        System.out.println("디렉토리의 파일들 출력합니다.");
        if(dir.isDirectory()){
            String fileList[] = dir.list();
            for(int i = 0; i < fileList.length; i++){
                System.out.println(fileList[i]);
            }
        }
    }

    public void showPath() {
        System.out.println(System.getProperty("user.home"));
    }

    private void openFile(String str) throws IOException{

        Desktop.getDesktop().edit(new File("C:\\Users\\Moon\\" + str));

    }

    public void makeFile(String str) throws IOException{

        File dir = new File("C:\\Users\\Moon\\" + str);
        boolean result = dir.createNewFile();
        if(result){
            System.out.println(str + "파일이 생성되었습니다.");
        }

    }

    public void makeFolder(String str) throws IOException{

        File dir = new File("C:\\Users\\Moon\\" + str);
        boolean result = dir.mkdir();
        if(result){
            System.out.println(str + "폴더가 생성되었습니다.");
        }

    }

    private void rename(String str1, String str2) {

        File dir = new File("C:\\Users\\Moon\\" + str1);
        boolean result = dir.renameTo(new File("C:\\Users\\Moon\\"+str2));
        if(result){
            System.out.println("파일명이 " + str1 + "에서 " + str2 + "로 변경됩니다.");
        }

    }

    private void delete(String str) {

        File dir = new File("C:\\Users\\Moon\\" + str);
        boolean flag = false;

        if(dir.isDirectory()){
            flag = true;
        }

        boolean result = dir.delete();

        if(result){
            if(flag){
                System.out.println(str + "폴더가 삭제되었습니다.");
            }else if(!flag){
                System.out.println(str + "파일이 삭제되었습니다.");
            }
        }

    }
}
