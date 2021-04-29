package hello.core.singleton;

public class StatefulService {
    /*private int price;
    public void order(String name, int price) {
        System.out.println("name = " + " price " + price);
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
    //싱글톤 패턴에선 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다.
    */

    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        return price;
    }
}
