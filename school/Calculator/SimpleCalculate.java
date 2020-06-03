package Calculator;
import java.awt.*;
import java.awt.event.*;
import java.security.MessageDigest;

import javax.swing.*;

public class SimpleCalculate implements ActionListener,ItemListener
{
    public static JFrame jf;
    public static Container c;
    public static JTextField jtf1,jtf2,jtf3;
    public static JButton jb1;
    public static Choice c2;
    public static MessageDigest m1;

    public static String fuhao="";

    public SimpleCalculate(){
        jf=new JFrame("简易计算器");
        c=jf.getContentPane();
        c.setLayout(new FlowLayout());
        jtf1=new JTextField(10);
        jtf2=new JTextField(10);
        jtf3=new JTextField(10);
        c2=new Choice();
        jb1=new JButton("=");
    }

    public void Jiemian(){
        c.add(jtf1);
        c2.addItemListener(this);
        c2.add("");
        c2.add("+");
        c2.add("-");
        c2.add("*");
        c2.add("/");
        c.add(c2);
        c.add(jtf2);
        jb1.addActionListener(this);
        c.add(jb1);
        c.add(jtf3);

        jf.setLocation(200,100);
        jf.setVisible(true);
        jf.pack();
    }
    public static void main(String args[]){
        SimpleCalculate sc= new SimpleCalculate();
        sc.Jiemian();
    }

    public void actionPerformed(ActionEvent e) {
        double s1=Integer.parseInt(jtf1.getText());
        double s2=Integer.parseInt(jtf2.getText());
        double result=0;
        if(fuhao.equals("+")){
            result=s1+s2;
            String result2=String.valueOf(result);
            jtf3.setText(result2);
        }
        if(fuhao.equals("-")){
            result=s1-s2;
            String result2=String.valueOf(result);
            jtf3.setText(result2);
        }
        if(fuhao.equals("*")){
            result=s1*s2;
            String result2=String.valueOf(result);
            jtf3.setText(result2);
        }
        if(fuhao.equals("/")){
            result=s1/s2;
            try{
                if(s2 == 0){
                }
            }catch(Exception e1){
            }finally{
                JOptionPane.showMessageDialog(null, "被除数错误", "警告",JOptionPane.WARNING_MESSAGE);
            }
            String result2=String.valueOf(result);
            jtf3.setText(result2);
        }
    }

    public void itemStateChanged(ItemEvent ie){
        if(ie.getSource()==c2){
            String str1=c2.getSelectedItem();
            fh(str1);
        }
    }
    public String fh(String str2){
        return fuhao=str2;
    }
}
