package Day13;

import java.time.LocalTime;

public class HangeulClock {

    public static void main(String[] args) {
        HangeulClock hc = new HangeulClock();
//        hc.showClock();
        LocalTime localTime = LocalTime.now();

        System.out.println(localTime);
    }

    public void showClock(){
        String[][] str = {{"한","두","세","네","다","섯"},
                          {"여","섯","일","곱","여","덟"},
                          {"아","홉","열","한","두","시"},
                          {"자","이","삼","사","오","십"},
                          {"정","일","이","삼","사","육"},
                          {"오","오","칠","팔","구","분"}};

        for(int i = 0; i < str.length; i++){
            for(int j = 0; j < str[i].length; j++){
                System.out.print(str[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
