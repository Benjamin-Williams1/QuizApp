package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TeachersService {
    public static void selectAll(List<Teachers> targetList, Model.DatabaseConnection database) {
        PreparedStatement statement = database.newStatement("SELECT TeacherID, Name, Password FROM Teachers ORDER BY TeacherID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Teachers(results.getInt("TeacherID"), results.getString("Name"), results.getString("Password")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
    public static Teachers selectById(int TeacherID, Model.DatabaseConnection database) {
        Teachers result = null;

        PreparedStatement statement = database.newStatement("SELECT TeacherID, Name, Password FROM Teachers WHERE TeacherID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, TeacherID);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Teachers(results.getInt("TeacherID"), results.getString("Name"), results.getString("Password"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
    public static void save(Teachers Teachers, Model.DatabaseConnection database) {
        Teachers existingItem = null;
        if (Teachers.getTeacherID() != 0) existingItem = selectById(Teachers.getTeacherID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Teachers (TeacherID, Name, Password) VALUES (?, ?, ?))");
                statement.setInt(1, Teachers.getTeacherID());
                statement.setString(2, Teachers.getName());
                statement.setString(3, Teachers.getPassword());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Teachers SET TeacherID = ?, Name = ?, Password = ? WHERE id = ?");
                statement.setInt(1, Teachers.getTeacherID());
                statement.setString(2, Teachers.getName());
                statement.setString(3, Teachers.getPassword());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        } }
    public static void deleteById(int TeacherID, Model.DatabaseConnection database) {
        PreparedStatement statement = database.newStatement("DELETE FROM Teachers WHERE TeacherID = ?");
        try {
            if (statement != null) {
                statement.setInt(1, TeacherID);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        } }
}
