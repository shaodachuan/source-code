/**
 *    Copyright 2009-2018 the original author or authors.
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
package org.apache.ibatis.reflection.invoker;

import java.lang.reflect.Field;

import org.apache.ibatis.reflection.Reflector;

/**
 * SetFieldInvoker - 通过反射，设置字段的值
 *
 * @author Clinton Begin
 */
public class SetFieldInvoker implements Invoker {
  private final Field field;

  public SetFieldInvoker(Field field) {
    this.field = field;
  }

  /*
  * 调用Field.set， 设置字段值，设置失败，IllegalAccessException
  * */
  @Override
  public Object invoke(Object target, Object[] args) throws IllegalAccessException {
    try {
      // 设置字段
      field.set(target, args[0]);
    } catch (IllegalAccessException e) {
      if (Reflector.canControlMemberAccessible()) {
        // 设置失败，重新设置
        field.setAccessible(true);
        field.set(target, args[0]);
      } else {
        // 抛出异常
        throw e;
      }
    }
    return null;
  }

  /*
  * 返回字段类型
  * */
  @Override
  public Class<?> getType() {
    return field.getType();
  }
}
