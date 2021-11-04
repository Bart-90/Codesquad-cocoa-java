package Day3;

import java.util.*;

public class RandomPick {

    public static void main(String[] args) {

        RandomPick randomPick = new RandomPick();
        ArrayList randomMembers = randomPick.shuffleMembers();
        int people = randomPick.inputNum();
        randomPick.printMembers(people, randomMembers);

    }

    public int inputNum(){

        System.out.println("몇 명인가요?");

        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();

        scanner.close();

        return people;
    }

    public ArrayList shuffleMembers(){

        List<String> members = Arrays.asList( "Bart", "BC", "Dan", "Dave", "David", "Dike", "donggi", "Ella", "Hanse", "Jarry", "Jhin", "Jun", "K", "Konda", "Lacon", "Mandoo", "meatsby", "Mk", "mong",  "OS", "Phil",  "sonny", "taksu", "Tany", "Teemo",  "Yan",  "검봉", "노리", "땃쥐", "반스", "피오", "호두마루");
        ArrayList<String> sMembers = new ArrayList<>();

        sMembers.addAll(members);

        Collections.shuffle(sMembers);

        return sMembers;
    }

    public void printMembers(int num, ArrayList list){

        if(num > list.size()){
            System.out.println("입력 가능한 수치를 초과했습니다.");
        }else{
            for (int i = 0; i < num; i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }

}
