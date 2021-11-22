package Day13;

public enum HanMinutes {

    ONE("일",1,4,1),
    TWO("이",2,4,2),
    THREE("삼",3,4,3),
    FOUR("사",4, 4,4),
    FIVE("오",5, 5,1),
    SIX("육",6, 4,5),
    SEVEN("칠",7, 5,2),
    EIGHT("팔",8, 5,3),
    NINE("구",9, 5,4),
    TEN("십",10, 3,5);

    private String name;
    private int minutes;
    private int first;
    private int last;

    private HanMinutes(String name, int minutes, int startIndex, int lastIndex){
        this.name = name;
        this.minutes = minutes;
        this.first = startIndex;
        this.last = lastIndex;
    }

    public String getName(){
        return name;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getFirst(){
        return first;
    }

    public int getLast() {
        return last;
    }
}
