package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RegisterService {
    public static void selectAll(List<Register> targetList, Model.DatabaseConnection database) {
        PreparedStatement statement = database.newStatement("SELECT StudentID, ClassID FROM Register ORDER BY StudentID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Register(results.getInt("StudentID"), results.getInt("ClassID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
    public static Register selectById(int StudentID, Model.DatabaseConnection database) {
        Register result = null;

        PreparedStatement statement = database.newStatement("SELECT StudentID, ClassID FROM Register WHERE StudentID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, StudentID);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Register(results.getInt("StudentID"), results.getInt("ClassID"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
    public static void save(Register Register, Model.DatabaseConnection database) {
        Register existingItem = null;
        if (Register.getStudentID() != 0) existingItem = selectById(Register.getStudentID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Register (StudentID, ClassID) VALUES (?, ?))");
                statement.setInt(1, Register.getStudentID());
                statement.setInt(2, Register.getClassID());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Register SET StudentID = ?, Name = ?, Password = ? WHERE id = ?");
                statement.setInt(1, Register.getStudentID());
                statement.setInt(2, Register.getClassID());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
    public static void deleteById(int StudentID, Model.DatabaseConnection database) { }
}
