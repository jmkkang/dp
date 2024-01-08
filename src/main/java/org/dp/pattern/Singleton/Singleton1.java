package org.dp.pattern.Singleton;

public class Singleton1 {


    private static volatile Singleton1 singleton1;

    private Singleton1() {
    }

    /**
     * thread safe 한 방법 : 'double checked locking' 기법 (volatile 키워드 사용필수)
     *  - 1,2 번 스레드 동시 진입시 스레드 1번 만 synchronized 통과o, 2번은 통과x
     * 메소드에 synchronized 를 쓰지 않고 if문 안에서 사용하는 이유
     *  - synchronized 가 성능에 좋지 않기 때문에 if (singleton == null)가 동시에 걸린 경우에만 동기화처리가 되도록 함.
     */
    public static Singleton1 getInstance() {
        if (singleton1 == null) {
            synchronized (Singleton1.class) {
                if (singleton1 == null) {
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
