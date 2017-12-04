package Model;

public class Classes {
    private int ClassID;
    private String ClassName;
    private int TeacherID;

    public Classes(int classID, String className, int teacherID) {
        ClassID = classID;
        ClassName = className;
        TeacherID = teacherID;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int classID) {
        ClassID = classID;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int teacherID) {
        TeacherID = teacherID;
    }
}
