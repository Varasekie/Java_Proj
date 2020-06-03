package Directory03;

public class Person1 {
    public String name;

    public Person1(){

    }
    public Person1(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        //写的是父类的name
        return name;
    }
}
