package di01.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import di01.reflection.Employee;

public class TestEmployee {
    
    @Test
    public void testMakeInstanceWithNew() {
        // Emplyoee 인스턴스 emp 만들고
        // 세터를 이용해 필드에 값을 입력하시오
        // firstname = "aaaa";
        // lastname = "bbbb";
        // salary = 1000;
        Employee emp1 = new Employee();
        emp1.setFirstname("aaaa");
        emp1.setLastname("bbbb");
        emp1.setSalary(1000);        
        assertSame(emp1.getFirstname(), "aaaa");
        
        // 생성자를 이용해 Emplyoee 인스턴스 emp2 만들시오.
        // 필드에 설정할 값은 아래와 같다.
        // firstname = "aaaa";
        // lastname = "bbbb";
        // salary = 1000;
        Employee emp2 = new Employee("aaaa", "bbbb", 1000);
        assertSame(emp2.getLastname(), "bbbb");
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void testMakeInstanceWithReflection()
            throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {
        // Reflection 을 이용해서
        // 생성자를 이용한 Emplyoee 인스턴스 emp1을 만드시오.
        Class klass = Class.forName("di01.reflection.Employee");
        
        Class[] pramTypes = { String.class, String.class, Integer.TYPE };
        
        Constructor cons = klass.getConstructor(pramTypes);
        // Employee emp2 = new Employee("aaaa", "bbbb", 1000);
        
        Object[] objs = { "cccc", "dddd", new Integer(1000) };
        
        // 인스턴스 만들기
        Object instance = cons.newInstance(objs);
        System.out.println(instance.toString());
        
        // setter를 이용해서 필드값 바꾸기
        Method m = null;
        Object[] params = { "Hello" };
        m = klass.getDeclaredMethod("setLastname", String.class);
        m.invoke(instance, params);
        System.out.println(instance.toString());
        
        // getter 호출하기.
        m = klass.getDeclaredMethod("getLastname");
        Object result = m.invoke(instance);
        System.out.println(result);
        
        assertSame(result, "Hello");
    }
}
