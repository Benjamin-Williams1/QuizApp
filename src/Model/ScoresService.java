package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ScoresService {
    public static void selectAll(List<Scores> targetList, Model.DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT ScoreID, StudentID, Score, Activity FROM Scores ORDER BY StudentID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Scores(results.getInt("ScoreID"), results.getInt("StudentID"), results.getInt("Score"), results.getString("Activity")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    public static Scores selectById(int ScoreID, Model.DatabaseConnection database) {
            Scores result = null;

            PreparedStatement statement = database.newStatement("SELECT ScoreID, StudentID, Score, Activity FROM Scores WHERE StudentID = ?");

            try {
                if (statement != null) {

                    statement.setInt(1, ScoreID);
                    ResultSet results = database.executeQuery(statement);

                    if (results != null) {
                        result = new Scores(results.getInt("ScoreID"), results.getInt("StudentID"), results.getInt("Score"), results.getString("Activity"));
                    }
                }
            } catch (SQLException resultsException) {
                System.out.println("Database select by id error: " + resultsException.getMessage());
            }

            return result;
        }
    public static void save(Scores Scores, DatabaseConnection database) {
        Scores existingItem = null;
        if (Scores.getScoreID() != 0) existingItem = selectById(Scores.getScoreID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Scores (ScoreID, StudentID, Score, Activity) VALUES (?, ?, ?))");
                statement.setInt(1, Scores.getScoreID());
                statement.setInt(2, Scores.getStudentID());
                statement.setInt(3, Scores.getScore());
                statement.setString(3, Scores.getActivity());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Scores SET ScoreID = ?, StudentID = ?, Score = ?, Activity = ? WHERE id = ?");
                statement.setInt(1, Scores.getScoreID());
                statement.setInt(2, Scores.getStudentID());
                statement.setInt(3, Scores.getScore());
                statement.setString(4, Scores.getActivity());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
    public static void deleteById(int ScoreID, Model.DatabaseConnection database) {
        PreparedStatement statement = database.newStatement("DELETE FROM Scores WHERE ScoreID = ?");
        try {
            if (statement != null) {
                statement.setInt(1, ScoreID);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }

    }
    public static ObservableList<Integer> getMathScores(Model.DatabaseConnection database){
        ObservableList<Integer> result = FXCollections.observableArrayList();

        PreparedStatement statement = database.newStatement("SELECT Score FROM Scores WHERE Activity = 'Maths'");
        ResultSet results = database.executeQuery(statement);
        try {
            while(results.next()) {
                result.add(results.getInt("Score"));
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
}


