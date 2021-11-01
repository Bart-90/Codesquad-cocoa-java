import java.util.Scanner;

public class MakeStars4 {

    public static void main(String[] args){

        System.out.println("숫자를 입력해주십시오.");

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if(num < 1 || num > 100) {
            System.out.println("숫자는 1 이상 100 이하여야 합니다.");
        }else{
            for (int i = 1; i <= num; i++) {
                for(int j = 1; j <= num; j++){
                    if(i>j) {
                        System.out.print(" ");
                    }else{
                        System.out.print("*");
                    }
                }
                System.out.println("");
            }
        }
    }

}
