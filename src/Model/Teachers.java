package Model;

public class Teachers {
    private int TeacherID;
    private String Name;
    private String Password;

    public Teachers(int teacherID, String name, String password) {
        TeacherID = teacherID;
        Name = name;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int teacherID) {
        TeacherID = teacherID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
