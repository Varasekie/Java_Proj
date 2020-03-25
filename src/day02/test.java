package day02;

public class test {
    public void test1(Person a) {

        System.out.println(a.getClass().getName());
        if (a instanceof Student) {

            //showInfo是students和person都有的方法
            //但是这边就是调用的students的方法
            a.showInfo();
            ((Person) a).showInfo();

            //???为什么这里给强制转化了
            //getschool是student的方法

            //((day02.Student) a).getschool();
        } else if (a instanceof Person) {
            a.showInfo();
        }
    }

    public static void main(String[] args) {
//        day02.test t = new day02.test();
//        day02.test t1 = new day02.test();
//        day02.Student a = new day02.Student();
//        t.test1(a);
//        //a.getschool();
//
//        System.out.println("--------------");
//        day02.Person b = new day02.Person();
//        t.test1(b);

        //由于是static方法，可以直接通过类名+方法调用
        //一下创建的三个方法，其实只有创建了一个对象，这三个引用都指向了一个对象
        Single single = Single.getInstance();
        Single single1 = Single.getInstance();
        Single single2 = Single.getInstance();



//        String a = "123";
//        System.out.println(a instanceof Object);
//        System.out.println(Object instanceof a);


    }
}
