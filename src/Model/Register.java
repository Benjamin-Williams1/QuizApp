package Model;

public class Register {
    private int StudentID;
    private int ClassID;

    public Register(int studentID, int classID) {
        StudentID = studentID;
        ClassID = classID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int classID) {
        ClassID = classID;
    }
}
