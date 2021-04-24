package model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author：ZhaoWenXin
 * @date：2021-04-24 14:50
 */
public class UserClass {

    private String userId;
    private String name;
    private Integer age;
    private BigDecimal integral;
    private LocalDate birthday;


    public UserClass() {
    }

    public UserClass(String userId, String name, Integer age, BigDecimal integral, LocalDate birthday) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.integral = integral;
        this.birthday = birthday;
    }

    public String getUserId() {
        return userId;
    }

    public UserClass setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserClass setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserClass setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public UserClass setIntegral(BigDecimal integral) {
        this.integral = integral;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public UserClass setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public String toString() {
        return "UserClass{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", integral=" + integral +
                ", birthday=" + birthday +
                '}';
    }
}
