package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    //static영역에 객채 instance를 미리 생성
    public static SingletonService getInstance() {
        return instance;
    }

    //2. 이 객체 인스턴스가 필요하면 오직 getInstance 메소드를 통해서만 조회
    //이 메서드를 호출하면 항상 같은 인스턴스를 반환

    private SingletonService() {
    }
    //3. 딱 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 막아서 외부에 인스턴스가 생성되는것을 막는다.

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
