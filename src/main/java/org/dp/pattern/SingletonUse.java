package org.dp.pattern;

import org.dp.pattern.Singleton.Singleton2;
import org.dp.pattern.Singleton.Singleton3;
import org.dp.pattern.Singleton.Singleton4;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonUse {
    public SingletonUse() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {

        /**
         * 싱글톤이 깨지는 법
         * : 다른 객체가 생성되어 싱글톤 깨짐.
         *
         * 1. 리플렉션 이용하기 - 대응불가능
         * 2. 직렬화/역직렬화 - readResolve 를 이용하여 대응가능.
         */

        // 1. 리플렉션 이용하기
        Singleton2 singleton2 = Singleton2.getInstance();
        Constructor<Singleton2> constructor = Singleton2.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton2 singleton21 = constructor.newInstance();

        System.out.println(singleton2 == singleton21);


        // 2. 직렬화/역직렬화
        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton3 singleton31 = null;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton3.obj"))) {
            out.writeObject(singleton3);
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("singleton3.obj"))) {
            singleton31 = (Singleton3) in.readObject();
        }

        System.out.println(singleton3 == singleton31);


        /**
         * 리플렉션 방지법
         * 장점 :
         * - enum 은 리플렉션 막혀있음.
         * - 직렬화 역직렬화에 안전함.
         * 단점 : 클래스가 미리 만들어짐.
         */

        Singleton4 singleton4 = Singleton4.INSTANCE;


        /**
         * @정리
         * 권장 방법
         * - enum
         * - 스태틱 이너클래스 holder 를 사용한 방법
         */
    }
}
