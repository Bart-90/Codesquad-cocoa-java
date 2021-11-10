package Day6;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountBook {

    public static void main(String[] args){

        AccountBook ab = new AccountBook();
        List<List<String>> loginArr = new ArrayList<>();
        List<List<String>> dataArr = new ArrayList<>();

        try {
            ab.frontMenu(loginArr,dataArr);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void frontMenu(List<List<String>> loginArr, List<List<String>> dataArr)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        boolean flag = true;


        while (flag) {

            System.out.println("가계부 앱이 실행되었습니다. 로그인 후 사용 가능합니다.");
            System.out.println("원하시는 메뉴에 해당하는 숫자를 입력해주세요.");
            System.out.println("1. 로그인 2. 사용자 등록 3. 종료 4. logRead 5. fileRead");
            str = br.readLine();

            switch (str) {
                case "1":
                    mainMenu(loginArr, dataArr);
                    break;
                case "2":
                    join(loginArr);
                    loginWrite(loginArr);
                    break;
                case "3":
                    System.out.println("앱이 종료됩니다.");
                    flag = false;
                    br.close();
                    break;
                case "4":
                    loginRead(loginArr);
                    break;
                case "5":
                    fileRead(dataArr);
                    break;
            }

        }

    }

    public void mainMenu(List<List<String>> loginArr, List<List<String>> dataArr) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        String str;

        if(login(loginArr)){
            while (flag) {
                System.out.println("가계부 앱이 실행되었습니다.");
                System.out.println("원하시는 메뉴에 해당하는 숫자를 입력해주세요.");
                System.out.println("1. 가계부 등록 2. 삭제 3. 전체자료 출력 4. 월별 자료 출력 5. 자료 저장 6. 로그아웃");
                str = br.readLine();
                switch (str) {
                    case "1":
                        input(dataArr);
                        break;
                    case "2":
                        remove(dataArr);
                        break;
                    case "3":
                        printBook(dataArr);
                        break;
                    case "4":
                        System.out.println("아직 미구현입니다.");
                        break;
                    case "5":
                        fileWrite(dataArr);
                        break;
                    case "6":
                        System.out.println("로그아웃됩니다.");
                        flag = false;
                        break;
                }
            }
        }
    }


    public void join(List<List<String>> loginArr) throws IOException {

        List<String> personal = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("사용자 등록");
        System.out.println("ID를 입력해주십시오.");
        String id = br.readLine();

        if (id.isBlank()) {
            System.out.println("공백은 입력할 수 없습니다.");
        } else if (!id.isBlank()) {
            for (int i = 0; i < loginArr.size(); i++){
                if(id.equals(loginArr.get(i).get(0))){
                    System.out.println("이미 존재하는 ID입니다.");
                    break;
                }
            }
            System.out.println("비밀번호를 입력해주십시오.");
            String pw = br.readLine();
            if (pw.isBlank()) {
                System.out.println("공백은 입력할 수 없습니다.");
            } else if (!pw.isBlank()) {
                personal.add(id);
                personal.add(pw);
                loginArr.add(personal);
                System.out.println("가입이 완료되었습니다, " + id + "님.");
            }

        }
    }




    public boolean login(List<List<String>> loginArr) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;

        System.out.println("LOGIN");
        System.out.println("ID를 입력해주십시오.");
        String id = br.readLine();
            if(id.isBlank()){
                System.out.println("공백은 입력할 수 없습니다.");
            }else if(!id.isBlank()){
                System.out.println("비밀번호를 입력해주십시오.");
                String pw = br.readLine();
                    if (pw.isBlank()){
                        System.out.println("공백은 입력할 수 없습니다.");
                    }else if (!pw.isBlank()){
                        if(loginArr.size() == 0){
                            System.out.println("정보가 존재하지 않습니다.");
                        }else if (loginArr.size() != 0){
                            for (int i = 0; i < loginArr.size(); i++) {
                                if (!loginArr.get(i).get(0).equals(id)) {
                                    System.out.println("등록되지 않은 ID입니다.");
                                } else if (loginArr.get(i).get(0).equals(id) && !loginArr.get(i).get(1).equals(pw)) {
                                    System.out.println("비밀번호가 일치하지 않습니다.");
                                } else if (loginArr.get(i).get(0).equals(id) && loginArr.get(i).get(1).equals(pw)) {
                                    System.out.println("로그인 성공했습니다. 환영합니다, " + id + "님.");
                                    flag = true;
                                }
                            }
                        }
                    }

            }

        return flag;
    }



    public void input(List<List<String>> dataArr) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> arr = new ArrayList<>();

        System.out.println("날짜를 입력해 주십시오. ex)2021.11.08");
        String date = br.readLine();
        System.out.println("메모를 입력해 주십시오.");
        String memo = br.readLine();
        System.out.println("수입금액을 입력해 주십시오.");
        String income = br.readLine();
        System.out.println("지출금액을 입력해 주십시오.");
        String outcome = br.readLine();

        if(dataArr.size() == 0){
            arr.add("1");
        }else if(dataArr.size() != 0) {
            int num = Integer.parseInt(dataArr.get(dataArr.size()-1).get(0));
            arr.add(Integer.toString(num + 1));
        }
        arr.add(date);
        arr.add(memo);
        arr.add(income);
        arr.add(outcome);
        dataArr.add(arr);

        System.out.println("자료 입력을 완료했습니다.");

    }

    public void loginWrite(List<List<String>> loginArr) throws IOException {

        String directory = "c:\\AccountBook\\register.csv";

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        for (int i = 0; i < loginArr.size(); i++) {
            for (int j = 0; j < loginArr.get(i).size(); j++) {
                bw.write(loginArr.get(i).get(j)+",");
                if(j == loginArr.get(i).size()-1){
                    bw.newLine();
                }
            }
        }

        bw.flush();
        bw.close();

    }

    public void loginRead(List<List<String>> loginArr) throws IOException {

        List<String> arr = new ArrayList<>();
        List<String> personal = new ArrayList<>();
        String directory = "c:\\AccountBook\\register.csv";
        ArrayList<String> pi = new ArrayList<>();
        BufferedReader br = Files.newBufferedReader(Paths.get(directory), Charset.forName("MS949"));

        while(true){
            String line = br.readLine();
            arr.add(line);
            if(line == null) break;
        }

        /*for(int i = 0; i < arr.size(); i++){
               String[] temp = arr.get(i).split(",");
               for(int j = 0; j< temp.length; j++) {
                   personal.add(temp[j]);
               }
            loginArr.add(personal);
        }*/



        System.out.println(arr);
       //System.out.println(loginArr);


    }

    public void fileWrite(List<List<String>> dataArr) throws IOException {


        String directory = "c:\\AccountBook\\accountbook.csv";

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        for (int i = 0; i < dataArr.size(); i++) {
            for (int j = 0; j < dataArr.get(i).size(); j++) {
                bw.write(dataArr.get(i).get(j)+",");
                if(j == dataArr.get(i).size()-1){
                    bw.newLine();
                }
            }
        }

        bw.flush();
        bw.close();

        System.out.println("저장이 완료되었습니다.");
    }

    public void fileRead(List<List<String>> dataArr) throws IOException {

        String directory = "c:\\AccountBook\\accountbook.csv";
        ArrayList<String> pi = new ArrayList<>();
        BufferedReader br = Files.newBufferedReader(Paths.get(directory), Charset.forName("MS949"));

        while (true){
            String line = br.readLine();
            if(line == null) break;
            System.out.println(line);
        }

    }

    public void remove(List<List<String>> arr) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("삭제할 자료 번호를 입력하십시오.");
        String num = br.readLine();

        if(arr.size() == 0) {
            System.out.println("삭제 가능한 자료가 존재하지 않습니다.");
        }else if(arr.size() != 0) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).get(0).equals(num)) {
                    arr.remove(Integer.parseInt(num) - 1);
                    System.out.println(num + "번 자료가 삭제되었습니다.");
                } else if (!arr.get(i).get(0).equals(num)) {
                    System.out.println("해당 자료가 존재하지 않습니다.");
                }
            }
        }

    }

    public void print(List<List<String>> arr) throws IOException{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Date date1;

        for(int i = 0; i < arr.size(); i++){
            try {
                date = sdf.parse(arr.get(i).get(1));
                System.out.println(sdf1.format(date));

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    public void printBook(List<List<String>> arr){

        if(arr.size() == 0){
            System.out.println("등록된 자료가 없습니다.");
        }else if(arr.size() != 0){
            System.out.println("순번       날짜          적요           수입           지출          잔액");
            System.out.println("----------------------------------------------------------------------");
            for(int i = 0; i < arr.size(); i++){
                System.out.print(arr.get(i).get(0)+ "     " + arr.get(i).get(1) + "       " + arr.get(i).get(2) + "         " + arr.get(i).get(3) + "          " + arr.get(i).get(4) + "\n");
            }
        }


    }

}
