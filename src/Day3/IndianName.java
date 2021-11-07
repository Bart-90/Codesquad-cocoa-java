package Day3;

import java.util.Scanner;

public class IndianName {

    public static void main(String[] args) {


        System.out.println("생년월일을 입력해주세요.");
        IndianName indianName = new IndianName();
        Scanner scanner = new Scanner(System.in);

        String year = indianName.inputYear(scanner);
        int eYear = indianName.splitYear(year);
        int month = indianName.inputMonth(scanner);
        int day = indianName.inputDay(scanner);
        indianName.printName(eYear,month,day);

    }

    public void printName(int y, int m, int d){

        String[] year = {"시끄러운", "푸른", "적색", "조용한", "웅크린", "백색", "지혜로운", "용감한", "날카로운","욕심 많은"};
        String[] month = {"늑대", "태양", "양", "매", "황소", "불꽃", "나무", "달빛", "말", "돼지", "하늘", "바람"};
        String[] day = {"와 함께 춤을", "의 기상", "은(는) 그림자속에", "", "", "", "의 환생", "의 죽음", "아래에서", "를(을) 보라", "이(가) 노래하다", "그림자", "의 일격", "에게 쫓기는 남자", "의 행진", "의 왕", "의 유령", "을(를) 죽인 자", "은(는) 맨날 잠잔다", "처럼", "의 고향", "의 전사", "은(는) 나의 친구","의 노래", "의 정령", "의 파수꾼", "의 악마", "와(과) 같은 사나이", "을(를) 쓰러트린 자", "의 혼", "은(는) 말이 없다"};

        if(m > month.length){
            System.out.println("12월까지 입력 가능합니다.");
        }else if(d > day.length){
            System.out.println("31일까지 입력 가능합니다.");
        }else {
            System.out.println("당신의 이름은 " + year[y] + " " + month[m - 1] + day[d - 1] + "입니다.");
        }
    }

    public int splitYear(String year){

        String y = year.substring(year.length()-1);
        int sy = Integer.parseInt(y);

        return sy;
    }

    public String inputYear(Scanner scanner){

        String y = scanner.next();

        return y;
    }

    public int inputMonth(Scanner scanner){

        int m = scanner.nextInt();

        return m;
    }

    public int inputDay(Scanner scanner){

        int d = scanner.nextInt();
        scanner.close();

        return d;
    }


}
