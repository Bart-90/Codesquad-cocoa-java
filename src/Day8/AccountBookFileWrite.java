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
import java.time.LocalDate;
import java.util.*;

public class AccountBookFileWrite {

    public static void main(String[] args){

        AccountBookFileWrite abfw = new AccountBookFileWrite();

        try {
            abfw.frontMenu();
        } catch (IOException | ParseException e) {
            e.printStackTrace();

        }

    }

    public void frontMenu() throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        boolean flag = true;


        while (flag) {
            makeLoginFile();
            System.out.println("가계부 앱이 실행되었습니다. 로그인 후 사용 가능합니다.");
            System.out.println("원하시는 메뉴에 해당하는 숫자를 입력해주세요.");
            System.out.println("1. 로그인 2. 사용자 등록 3. 종료");
            try {
                str = br.readLine();
            }catch (Exception e){
                System.out.println("숫자를 제대로 입력해 주십시오.");
            }

            switch (str) {
                case "1":
                    mainMenu(loginRead());
                    break;
                case "2":
                    loginWrite(join(loginRead()));
                    break;
                case "3":
                    System.out.println("앱이 종료됩니다.");
                    flag = false;
                    br.close();
                    break;

            }

        }

    }

    public void mainMenu(List<List<String>> loginArr) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        String str;

        if(login(loginArr)){
            while (flag) {
                makeDataFile();
                System.out.println("가계부 앱이 실행되었습니다.");
                System.out.println("원하시는 메뉴에 해당하는 숫자를 입력해주세요.");
                System.out.println("1. 가계부 등록 2. 전체자료 출력 3. 월별 자료 출력 4. 통합검색 5. 유형별 검색 6. 정렬 7. 로그아웃");
                str = br.readLine();
                switch (str) {
                    case "1":
                        dataWrite(input(dataRead()));
                        break;
                    case "2":
                        printBook(dataRead());
                        break;
                    case "3":
                        printMonth(dataRead());
                        break;
                    case "4":
                        searchData(dataRead());
                        break;
                    case "5":
                        searchCategoryData(dataRead());
                        break;
                    case "6":
                        sortArray(dataRead());
                        break;
                    case "7":
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
                        if (!loginArr.get(i).get(0).equals(id)) {
                            msg = "등록되지 않은 ID입니다.";
                        }else if (loginArr.get(i).get(0).equals(id) && !loginArr.get(i).get(1).equals(pw)) {
                            msg = "비밀번호가 일치하지 않습니다.";
                        }else if (loginArr.get(i).get(0).equals(id) && loginArr.get(i).get(1).equals(pw)) {
                            msg = "로그인 성공했습니다. 환영합니다, " + id + "님.";
                            flag = true;
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

        System.out.println("날짜를 입력해 주십시오. ex)2021-01-01");
        String date = br.readLine();
        System.out.println("메모를 입력해 주십시오.");
        String memo = br.readLine();
        System.out.println("수입금액을 입력해 주십시오.");
        String income = br.readLine();
        System.out.println("지출금액을 입력해 주십시오.");
        String outcome = br.readLine();
        System.out.println("지출수단을 입력해 주십시오 ex)카드 or 현금");
        String money = br.readLine();

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
        arr.add(money);

        System.out.println("자료 입력을 완료했습니다.");

        return arr;
    }

    public void makeLoginFile() throws IOException {

        String directory = "c:\\AccountBook\\register.csv";

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        bw.flush();
        bw.close();

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

    public void makeDataFile() throws IOException {


        String directory = "c:\\AccountBook\\accountbook.csv";

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        bw.flush();
        bw.close();


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


    public List<List<String>> dataRead() throws IOException{

        List<List<String>> arrs = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        List<String> data;
        String line = "";
        String directory = "c:\\AccountBook\\accountbook.csv";
        ArrayList<String> pi = new ArrayList<>();
        BufferedReader br = Files.newBufferedReader(Paths.get(directory), Charset.forName("MS949"));

            while(true){
                line = br.readLine();
                arr.add(line);
                if(line == null) break;
            }

            for(int i = 0; i < arr.size()-1; i++){
                data = Arrays.asList(arr.get(i).split(","));
                arrs.add(data);
            }

        return arrs;
    }



    public void searchData(List<List<String>> arr) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("검색하실 키워드를 입력해 주십시오.");
        String str = br.readLine();
        String msg = "";

        System.out.println("검색어 : " + str);
        System.out.println("순번       날짜          적요           수입           지출          지출수단");
        System.out.println("------------------------------------------------------------------------");

        for(int i = 0; i < arr.size(); i++){
            for(int j = 0; j < arr.get(i).size(); j++){
                if(str.equals(arr.get(i).get(j))){
                    System.out.print(arr.get(i).get(0)+ "     " + arr.get(i).get(1) + "       " + arr.get(i).get(2) + "         " + arr.get(i).get(3) + "          " + arr.get(i).get(4) + "          " + arr.get(i).get(5) + "\n");
                }else if(!str.equals(arr.get(i).get(j))){
                    msg = "해당하는 자료가 존재하지 않습니다.";
                }

            }
        }
        System.out.println(msg);
    }

    public void searchCategoryData(List<List<String>> arr) throws IOException{

        String[] categories = {"순번", "날짜", "적요", "수입", "지출", "지출수단"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("1. 순번 2. 날짜 3. 적요 4. 수입 5. 지출 6. 지출수단");
        System.out.println("검색하실 유형의 번호를 입력해 주십시오.");

        int category = Integer.parseInt(br.readLine());

        System.out.println(categories[category-1]+ "에서 검색하실 단어를 입력해 주십시오.");

        String keyword = br.readLine();
        String msg = "";

        if(category > 6 || category < 0) {
            System.out.println("올바른 입력 범위가 아닙니다.");
        }else if (category > 0 && category < 7){
            System.out.println("유형 : " + categories[category-1] + ", 검색어 : " + keyword);
            System.out.println("순번       날짜          적요           수입           지출          지출수단");
            System.out.println("------------------------------------------------------------------------");
            for (int i = 0; i < arr.size(); i++){
                if(arr.get(i).get(category-1).equals(keyword)) {
                    System.out.println(arr.get(i).get(0) + "     " + arr.get(i).get(1) + "       " + arr.get(i).get(2) + "         " + arr.get(i).get(3) + "          " + arr.get(i).get(4) + "          " + arr.get(i).get(5));
                }else if(!arr.get(i).get(category-1).equals(keyword)){
                    msg = "해당하는 자료가 없습니다.";
                }
            }
            System.out.println(msg);
        }

    }

    public void printMonth(List<List<String>> arr) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("확인하실 월을 입력해 주십시오.");
        int num = Integer.parseInt(br.readLine());
        String msg = "";

        if(arr.size() == 0){
            System.out.println("등록된 자료가 없습니다.");
        }else if(arr.size() != 0){
            System.out.println("순번       날짜          적요           수입           지출          지출수단");
            System.out.println("------------------------------------------------------------------------");
            for(int i = 0; i < arr.size(); i++){
                if (num == LocalDate.parse(arr.get(i).get(1)).getMonthValue()){
                    System.out.print(arr.get(i).get(0)+ "     " + arr.get(i).get(1) + "       " + arr.get(i).get(2) + "         " + arr.get(i).get(3) + "          " + arr.get(i).get(4) + "          " + arr.get(i).get(5) + "\n");
                }else if(num != LocalDate.parse(arr.get(i).get(1)).getMonthValue()){
                    msg = "해당하는 월의 자료가 없습니다.";
                }
            }

            System.out.println(msg);
        }

    }

    public void printBook(List<List<String>> arr){

        if(arr.size() == 0){
            System.out.println("등록된 자료가 없습니다.");
        }else if(arr.size() != 0){
            System.out.println("순번       날짜          적요           수입           지출          지출수단");
            System.out.println("------------------------------------------------------------------------");
            for(int i = 0; i < arr.size(); i++){
                System.out.print(arr.get(i).get(0)+ "     " + arr.get(i).get(1) + "       " + arr.get(i).get(2) + "         " + arr.get(i).get(3) + "          " + arr.get(i).get(4) + "          " + arr.get(i).get(5) + "\n");
            }
        }

    }

    public void sortArray(List<List<String>> arr) throws IOException {

        System.out.println("미구현 기능입니다 ㅠㅠ");
    }

}
