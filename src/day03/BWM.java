package day03;

//bwm的产品接口
public interface BWM {
    //比如有信息介绍等
    //发动方式

    void showInfo();
}

class BWM3 implements BWM{

    @Override
    public void showInfo() {
        System.out.println("BWM3的showinfo");
    }
}

class BWM5  implements BWM{

    @Override
    public void showInfo() {
        System.out.println("BWM5的showinfo");
    }
}

class BWM7 implements BWM{

    @Override
    public void showInfo() {
        System.out.println("BWM7的showinfo");
    }
}

