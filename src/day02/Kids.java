package day02;

public class Kids  extends ManKind{
    //继承父类ManKind
    public int yearsOld;

    public void printAge(){
        System.out.println(yearsOld);
    }

    //重写方法
    @Override
    public void employeed() {
        super.employeed();
        System.out.println("kids no job");
    }

    public static void main(String[] args) {
        Kids someKid = new Kids();

        //字类访问父类的方法
        someKid.sex = 0;
        someKid.manOrWoman();

        someKid.salary = 4;
        someKid.employeed();

    }
}
