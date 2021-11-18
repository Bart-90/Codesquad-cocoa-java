package Day13;

public class HanHours {

    enum Hour{
        HAN("한",1,0, 0),
        DO("두",2,0, 1),
        SE("세",3,0, 2),
        NE("네",4,0, 3),
        DA("다",5,0, 4),
        DASUT("섯",5,0, 5),
        YEO("여",6,1, 0),
        YEOSUT("섯",6,1, 1),
        IL("일",7,1, 2),
        GOP("곱",7,1, 3),
        YEOO("여",8,1, 4),
        DEOL("덟",8,1, 5),
        AH("아",9,2, 0),
        HOP("홉",9, 2, 1),
        YEOL("열",10,2, 2),
        YEOLL("열",11,2, 2),
        HANN("한",11,2, 3),
        YEOLLL("열",12,2, 2),
        DOO("두",12,2, 4);

        private String hanHour;
        private int hour;
        private int firstIndex;
        private int lastIndex;

        private Hour(String hanHour, int hour, int firstIndex, int lastIndex){
            this.hanHour = hanHour;
            this.hour = hour;
            this.firstIndex = firstIndex;
            this.lastIndex = lastIndex;
        }

        public String getHanHour(){
            return hanHour;
        }

        public int getHour() {
            return hour;
        }

        public int getFirstIndex() {
            return firstIndex;
        }

        public int getLastIndex() {
            return lastIndex;
        }
    }

}
