package groupa;
import java.util.List;
import java.util.ArrayList;
public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName,String lastName, ArrayList<Double> examScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;

    }
    private int numberOfExamsTaken() {
        return 3;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   public String getExamScores(){
    String exam = "Exam Scores: \n" ;
    for(int i = 0; i < examScores.size();i++){
        exam += "Exam " + (i+1) + " -> " + examScores.get(i) + "\n";
       }
    return exam;
   }
   public void addExamScore(double examScore){
        examScores.add(examScore);

   }
   public void setExamScore(int indexNumber ,double nextScore ){
        examScores.set(indexNumber,nextScore);
   }
   public double getAverageExamScores(){
         double sum = 0.0;
         for(int i = 0; i < examScores.size(); i++){
         sum += examScores.get(i);
         }
         double average = sum / examScores.size();
         return average;
   }

    public int getNumberOfExamsTaken(){
        return examScores.size();
    }

    @Override
    public String toString() {
        return "Student Name: " + firstName + " " + lastName + "\n"
                + "Average Score:" + getAverageExamScores() + examScores + "\n" + getExamScores()   ;
    }
}
