package com.red2222.ch14;

/**
 * 哈哈哈哈
 *
 * @author red2222
 * @date 2024/1/3
 */
public class User {

  private String name;
  private String email;
  private Integer age;
  private Integer sex;
  private String schoolName;

  public User() {
  }

  public User(String name, String email, Integer age, Integer sex, String schoolName) {
    this.name = name;
    this.email = email;
    this.age = age;
    this.sex = sex;
    this.schoolName = schoolName;
  }

  @Override
  public String toString() {
    return "User{" +
      "name='" + name + '\'' +
      ", email='" + email + '\'' +
      ", age=" + age +
      ", sex=" + sex +
      ", schoolName='" + schoolName + '\'' +
      '}';
  }
}
