package StudentManageSystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentJPanel extends PersonJPanel {

    private JTextField text_number, text_academy, text_speciality;
    private JRadioButton[] policy;

    public StudentJPanel() {

        this.setLayout(new GridLayout(9, 1));
        this.setBorder(new TitledBorder("学生"));
        this.add(this.text_number = new JTextField("202190301"));
        this.add(this.text_academy = new JTextField("系"));
        this.text_academy.addActionListener(this);
        this.add(this.text_speciality = new JTextField("大数据"));
        this.text_speciality.addActionListener(this);

        //团员
        JPanel poli = new JPanel(new GridLayout(1, 3));
        poli.add(new JLabel("团员"));
        String[] poli_str = {"是", "不是"};
        ButtonGroup poli_bg = new ButtonGroup();
        this.policy = new JRadioButton[poli_str.length];
        for (int i = 0; i < poli_str.length; i++) {
            this.policy[i] = new JRadioButton(poli_str[i]);
            poli_bg.add(this.policy[i]);
            poli.add(this.policy[i]);
        }
        this.policy[0].setSelected(true);
        this.add(poli);

        this.setVisible(true);
    }



    public void set(Person p){
        super.set(p);
        if (p instanceof Student){
            Student s = (Student)p;
            this.text_number.setText(s.number);
            this.text_academy.setText(s.academy);
            this.text_speciality.setText(s.speciality);
            if (s.policy.equals("是")){
                this.policy[0].setSelected(true);
            }else this.policy[1].setSelected(true);
        }

    }

    public Student get() {

        //重新写另一个函数？可不可以并成一个啊//完成了，并成一个了6.2//22:52
        //number
        try {
            //免得出现20219yy的现象吧
            int num = Integer.parseInt(this.text_number.getText());
            String poli = policy[0].isSelected() ? policy[0].getText() : policy[1].getText();
            return new Student(super.get(), this.text_academy.getText(), this.text_speciality.getText(), this.text_number.getText(), poli);
        } catch (NumberFormatException ex2) {
            JOptionPane.showMessageDialog(this, ex2.getMessage() + "不能变成整数");
        }
        return null;
    }
}


