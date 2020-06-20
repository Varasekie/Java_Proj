package StudentManageSystem;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Comparator;

public class StudentJFrame extends PersonJFrame {

    protected static Equalable[] equalable = {new EqualNumber(), new EqualPolity(), new EqualAcademy(), new EqualSpeciality()};
    protected static Comparator[] comparator = {new CompareNumber(), new ComparePolicy(), new CompareAcademy(), new CompareSpeciality()};


//    public StudentJFrame(Student [] stus) {
//        super(stus,new StudentJPanel());
//        this.setSize(900,292);
//    }

    public StudentJFrame(Student[] stus, StudentJPanel studentJPanel) {
        super(stus, studentJPanel);
        this.setSize(900, 340);
        this.setTitle("学生管理系统");
        //查找里面加一个（不用监听吗？
        String[] str = {"学号", "是否团员", "院系", "专业"};

        //给排序添加选择
        for (int i = 0; i < str.length; i++) {
            this.comboxs[0].addItem(str[i]);
            this.comboxs[1].addItem(str[i]);
        }

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if (e.getSource() instanceof JComboBox) {
            //这两种表达方式应该都行吧，我更倾向于Item
            if (e.getSource() == this.comboxs[0]) {
                int i = this.comboxs[0].getSelectedIndex();
                if (i >= equalables.length) {
                    selectAll(this.listModel, this.jList, this.personJPanel.get(), equalable[i - equalables.length]);
                }
            }
//            if (e.getSource() == this.comboxs[0] && this.comboxs[0].getSelectedIndex() == 4) {
//                selectAll(this.listModel, this.jList, (Student) this.personJPanel.get(), new EqualNumber());
//
//            }
            if (e.getSource() == this.comboxs[1]) {
                int j = this.comboxs[1].getSelectedIndex();
                if (j >= comparators.length) {
                    sort(this.listModel, comparator[j - comparators.length]);
//                    System.out.println(comparator[j-comparators.length].toString());
                }
            }
        }
        //如果只有学号一个方法的话,可以用这个方法写
//        if (e.getSource() == this.comboxs[0] && this.comboxs[0].getSelectedIndex() == 2) {
//            //直接调用static方法
//            selectAll(this.listModel, this.jList, (Student) this.personJPanel.get(), new EqualName());
//        } else if (e.getSource() == this.comboxs[1] && this.comboxs[1].getSelectedIndex() == 2) {
//            sort(this.listModel, new CompareNumber());
//        }
    }
}
