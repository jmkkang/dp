package org.dp.pattern.Singleton;

import java.io.Serializable;

public class Singleton3 implements Serializable {
    private Singleton3() {
    }

    /**
     * 리플렉션으로 객체를 생성하게되면 다른 객체가 생성된다.
     */
    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }


    /**
     * 역직렬화를 사용해도 새객체 생성하지 못하게 하는 방법
     * readResolve 시그니처를 작성하게되면 getInstance 를 사용하여 동일객체 반환.
     * 명시적인 오버라이딩은 아닌데, 오버라이딩 기능.
     */
    protected Object readResolve(){
        return getInstance();
    }
}
