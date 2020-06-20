package StudentManageSystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentJPanel extends PersonJPanel {

    private JRadioButton[] policy;
    private String[] str = {"学号","系","专业"};
    private JPanel[] jPanels = new JPanel[str.length];
    private JTextField[] jTextFields = new JTextField[str.length];

    public StudentJPanel() {
        super();
        this.setLayout(new GridLayout(9, 1));
        this.setBorder(new TitledBorder("学生"));

        for (int i = 0;i<str.length;i++){
            this.jPanels[i]=new JPanel(new GridLayout(1,2));
            this.jPanels[i].add(new JLabel(str[i]));
            this.jPanels[i].add(jTextFields[i] = new JTextField(""));
            this.add(jPanels[i]);
        }



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
            this.jTextFields[0].setText(s.number);
            this.jTextFields[1].setText(s.academy);
            this.jTextFields[2].setText(s.speciality);
            if (s.policy.equals("是")){
                this.policy[0].setSelected(true);
            }else this.policy[1].setSelected(true);
        }
    }

    public Student get() {
        //重新写另一个函数？可不可以并成一个啊//完成了，并成一个了6.2//22:52
        //number
        try {
            int num = Integer.parseInt(this.jTextFields[0].getText());
            String poli = policy[0].isSelected() ? policy[0].getText() : policy[1].getText();
            return new Student(super.get(), this.jTextFields[1].getText(), this.jTextFields[2].getText(), this.jTextFields[0].getText(), poli);
        } catch (NumberFormatException ex2) {
            JOptionPane.showMessageDialog(this, ex2.getMessage() + "不能变成整数");
        }catch (NullPointerException ex1){

        }
        return null;
    }
}


