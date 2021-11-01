import java.util.Scanner;

public class SumNum {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자의 개수를 입력해주십시오.");
        int amount = scanner.nextInt();

        System.out.println("숫자열를 입력해주십시오.");
        String nums = scanner.next();

        String[] numsArr = nums.split("");
        int result = 0;

        for(int i = 0; i < amount; i++){
            result = result + Integer.parseInt(numsArr[i]);
        }

        System.out.println("숫자들의 합은 " + result + "입니다.");

    }

}
