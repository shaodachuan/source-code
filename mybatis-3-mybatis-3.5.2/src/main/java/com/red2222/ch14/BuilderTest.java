package com.red2222.ch14;

/**
 * 哈哈哈哈
 *
 * @author red2222
 * @date 2024/1/3
 */
public class BuilderTest {

  public static void main(String[] args) {

    User user03 =  new SunnySchoolUserBuilder().setName("Candy").setSex(1).build();
    System.out.println(user03);
  }
}
