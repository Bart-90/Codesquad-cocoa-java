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
        LocalTime otherTime = localTime.withMinute(10);
        int hour12 = localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM);
        int hour24 = localTime.get(ChronoField.CLOCK_HOUR_OF_DAY);
        int minute = otherTime.getMinute();

        showHours(str,hour24,hour12,minute);
        showMinutes(str,hour24,hour12,minute);

        for(int i = 0; i < str.length; i++){
            for(int j = 0; j < str[i].length; j++){
                System.out.print(str[i][j]+" ");
            }
            System.out.println("");
        }

    }

    public void showHours(String[][] str, int hour24, int hour12, int minute){




//        if(hour24 == 12 && minute == 0){
//            str[4][0] = ANSI_BLUE + "정" + ANSI_RESET;
//            str[5][0] = ANSI_BLUE + "오" + ANSI_RESET;
//        }else if(hour24 == 24 && minute == 0) {
//            str[3][0] = ANSI_BLUE + "자" + ANSI_RESET;
//            str[4][0] = ANSI_BLUE + "정" + ANSI_RESET;
//        }else {
//            switch (hour12) {
//                case 1:
//                    str[0][0] = ANSI_BLUE + "한" + ANSI_RESET;
//                    break;
//                case 2:
//                    str[0][1] = ANSI_BLUE + "두" + ANSI_RESET;
//                    break;
//                case 3:
//                    str[0][2] = ANSI_BLUE + "세" + ANSI_RESET;
//                    break;
//                case 4:
//                    str[0][3] = ANSI_BLUE + "네" + ANSI_RESET;
//                    break;
//                case 5:
//                    str[0][4] = ANSI_BLUE + "다";
//                    str[0][5] = "섯" + ANSI_RESET;
//                    break;
//                case 6:
//                    str[1][0] = ANSI_BLUE + "여";
//                    str[1][1] = "섯" + ANSI_RESET;
//                    break;
//                case 7:
//                    str[1][2] = ANSI_BLUE + "일";
//                    str[1][3] = "곱" + ANSI_RESET;
//                    break;
//                case 8:
//                    str[1][4] = ANSI_BLUE + "여";
//                    str[1][5] = "덟" + ANSI_RESET;
//                    break;
//                case 9:
//                    str[2][0] = ANSI_BLUE + "아";
//                    str[2][1] = "홉" + ANSI_RESET;
//                    break;
//                case 10:
//                    str[2][2] = ANSI_BLUE + "열" + ANSI_RESET;
//                    break;
//                case 11:
//                    str[2][2] = ANSI_BLUE + "열";
//                    str[2][3] = "한" + ANSI_RESET;
//                    break;
//                case 12:
//                    str[2][2] = ANSI_BLUE + "열" + ANSI_RESET;
//                    str[2][4] = ANSI_BLUE + "두" + ANSI_RESET;
//                    break;
//            }
//            str[2][5] = ANSI_BLUE + "시" + ANSI_RESET;
//        }
    }
    
    public void showMinutes(String[][] str, int hour24, int hour12, int minute){

        HanMinutes[] hanMinutes = HanMinutes.values();

        if(minute <= 10) {
            str[hanMinutes[minute-1].getFirst()][hanMinutes[minute-1].getLast()] = ANSI_BLUE + hanMinutes[minute-1].getName() + ANSI_RESET;
        }

        str[5][5] = ANSI_BLUE + "분" + ANSI_RESET;

    }


}


