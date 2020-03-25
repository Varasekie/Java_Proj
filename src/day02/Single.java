package day02;

public class Single {
    //饿汉式

    //让single类变成私有，使其只能被single这个类里面的方法调用
    private Single(){

    }

    //创建一个能创建新class的方法
    private static Single single = new Single();

    //一个能返回（新建对象的)方法的方法
    public static Single getInstance(){
        return single;
    }
}
