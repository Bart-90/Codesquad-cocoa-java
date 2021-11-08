package Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AccountBook {

    public static void main(String[] args){

        ArrayList<ArrayList<String>> logArr = new ArrayList<>();
        ArrayList<ArrayList<String>> inpArr = new ArrayList<>();

        try {
            mainMenu(logArr,inpArr);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void mainMenu(ArrayList<ArrayList<String>> logArr, ArrayList<ArrayList<String>> inpArr)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        boolean flag = true;

        while(flag){
            System.out.println("가계부 앱이 실행되었습니다.");
            System.out.println("원하시는 메뉴를 골라주세요.");
            System.out.println("1. 로그인 2. 사용자 등록 3. 가계부 등록 4. 삭제 5. 전체자료 출력 6. 월별 자료 출력 7. 종료");
            str = br.readLine();

            switch (str){
                case "1" :  login(logArr);
                            break;
                case "2" :  join(inpArr);
                            break;
                case "3" :  input(inpArr);
                            break;
                case "4" :  remove(inpArr);
                            break;
                case "5" :  printBook(inpArr);
                            break;
                case "6" :  System.out.println("아직 미구현입니다.");
                            break;
                case "7" :  System.out.println("앱이 종료됩니다."); flag = false;
                            break;
            }

        }

    }


    public static ArrayList<ArrayList<String>> join(ArrayList<ArrayList<String>> arr) throws IOException{

        ArrayList<String> personal = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("사용자 등록");
        System.out.println("ID를 입력해주십시오.");
        String id = br.readLine();
        System.out.println("비밀번호를 입력해주십시오.");
        String pw = br.readLine();

        for(int i = 0; i < arr.size(); i++){
            if(id.isBlank()) {
                System.out.println("공백은 입력할 수 없습니다.");
            }else if(id.equals(arr.get(i).get(0))){
                System.out.println("이미 존재하는 id입니다.");
            }else if(!id.equals(arr.get(i).get(0))){
                personal.add(id);
                personal.add(pw);
                arr.add(personal);
            }
        }

        return arr;
    }

    public static boolean login(ArrayList<ArrayList<String>> arr) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean bl = false;

        System.out.println("LOGIN");
        System.out.println("ID를 입력해주십시오.");
        String id = br.readLine();
        System.out.println("비밀번호를 입력해주십시오.");
        String pw = br.readLine();

        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).get(0).equals(id) && arr.get(i).get(1).equals(pw)){
                System.out.println("로그인 성공했습니다.");
                bl = true;
            }else if(!arr.get(i).get(0).equals(id)){
                System.out.println("정보가 존재하지 않습니다.");
            }else if(arr.get(i).get(0).equals(id) && !arr.get(i).get(1).equals(pw)) {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }

        return bl;
    }

    public static ArrayList<ArrayList<String>> input(ArrayList<ArrayList<String>> inpArr) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arr = new ArrayList<>();

        System.out.println("날짜를 입력해 주십시오. ex)2021.11.08");
        String date = br.readLine();
        System.out.println("적요를 입력해 주십시오.");
        String memo = br.readLine();
        System.out.println("수입금액을 입력해 주십시오.");
        String income = br.readLine();
        System.out.println("지출금액을 입력해 주십시오.");
        String outcome = br.readLine();

        if(inpArr.size() == 0){
            arr.add("1");
        }else if(inpArr.size() != 0) {
            int num = Integer.parseInt(inpArr.get(inpArr.size()-1).get(0));
            arr.add(Integer.toString(num + 1));
        }
        arr.add(date);
        arr.add(memo);
        arr.add(income);
        arr.add(outcome);
        inpArr.add(arr);

        return inpArr;
    }

    public static void remove(ArrayList<ArrayList<String>> arr) throws IOException{

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

    public static void print(ArrayList<ArrayList<String>> arr) throws IOException{

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

        System.out.println("순번       적요           수입           지출          잔액");
        System.out.println("-------------------------------------------------------");

    }

    public static void printBook(ArrayList<ArrayList<String>> arr){

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
