package groupa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Comparator;

public class Classroom {
    Student[] students;


    public Classroom(int maxNumOfStudents) {
        this.students = new Student[maxNumOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        double sum = 0.0;
        for (Student student : students) {
            sum += student.getAverageExamScores();
        }
        return sum / students.length;

    }

    public void addStudent(Student student) {
        //for(int i = 0; i < students.length; i++){}
        ArrayList<Student> studentArrayList = new ArrayList<>(Arrays.asList(students));
        studentArrayList.add(student);
        this.students = studentArrayList.toArray(studentArrayList.toArray(new Student[0]));
    }

    public void removeStudent(String firstname, String lastName) {
        for (int x = 0; x < students.length; x++) {
            Student student = students[x];
            if (student != null && student.getFirstName().equals(firstname) && student.getLastName().equals(lastName)) {
                students[x] = null;
                reorderStudentsArray();
                return;
            }
        }
    }

    private Student[] reorderStudentsArray() {
        Student[] newStudents = new Student[students.length];
        int newIndex = 0;
        for (Student student : students) {
            if (student != null) {
                newStudents[newIndex++] = student;
            }

            while (newIndex < newStudents.length) {
                newStudents[newIndex++] = null;
            }
            students = newStudents;
        }
    }
    public Student[] getStudentsByScore() {
            boolean swapped;
            for (int i = 0; i < students.length-1; i++) {
                swapped = false;
                for (int j = 0; j < students.length - 1 - i; j++) {
                    if (students[j] == null || students[j+1] == null) {

                        continue;
                    }
                    if (students[j].getAverageExamScores() < students[j+1].getAverageExamScores()) { 
                        Student temp = students[j];
                        students[j] = students[j+1];
                        students[j+1] = temp;
                        swapped = true;
                    }
                }

                if (!swapped) {
                    break;
                }
            }
            return students;
        }


            private Map<Student, String> getGradeBook() {
                Student[] sortedStudents = Arrays.copyOf(students, students.length);
                Arrays.sort(sortedStudents, (s1, s2) -> Integer.compare((int) s2.getAverageExamScores(), (int) s1.getAverageExamScores()));

                int totalStudents = sortedStudents.length;
                Map<Student, String> gradeBook = new HashMap<>();

                for (int i = 0; i < totalStudents; i++) {
                    Student student = sortedStudents[i];
                    double percentile = ((double) (i + 1) / totalStudents) * 100;

                    // Assign letter grade based on percentile.
                    String letterGrade = assignLetterGrade(percentile);

                    // Add to the grade book.
                    gradeBook.put(student, letterGrade);
                }

             return gradeBook;

            }

            private String assignLetterGrade( double percentile){
                if (percentile <= 10) {
                } else if (percentile <= 29) {
                } else if (percentile <= 50) {
                } else if (percentile <= 89) {
                } else {  return null;
                }

                return null;
            }
        }

