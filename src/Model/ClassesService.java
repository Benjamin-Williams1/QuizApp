package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClassesService {
    public static void selectAll(List<Classes> targetList, Model.DatabaseConnection database) {
        PreparedStatement statement = database.newStatement("SELECT ClassID, ClassName, TeacherID FROM Classes ORDER BY ClassID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Classes(results.getInt("ClassID"), results.getString("ClassName"), results.getInt("TeacherID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
    public static Classes selectById(int ClassID, Model.DatabaseConnection database) {
        Classes result = null;

        PreparedStatement statement = database.newStatement("SELECT ClassID, ClassName, TeacherID FROM Classes WHERE ClassID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, ClassID);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Classes(results.getInt("ClassID"), results.getString("ClassName"), results.getInt("TeacherID"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result; }
    public static void save(Classes Classes, Model.DatabaseConnection database) {
        Classes existingItem = null;
        if (Classes.getClassID() != 0) existingItem = selectById(Classes.getClassID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Classes (ClassID, ClassName, TeacherID) VALUES (?, ?, ?))");
                statement.setInt(1, Classes.getClassID());
                statement.setString(2, Classes.getClassName());
                statement.setInt(3, Classes.getTeacherID());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Classes SET ClassID = ?, ClassName = ?, TeacherID = ? WHERE id = ?");
                statement.setInt(1, Classes.getClassID());
                statement.setString(2, Classes.getClassName());
                statement.setInt(3, Classes.getTeacherID());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
    public static void deleteById(int ClassID, Model.DatabaseConnection database) {
        PreparedStatement statement = database.newStatement("DELETE FROM Classes WHERE ClassID = ?");
        try {
            if (statement != null) {
                statement.setInt(1, ClassID);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }

}
