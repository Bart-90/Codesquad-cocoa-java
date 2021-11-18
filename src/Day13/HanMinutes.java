package Day13;

public enum HanMinutes {

    ONE("일",4,1),
    TWO("이",4,2),
    THREE("삼",4,3),
    FOUR("사",4,4),
    FIVE("오",5,1),
    SIX("육",4,5),
    SEVEN("칠",5,2),
    EIGHT("팔",5,3),
    NINE("구",5,4),
    TEN("십",3,5);

    private String name;
    private int first;
    private int last;

    private HanMinutes(String name, int startIndex, int lastIndex){this.name = name;
      this.first = startIndex;
      this.last = lastIndex;
    }

    public String getName(){
        return name;
    }

    public int getFirst(){
        return first;
    }

    public int getLast() {
        return last;
    }
}
