import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args){

        System.out.println("연도를 입력해주십시오.");

        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        if(year < 1){
            System.out.println("연도는 1보다 크거나 같아야 합니다.");
        }else if(year > 4000){
            System.out.println("연도는 4000보다 작거나 같아야 합니다.");
        }else if(year % 4 == 0 && year % 400 == 0){
            System.out.println("1");
        }else if(year % 4 == 0 && year % 100 != 0){
            System.out.println("1");
        }else{
            System.out.println("0");
        }

    }

}
