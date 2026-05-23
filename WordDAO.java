package dao;

import model.Word;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class WordDAO {

    // GET RANDOM WORD
    public Word getRandomWord() {

        String query = "SELECT * FROM words ORDER BY RAND() LIMIT 1";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(query)) {

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                Word word = new Word();

                word.setId(rs.getInt("id"));
                word.setWord(rs.getString("word"));
                word.setCategory(rs.getString("category"));
                word.setDifficulty(rs.getString("difficulty"));

                return word;
            }

        } catch (Exception e) {
            System.out.println("Failed to Fetch Word!");
            e.printStackTrace();
        }

        return null;
    }
}