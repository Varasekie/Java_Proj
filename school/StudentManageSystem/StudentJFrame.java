package StudentManageSystem;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class StudentJFrame extends PersonJFrame {

    protected StudentJPanel StudentJPanel;

//    public StudentJFrame(Student [] stus) {
//        super(stus,new StudentJPanel());
//        this.setSize(900,292);
//    }

    public StudentJFrame(Student[] stus, StudentJPanel studentJPanel) {
        super(stus, studentJPanel);
        this.setSize(900, 340);
        this.setTitle("学生管理系统");
        //查找里面加一个（不用监听吗？
        this.comboxs[0].addItem("学号");//
        this.comboxs[1].addItem("学号");//给排序添加选择


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if (e.getSource() instanceof JComboBox) {
            if (e.getSource() == this.comboxs[0] && this.comboxs[0].getSelectedIndex() == 2) {
                selectAll(this.listModel, this.jList, (Student) this.personJPanel.get(), new EqualNumber());

            } else if (e.getSource() == this.comboxs[1] && this.comboxs[1].getSelectedIndex() == 2) {
                sort(this.listModel, new CompareNumber());
            }
        }

        if (e.getSource() == this.comboxs[0] && this.comboxs[0].getSelectedIndex() == 2) {
            //直接调用static方法
            selectAll(this.listModel, this.jList, (Student) this.personJPanel.get(), new EqualName());
        } else if (e.getSource() == this.comboxs[1] && this.comboxs[1].getSelectedIndex() == 2) {
            sort(this.listModel, new CompareNumber());
        }


    }
}
