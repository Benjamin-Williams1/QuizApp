package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentsService {
    public static void selectAll(List<Students> targetList, Model.DatabaseConnection database) {
        PreparedStatement statement = database.newStatement("SELECT StudentID, Name, Password FROM Students ORDER BY StudentID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Students(results.getInt("StudentID"), results.getString("Name"), results.getString("Password")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
    public static Students selectById(int StudentID, Model.DatabaseConnection database) {
        Students result = null;

        PreparedStatement statement = database.newStatement("SELECT StudentID, Name, Password FROM Students WHERE StudentID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, StudentID);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Students(results.getInt("StudentID"), results.getString("Name"), results.getString("Password"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
    public static void save(Students Students, Model.DatabaseConnection database) {
        Students existingItem = null;
        if (Students.getStudentID() != 0) existingItem = selectById(Students.getStudentID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Students (Name, Password) VALUES (?, ?)");
                statement.setString(1, Students.getName());
                statement.setString(2, Students.getPassword());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Students SET Name = ?, Password = ? WHERE StudentID = ?");
                statement.setString(1, Students.getName());
                statement.setString(2, Students.getPassword());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
    public static void deleteById(int StudentID, Model.DatabaseConnection database) {
        PreparedStatement statement = database.newStatement("DELETE FROM Students WHERE StudentID = ?");
        try {
            if (statement != null) {
                statement.setInt(1, StudentID);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }
    public static int LastAdded(DatabaseConnection database){
        int result = 1;
        PreparedStatement statement = database.newStatement("SELECT MAX(StudentID) FROM Students");
        ResultSet results = database.executeQuery(statement);
        try {
            result = results.getInt(1);
        }catch (SQLException resultsException){
            System.out.println("Database error: " + resultsException.getMessage());
        }
        return result;
    }
}
