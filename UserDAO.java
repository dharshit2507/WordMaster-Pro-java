package dao;

import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // REGISTER USER
    public boolean registerUser(User user) {

        String query =
                "INSERT INTO users(username, password) VALUES(?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(query)
        ) {

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            System.out.println("Registration Failed!");
            e.printStackTrace();
        }

        return false;
    }

    // LOGIN USER
    public User loginUser(String username, String password) {

        String query =
                "SELECT * FROM users WHERE username=? AND password=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(query)
        ) {

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));

                return user;
            }

        } catch (Exception e) {
            System.out.println("Login Failed!");
            e.printStackTrace();
        }

        return null;
    }
}