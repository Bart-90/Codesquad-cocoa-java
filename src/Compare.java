import java.util.Scanner;

public class Compare {

    public static void main(String[] args){

        System.out.println("비교할 두 숫자를 입력해주십시오.");

        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();


        if(first < -10000){
            System.out.println("첫 숫자는 -10000 이상으로 입력해 주십시오.");
        }else if(second > 10000) {
            System.out.println("두번째 숫자는 10000 이하로 입력해 주십시오.");
        }else if(first > second){
            System.out.println(">");
        }else if(first < second){
            System.out.println("<");
        }else if(first == second){
            System.out.println("==");
        }

    }

}
