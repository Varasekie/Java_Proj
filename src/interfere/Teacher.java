package interfere;

public class Teacher extends Person1 implements Cook ,Singer{

    String course ;

    public Teacher(){
        super();
        super.age = 18;
        super.name = "hello";
        super.sex = 1;

    }
    @Override
    public void cook() {
        System.out.println("cooking method");

    }

    public void getInfo(){
        System.out.println("Teacher get info");
    }

    @Override
    public void sing() {
        System.out.println("singing method");
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.cook();
        teacher.sing();

        Person1 person1 = new Teacher();
        person1.getInfo();
        //发现person1在这里不能访问Teacher的其他方法

        Singer singer = new Teacher();
        singer.sing();

        Cook cook = new Teacher();
        cook.cook();

    }
}
