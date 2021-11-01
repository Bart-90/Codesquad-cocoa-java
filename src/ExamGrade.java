import java.util.Scanner;

public class ExamGrade {

    public static void main(String[] args){

        System.out.println("시험성적을 입력해주십시오.");

        Scanner scanner = new Scanner(System.in);
        int grade = scanner.nextInt();


        if(grade > 100){
            System.out.println("100점을 초과할 수 없습니다.");
        }else if(grade >= 90){
            System.out.println("A");
        }else if(grade >= 80){
            System.out.println("B");
        }else if(grade >= 70){
            System.out.println("C");
        }else if(grade >= 60){
            System.out.println("D");
        }else if(grade >= 0){
            System.out.println("F");
        }else{
            System.out.println("0점 미만은 입력할 수 없습니다.");
        }

    }
}
