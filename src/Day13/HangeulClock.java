package Day13;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class HangeulClock {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        HangeulClock hc = new HangeulClock();
        hc.showClock();

    }

    public void showClock(){

        String[][] str = {{"한","두","세","네","다","섯"},
                          {"여","섯","일","곱","여","덟"},
                          {"아","홉","열","한","두","시"},
                          {"자","이","삼","사","오","십"},
                          {"정","일","이","삼","사","육"},
                          {"오","오","칠","팔","구","분"}};

        LocalTime localTime = LocalTime.now();
        LocalTime setHour = localTime.withHour(12);
        LocalTime setMinutes = localTime.withMinute(0);
        int hour12 = localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM);
        int hour24 = localTime.get(ChronoField.CLOCK_HOUR_OF_DAY);
        int minute = localTime.getMinute();

        showHours(str,hour24,hour12,minute);
        showMinutes(str,minute);

        for(int i = 0; i < str.length; i++){
            for(int j = 0; j < str[i].length; j++){
                System.out.print(str[i][j]+" ");
            }
            System.out.println("");
        }

    }

    public void showHours(String[][] str, int hour24, int hour12, int minute){

    HanHours[] hanHours = HanHours.values();

    if(hour24 == 12 && minute == 0){
            str[4][0] = ANSI_BLUE + "정" + ANSI_RESET;
            str[5][0] = ANSI_BLUE + "오" + ANSI_RESET;
    }else if(hour24 == 24 && minute == 0) {
            str[3][0] = ANSI_BLUE + "자" + ANSI_RESET;
            str[4][0] = ANSI_BLUE + "정" + ANSI_RESET;
    }else{
        for(int i = 0; i < hanHours.length; i++) {
            if (hanHours[i].getHour() == hour12) {
                str[hanHours[i].getFirstIndex()][hanHours[i].getLastIndex()] = ANSI_BLUE + hanHours[i].getHanHour() + ANSI_RESET;
            }
        }
        str[2][5] = ANSI_BLUE + "시" + ANSI_RESET;
    }



    }
    
    public void showMinutes(String[][] str, int minute){

        HanMinutes[] hanMinutes = HanMinutes.values();

//        if(minute <= 10) {
//            str[hanMinutes[minute-1].getFirst()][hanMinutes[minute-1].getLast()] = ANSI_BLUE + hanMinutes[minute-1].getName() + ANSI_RESET;
//        }

        str[5][5] = ANSI_BLUE + "분" + ANSI_RESET;

    }


}


