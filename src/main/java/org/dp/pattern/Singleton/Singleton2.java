package org.dp.pattern.Singleton;

/**
 * 권장 방법2 - static inner 클래스를 이용한 싱글톤 클래스
 */
public class Singleton2 {
    private Singleton2() {
    }

    /**
     * 리플렉션으로 객체를 생성하게되면 다른 객체가 생성된다.
     */
    private static class SingletonHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return SingletonHolder.INSTANCE;
    }


}
