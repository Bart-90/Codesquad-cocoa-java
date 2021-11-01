import java.util.Scanner;

public class Quadrant {

    public static void main(String[] args){

        System.out.println("정수 2개를 입력해주십시오.");

        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        if(num1 < -1000 || num1 > 1000 || num1 == 0){
            System.out.println("첫 정수는 -1000 이상, 1000이하여야 하며 0과 같을 수 없습니다.");
        }else if(num2 < -1000 || num2 > 1000 || num2 == 0){
            System.out.println("두번째 정수는 -1000 이상, 1000이하여야 하며 0과 같을 수 없습니다.");
        }else if(num1 > 0 && num2 > 0){
            System.out.println("1사분면");
        }else if(num1 < 0 && num2 > 0){
            System.out.println("2사분면");
        }else if(num1 < 0 && num2 < 0){
            System.out.println("3사분면");
        }else if(num1 > 0 && num2 < 0){
            System.out.println("4사분면");
        }

    }

}
