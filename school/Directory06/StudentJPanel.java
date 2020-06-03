package Directory06;

import Directory03.Person;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.*;

public class StudentJPanel extends JPanel implements CaretListener, ActionListener {
    private JTextField name;
    //还是用三个textfiled算了
    String bir[] = {"年", "月", "日"};
    private JTextField[] birth = new JTextField[bir.length];
    private JList studentList;
    private JRadioButton[] sex_radios, politic_radios;
    private MesJDialog msj;

    //地区下拉框
    private static String[] province = {"江苏", "浙江", "安徽"};
    private static String[][] cities = {{"南京", "无锡", "苏州", "南通", "常州"}, {"杭州", "嘉兴", "义乌"}, {"合肥", "芜湖"}};
    private JComboBox<String> province_combo,city_combo;

    public StudentJPanel() {
        this.setBorder(new TitledBorder("students"));
        this.setBackground(Color.WHITE);
        this.setLayout(new GridLayout(5, 1));

        this.name = new JTextField("姓名");
        this.add(this.name);

        //生日用这样表现也可以啊
        JPanel birthday = new JPanel(new GridLayout(1, 6));
        this.add(birthday);
        for (int i = 0; i < bir.length; i++) {
            this.birth[i] = new JTextField(60);

            birthday.add(birth[i]);
            birthday.add(new JLabel(bir[i]));
        }


        //按钮组，但是好像不是这一个面板的，记得复制粘贴
//        JPanel botton = new JPanel(new GridLayout(1, 3));
//        this.add(botton);
//        String[] strings = {"add", "moveAll", "moveThis"};
//        JButton[] jButtons = new JButton[strings.length];
//        for (int i = 0; i < jButtons.length; i++) {
//            jButtons[i] = new JButton(strings[i]);
//            jButtons[i].addActionListener(this);
//            botton.add(jButtons[i]);
//        }

        JPanel sex = new JPanel(new GridLayout(1, 2));
        this.add(sex);
        String[] strings = {"男", "女"};
        ButtonGroup bg = new ButtonGroup();
        this.sex_radios = new JRadioButton[strings.length];
        for (int i = 0; i < strings.length; i++) {
            this.sex_radios[i] = new JRadioButton(strings[i]);
            sex.add(sex_radios[i]);
            bg.add(sex_radios[i]);//放在单选里面为了只能选一个
        }


        //对地方
        JPanel politic = new JPanel(new GridLayout(1,3));
        String[] str = {"是","否"};
        this.add(politic);
        politic.add(new JLabel("团员"));
        ButtonGroup poli_bottons = new ButtonGroup();
        this.politic_radios = new JRadioButton[2];
        for (int i = 0;i<2;i++){
            this.politic_radios[i] = new JRadioButton(str[i]);
            poli_bottons.add(politic_radios[i]);
            politic.add(politic_radios[i]);
        }

        //对地方

        this.setVisible(true);
    }


    @Override//文本编辑事件处理方法
    public void caretUpdate(CaretEvent e) {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("");
        //要实现按钮按下的工作

        //然后是birth的作用

    }
}
