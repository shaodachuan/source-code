package com.red2222.ch14;

/**
 * 哈哈哈哈
 *
 * @author red2222
 * @date 2024/1/3
 */
public class SunnySchoolUserBuilder {

  private String name;
  private String email;
  private Integer age;
  private Integer sex;
  private String schoolName;


  public SunnySchoolUserBuilder() {
  }

  public SunnySchoolUserBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public SunnySchoolUserBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public SunnySchoolUserBuilder setAge(Integer age) {
    this.age = age;
    return this;
  }

  public SunnySchoolUserBuilder setSex(Integer sex) {
    this.sex = sex;
    return this;
  }

  public SunnySchoolUserBuilder setSchoolName(String schoolName) {
    this.schoolName = schoolName;
    return this;
  }

  public User build() {
    // 邮箱是null
    if(this.name != null && this.email == null) {
      this.email = this.name.toLowerCase().replace(" ","").concat("@sunnyschool.com");
    }
    // age == null
    if (this.age == null) {
      this.age = 7;
    }
    //sex = null
    if(this.sex == null) {
      this.sex = 0;
    }
    this.schoolName = "Sunny School";
    return new User(name,email,age,sex,schoolName);
  }
}
