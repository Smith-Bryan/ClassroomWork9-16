package groupa;
import java.util.ArrayList;
import java.util.function.DoubleBinaryOperator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> examScores = new ArrayList<Double>();
        //double score = examScores.get(0);
        Student student = new Student("Omar","Mahsood",examScores);
        Student student1 =new Student("Gol ","Roger", examScores);
        Student[] studentArray = {student,student1};
        Classroom classroom = new Classroom();
        classroom.addStudent(student1);
        student.getNumberOfExamsTaken();
        student.addExamScore(95.5 );
        student.addExamScore(80);
        student.addExamScore(60);
        Double[] examScores2 = {50.0,60.0,70.0,80.0};
        student.setExamScore(0,100);

        System.out.println(classroom.getAverageExamScore());
            System.out.println(student.toString());
    }
}
