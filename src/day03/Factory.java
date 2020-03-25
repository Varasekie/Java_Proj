package day03;

public interface Factory {
    //最后要返回一个BWM类型，所以在这里先声明一个BWM的变量
    public BWM productBWM();

}

class BWM3Factory implements Factory {

    @Override
    public BWM productBWM() {
        System.out.println("BWM3 factory");
        //返回一个具体的，匿名名称
        return new BWM3();
    }
}

class BWM5Factory implements Factory {

    @Override
    public BWM productBWM() {
        System.out.println("BWM5 factory");
        //返回一个具体的，匿名名称
        return new BWM5();
    }
}

class BWM7Factory implements Factory {

    @Override
    public BWM productBWM() {
        System.out.println("BWM7 factory");
        //返回一个具体的，匿名名称
        return new BWM7();
    }
}