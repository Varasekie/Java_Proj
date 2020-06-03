package Directory03;

public class Student1 extends Person1 {
    public String name;

    public Student1(String name) {
        //记住这边一定要有空的构造方法，不然会报错，
        // 如果没有super，本质是会先调用无参构造方法
//        super(name);
//        super(name);
        this.name = name;
    }


    @Override
    public void setName(String name) {
//        super(name);
    }

    public static void main(String[] args) {
        Student1 stu = new Student1("aabbcc");
        System.out.println(stu.toString());
    }
}
