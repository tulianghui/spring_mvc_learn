package res.sogou.com.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 * Created by wefit on 16/2/11.
 */
public class User {
    private String username;

    private String password;

    private int age;

    @NotNull(message="{username.not.empty}")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull(message="密码不能为null")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Min(value=10, message="年龄的最小值为10")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
