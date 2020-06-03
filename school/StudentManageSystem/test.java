package StudentManageSystem;

public class test {
    public static void main(String[] args) {
//        String string = "2000年3月1日";
//        String[] sp = {"年","月","日"};
//        String[] data_year = string.split(sp[0]);
//        System.out.println(Integer.parseInt(data_year[0]));
//        String[] data_month = data_year[1].split(sp[1]);
//        System.out.println(Integer.parseInt(data_month[0]));
        Person[] ps = {
                new Person("abc",new MyDate(2000,1,1),"女","江苏","南京"),
                new Person("def",new MyDate(2004,6,1),"男","江苏","无锡"),
                new Student("cly",new MyDate(2002,2,1),"男","江苏","苏州","计算机","大数据","202190301","是"),
        };

        Student[] students = {
                new Student("张三",new MyDate(2001,2,1),"男","江苏","苏州","计算机","大数据","001","是"),
                new Student("李四",new MyDate(2000,2,1),"女","江苏","南京","计算机","计嵌","003","不是"),
                new Student("abc",new MyDate(2002,2,1),"男","江苏","苏州","计算机","数嵌","005","是"),
                new Student("王五",new MyDate(2003,2,4),"女","江苏","","计算机","大数据","007","不是"),

        };
///        new PersonJFrame(ps,new PersonJPanel());
        new StudentJFrame(students,new StudentJPanel());
    }
}
