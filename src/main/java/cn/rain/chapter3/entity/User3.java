package cn.rain.chapter3.entity;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/6/20 23:04
 */
public class User3 {

    private String username;
    private String gender;
    private boolean flag;

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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "User3{" +
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", flag=" + flag +
                '}';
    }
}
