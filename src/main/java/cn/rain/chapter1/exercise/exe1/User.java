package cn.rain.chapter1.exercise.exe1;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/4/20 13:38
 */
public class User {
    private String username;
    private int userId;

    public User(String username, int userId) {
        this.username = username;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userId=" + userId +
                '}';
    }
}
