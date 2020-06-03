package Directory03;

public class Student extends Person {

    public String speciality;

    //覆盖父类的count
    private static int count=0;
    @Override
    public void finalize() {
        super.finalize();
        //子类去调用父类的析构方法
        count--;
    }

    public static void howMany(){
        Person.howMany();
        //静态方法不能用super，无实例化
        System.out.println(Student.count + "student count number");
    }

    public String toString(){
        return super.toString() + "student d tostring";
    }
}
