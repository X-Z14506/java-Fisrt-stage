package annotation.annotation02;

import java.lang.reflect.Method;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-01
 * Time:10:09
 */


public class MyAnnotationTest {

    @MyAnnotation(username = "admin",password = "123456")
    public void doSome() {

    }


    @MyAnnotation(username = "张三",password = "000")
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //获取MyAnnotationTest的doSome方法上面的注解信息

        //先获取类
        Class c = Class.forName("annotation.annotation02.MyAnnotationTest");
        //在获取类中的方法
        Method doSomeMethod = c.getDeclaredMethod("doSome");
        //判断该方法上是否存在这个注解
        if (doSomeMethod.isAnnotationPresent(MyAnnotation.class)) {
            //如果存在，获取这个方法上面的注解
            MyAnnotation myAnnotation = doSomeMethod.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation.username());
            System.out.println(myAnnotation.password());
        }

        //获取main方法上面的注解
        Method doSomeMethod1 = c.getDeclaredMethod("main", String[].class);
        //判断该方法上是否存在这个注解
        if (doSomeMethod1.isAnnotationPresent(MyAnnotation.class)) {
            //如果存在，获取这个方法上面的注解
            MyAnnotation myAnnotation1 = doSomeMethod1.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation1.username());
            System.out.println(myAnnotation1.password());
        }
    }
}
