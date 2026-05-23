package model;

public class Score {

    private int id;
    private int userId;
    private int score;

    public Score() {
    }

    public Score(int userId, int score) {
        this.userId = userId;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}