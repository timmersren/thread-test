package cn.rain.chapter3.entity;

/**
 * description: 线程间的共享数据
 *
 * @author 任伟
 * @date 2018/6/20 22:21
 */
public class User {
    private String username;
    private String gender;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
