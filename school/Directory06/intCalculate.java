package Directory06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class intCalculate extends JFrame implements ActionListener {
    //text field数组,省一大段代码
    private String[] str = {"num1", "num2", "result"};
    private JTextField[] textFields = new JTextField[str.length];
    private JButton equals;
    private JComboBox<String> sign;
    private MesJDialog num_exception;
    private String[] signs = {"+", "-", "x", "/", "%"};

    private JRadioButton[] radios;


    public intCalculate() {
        super("加减法整数运算");
        this.setLayout(new FlowLayout());
        this.setSize(400, 200);
        this.setLocation(400, 300);
        this.setBackground(Color.WHITE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        for (int i = 0; i < this.str.length; i++) {
            this.textFields[i] = new JTextField("" +i,5);
            this.textFields[i].setHorizontalAlignment(JTextField.RIGHT);
        }
        //第一个输入框
        this.getContentPane().add(this.textFields[0]);

        //下拉框
        this.sign = new JComboBox<>(signs);
        this.sign.setEditable(false);
        this.sign.addActionListener(this);
        this.getContentPane().add(sign);

        //单选框
//        JPanel rbpanel = new JPanel(new GridLayout(1, 5));
//        this.add(rbpanel);
//        ButtonGroup bg = new ButtonGroup();
//        this.radios = new JRadioButton[signs.length];
//        for (int i = 0; i < this.radios.length; i++) {
//            rbpanel.add(this.radios[i] = new JRadioButton(signs[i]));
//            bg.add(this.radios[i]);
//        }
//        this.radios[0].setSelected(true);
//

        //第二个输入框
        this.getContentPane().add(this.textFields[1]);

        this.equals = new JButton("=");
        this.equals.addActionListener(this);
        this.getContentPane().add(equals);

        //第三个不可编辑文本框
        this.textFields[2].setEditable(false);
        this.getContentPane().add(this.textFields[2]);

        this.setVisible(true);
        this.num_exception = new MesJDialog(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.sign || e.getSource() == this.equals) {
            calculate();
        }
    }

    private void calculate() {
        int res = 0;
        try {
            int i = this.sign.getSelectedIndex();
            //int版本的
            int n1 = Integer.parseInt(this.textFields[0].getText());
            int n2 = Integer.parseInt(this.textFields[1].getText());
            switch (i) {
                case 0:
                    res = n1 + n2;
                    break;
                case 1:
                    res = n1 - n2;
                    break;
                case 2:
                    res = n1 * n2;
                    break;
                case 3:
                    //写if
                    if (n2 == 0) {
                        num_exception.show("除数不为0");
                        break;
                    } else res = n1 / n2;
                case 4:
                    //应该是浮点数就不能进行取余运算吧
                    try {
                        res = n1 % n2;
                        break;
                    } catch (Exception e2) {
                        num_exception.show("取余的数是整数");
                        break;
                    }
            }
            textFields[2].setText("" + res);
        } catch (Exception e1) {
            num_exception.show(e1.toString());
        }
    }
}
