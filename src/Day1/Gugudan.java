package Day1;

import java.util.Scanner;

public class Gugudan {

    public static void main(String[] args){

        System.out.println("시작단과 끝단을 입력해 주십시오.");

        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int last = scanner.nextInt();

        for(int i = first; i <= last; i++){
            for(int j = 1; j < 10; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
                if(j == 9) {
                    System.out.println("");
                }
            }
        }

    }
}
