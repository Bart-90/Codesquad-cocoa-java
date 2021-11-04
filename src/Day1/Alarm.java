package Day1;

import java.time.LocalTime;
import java.util.Scanner;

public class Alarm {

    public static void main(String[] args){

        System.out.println("시간과 분을 입력해주십시오.");

        Scanner scanner = new Scanner(System.in);
        String time = scanner.next();
        String minute = scanner.next();

        int H = Integer.parseInt(time);
        int M = Integer.parseInt(minute);

        System.out.println(time+":"+minute);

        //LocalTime timeresult = LocalTime.parse(time+":"+minute);

        if(H > 23 || H < 0){
            System.out.println("시간은 0 이상 23 이하의 숫자여야 합니다.");
        }else if(M > 59 || H < 0){
            System.out.println("분은 0 이상 59 이하의 숫자여야 합니다.");
        }else{
           // System.out.println(timeresult.minusMinutes(45));
        }

    }

}
