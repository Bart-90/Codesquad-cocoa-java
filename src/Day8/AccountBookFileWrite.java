package Day8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class AccountBookFileWrite {

    public static void main(String[] args){

        AccountBookFileWrite abfw = new AccountBookFileWrite();

        try {
            abfw.frontMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void frontMenu()throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        boolean flag = true;


        while (flag) {

            System.out.println("가계부 앱이 실행되었습니다. 로그인 후 사용 가능합니다.");
            System.out.println("원하시는 메뉴에 해당하는 숫자를 입력해주세요.");
            System.out.println("1. 로그인 2. 사용자 등록 3. 종료 4. 사용자 정보 불러오기");
            try {
                str = br.readLine();
            }catch (Exception e){
                System.out.println("숫자를 제대로 입력해 주십시오.");
            }

            switch (str) {
                case "1":
                    mainMenu(loginRead(),dataRead());
                    break;
                case "2":
                    loginWrite(join(loginRead()));
                    break;
                case "3":
                    System.out.println("앱이 종료됩니다.");
                    flag = false;
                    br.close();
                    break;
                case "4":
                    loginRead();
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
                System.out.println("1. 가계부 등록 2. 전체자료 출력 3. 월별 자료 출력 4. 로그아웃");
                str = br.readLine();
                switch (str) {
                    case "1":
                        dataWrite(input(dataRead()));
                        break;
                    case "2":
                        printBook(dataRead());
                        break;
                    case "3":
                        System.out.println("아직 미구현입니다.");
                    case "4":
                        System.out.println("로그아웃됩니다.");
                        flag = false;
                        break;
                }
            }
        }
    }


    public List<String> join(List<List<String>> loginArr) throws IOException {

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
                System.out.println("가입이 완료되었습니다, " + id + "님.");
                personal.add(id);
                personal.add(pw);
            }

        }

        return personal;
    }




    public boolean login(List<List<String>> loginArr) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        String msg = "";

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
                        if (loginArr.get(i).get(0).equals(id) && loginArr.get(i).get(1).equals(pw)) {
                            msg = "로그인 성공했습니다. 환영합니다, " + id + "님.";
                            flag = true;
                        }else if (loginArr.get(i).get(0).equals(id) && !loginArr.get(i).get(1).equals(pw)) {
                                msg = "비밀번호가 일치하지 않습니다.";
                        }else if (!loginArr.get(i).get(0).equals(id)) {
                            msg = "등록되지 않은 ID입니다.";
                        }
                    }
                }
            }

        }

        System.out.println(msg);
        return flag;
    }



    public List<String> input(List<List<String>> dataArr) throws IOException {

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

        System.out.println("자료 입력을 완료했습니다.");

        return arr;
    }

    public void loginWrite(List<String> loginArr) throws IOException {

        String directory = "c:\\AccountBook\\register.csv";

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        for(int i = 0; i < loginArr.size(); i++){
            bw.write(loginArr.get(i));
            if(i<loginArr.size()-1){
                bw.write(",");
            }
        }
        bw.newLine();

        bw.flush();
        bw.close();

    }

    public List<List<String>> loginRead() throws IOException {

        List<List<String>> arrs = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        List<String> personal;
        String directory = "c:\\AccountBook\\register.csv";
        ArrayList<String> pi = new ArrayList<>();
        BufferedReader br = Files.newBufferedReader(Paths.get(directory), Charset.forName("MS949"));

        while(true){
            String line = br.readLine();
            arr.add(line);
            if(line == null) break;
        }

        for(int i = 0; i < arr.size()-1; i++){
            personal = Arrays.asList(arr.get(i).split(","));
            arrs.add(personal);
        }


        return arrs;
    }

    public void dataWrite(List<String> dataArr) throws IOException {


        String directory = "c:\\AccountBook\\accountbook.csv";

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        for(int i = 0; i < dataArr.size(); i++){
            bw.write(dataArr.get(i));
            if(i<dataArr.size()-1){
                bw.write(",");
            }
        }
        bw.newLine();

        bw.flush();
        bw.close();

        System.out.println("저장이 완료되었습니다.");

    }

    public List<List<String>> dataRead() throws IOException {

        List<List<String>> arrs = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        List<String> personal;
        String directory = "c:\\AccountBook\\accountbook.csv";
        ArrayList<String> pi = new ArrayList<>();
        BufferedReader br = Files.newBufferedReader(Paths.get(directory), Charset.forName("MS949"));

        while(true){
            String line = br.readLine();
            arr.add(line);
            if(line == null) break;
        }

        for(int i = 0; i < arr.size()-1; i++){
            personal = Arrays.asList(arr.get(i).split(","));
            arrs.add(personal);
        }


        return arrs;
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
        LocalDate date;
;


//        for(int i = 0; i < arr.size(); i++){
//            try {
//                date = sdf.parse(arr.get(i).get(1));
//                System.out.println(sdf1.format(date));
//
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }

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
