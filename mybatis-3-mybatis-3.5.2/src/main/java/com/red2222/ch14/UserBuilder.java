package com.red2222.ch14;

/**
 * UserBuilder - 建造者模式
 *
 * @author red2222
 * @date 2024/1/3
 */
public interface UserBuilder {

  public UserBuilder setEmail(String email);
  public UserBuilder setAge(Integer age);
  public UserBuilder setSex(Integer sex);
}
