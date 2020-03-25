package day02;

public class Single1 {
    //懒汉式
    //一开始没有new对象，到调用了再new

    private Single1(){

    }

    private static Single1 s1 = null;

    public Single1 getS1(){
        if (s1 == null){
            s1 = new Single1();
        }
        return s1;
    }
}
