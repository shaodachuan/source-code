/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.session;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

/**
 * 用于创建SqlSessionFactory
 *
 * 在这里使用了  建造者模式
 * 1. 解析Confiruation
 * 2. 创建SqlSessionFactory，避免了 用户 直接调用 XMLConfigBuild, 然后调用 XmlConfigBuilder.parse() 方法
 *
 * @see XMLConfigBuilder#parse()
 * @see Configuration
 * @see SqlSessionFactory
 * @see DefaultSqlSessionFactory
 */
public class SqlSessionFactoryBuilder {

  public SqlSessionFactory build(Reader reader) {
    return build(reader, null, null);
  }

  public SqlSessionFactory build(Reader reader, String environment) {
    return build(reader, environment, null);
  }

  public SqlSessionFactory build(Reader reader, Properties properties) {
    return build(reader, null, properties);
  }

  public SqlSessionFactory build(Reader reader, String environment, Properties properties) {
    try {
      XMLConfigBuilder parser = new XMLConfigBuilder(reader, environment, properties);
      return build(parser.parse());
    } catch (Exception e) {
      throw ExceptionFactory.wrapException("Error building SqlSession.", e);
    } finally {
      ErrorContext.instance().reset();
      try {
        reader.close();
      } catch (IOException e) {
        // Intentionally ignore. Prefer previous error.
      }
    }
  }

  /**
   *  build() - 调用三参数build(), 创建SqlSessionFactory
   *
   * @see  #build(InputStream, String, Properties)
   * @see DefaultSqlSessionFactory
   */
  public SqlSessionFactory build(InputStream inputStream) {
    // 调用三参数build()方法
    return build(inputStream, null, null);
  }

  public SqlSessionFactory build(InputStream inputStream, String environment) {
    return build(inputStream, environment, null);
  }

  public SqlSessionFactory build(InputStream inputStream, Properties properties) {
    return build(inputStream, null, properties);
  }

  /**
   * build()
   * 1. 使用XMLConfigBuild.parse(),解析xml成为Configuration
   * 2. 根据Configuration，创建SqlSessionFactory
   *
   * @see XMLConfigBuilder#parse()
   * @see #build(Configuration)
   */
  public SqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
    try {
      // 根据配置文件，创建XMLConfigBuilder
      XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, environment, properties);
      // 1. 使用XMLConfigBuilder.parse()，解析XML,成为Configuration对象
      // 2. 根据Confiuration,创建SqlSessionFactory对象
      return build(parser.parse());
    } catch (Exception e) {
      throw ExceptionFactory.wrapException("Error building SqlSession.", e);
    } finally {
      ErrorContext.instance().reset();
      try {
        inputStream.close();
      } catch (IOException e) {
        // Intentionally ignore. Prefer previous error.
      }
    }
  }

  /**
   *  build() - 使用Configuration，new一个DefaultSqlSessionFactory
   *
   * @see Configuration
   * @see DefaultSqlSessionFactory
   */
  public SqlSessionFactory build(Configuration config) {
    return new DefaultSqlSessionFactory(config);
  }

}
