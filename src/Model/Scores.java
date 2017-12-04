package Model;

public class Scores {
    private int ScoreID;
    private int StudentID;
    private int Score;
    private String Activity;

    public Scores(int scoreID, int studentID, int score, String activity) {
        ScoreID = scoreID;
        StudentID = studentID;
        Score = score;
        Activity = activity;
    }

    public String getString() {
        return (Integer.toString(ScoreID) + " " + Integer.toString(StudentID) + " " + Integer.toString(Score) + " " + Activity);
    }

    public int getScoreID() {
        return ScoreID;
    }

    public void setScoreID(int scoreID) {
        ScoreID = scoreID;
    }

    public int getStudentID() {return StudentID;}

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getActivity() {
        return Activity;
    }

    public void setActivity(String activity) {
        Activity = activity;
    }
}
