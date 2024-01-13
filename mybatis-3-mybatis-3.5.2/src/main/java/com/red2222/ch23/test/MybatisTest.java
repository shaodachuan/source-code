package com.red2222.ch23.test;

import com.red2222.ch23.mapper.UserMapper;
import com.red2222.ch23.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 哈哈哈哈
 *
 * @author red2222
 * @date 2023/12/30
 */
public class MybatisTest {

    public static void main(String[] args) throws IOException {
        // 加载配置文件，获取输入流
        InputStream resource = Resources.getResourceAsStream("com/red2222/ch23/mybatis-config.xml");
        //  创建SqlSessionFactory
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(resource);
        //  创建SqlSession - Java程序和数据库之间的会话
        SqlSession sqlSession = ssf.openSession(true);
        // SqlSession sqlSession = ssf.openSession(true);
        // 获取Mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        // 使用Mapper接口，执行映射文件的SQL
        int count = userMapper.insertUser(new User());


        // 因为使用了JDBC事务管理器，需要提交事务
        //sqlSession.rollback();


        System.out.println("执行插入，影响的行数:" + count);

    }
}
