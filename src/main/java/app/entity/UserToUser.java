package app.entity;

public class UserToUser {
    private int userId;
    private int userMessageTargetId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserMessageTargetId() {
        return userMessageTargetId;
    }

    public void setUserMessageTargetId(int userMessageTargetId) {
        this.userMessageTargetId = userMessageTargetId;
    }

    public UserToUser() {
    }

    public UserToUser(int userId, int userMessageTargetId) {
        this.userId = userId;
        this.userMessageTargetId = userMessageTargetId;
    }
}
