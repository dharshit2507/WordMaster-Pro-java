package dao;

import model.Score;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScoreDAO {

    // SAVE SCORE
    public boolean saveScore(Score score) {

        String query = "INSERT INTO scores(user_id, score) VALUES(?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, score.getUserId());
            pst.setInt(2, score.getScore());

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            System.out.println("Failed to Save Score!");
            e.printStackTrace();
        }

        return false;
    }

    // SHOW LEADERBOARD
    public void showLeaderboard() {

        String query = "SELECT users.username, MAX(scores.score) AS highscore " +
                "FROM scores " +
                "JOIN users ON scores.user_id = users.id " +
                "GROUP BY users.username " +
                "ORDER BY highscore DESC";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(query)) {

            ResultSet rs = pst.executeQuery();

            System.out.println("\n===== LEADERBOARD =====");

            while (rs.next()) {

                System.out.println(
                        rs.getString("username")
                                + " --> "
                                + rs.getInt("highscore"));
            }

        } catch (Exception e) {
            System.out.println("Failed to Load Leaderboard!");
            e.printStackTrace();
        }
    }
}