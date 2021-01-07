package stream.intermediate_operations.sorted;

public record Student(int no, String name, int koreanScore, int mathScore, int englishScore) implements Comparable<Student> {
    @Override
    public int compareTo(Student student) {
        int sum = koreanScore + mathScore + englishScore;
        int studentSum = student.koreanScore() + student.mathScore() + student.englishScore();
        return studentSum - sum;
    }
}
