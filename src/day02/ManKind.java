package day02;

public class ManKind {
    public int sex ;
    public int salary;

    //类的构造
    public ManKind(){

    }
    public ManKind(int sex){
        this.sex = sex;
    }

    public ManKind(int sex,int salary){
        this.sex = sex;
        this.salary = salary;
    }


    public void manOrWoman(){
        if (sex == 1){
            System.out.println("man");
        }else System.out.println("women");
    }

    public void employeed(){
        if (salary == 0){
            System.out.println("no job");
        }else System.out.println("job");
    }
}
