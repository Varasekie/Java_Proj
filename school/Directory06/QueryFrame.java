package Directory06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class QueryFrame extends Frame implements ActionListener {

    private TextField text_char, text_uni, text_16;
    private Button button_char, button_uni;

    public QueryFrame() {
        super("编码器");
        this.setBackground(Color.WHITE);
        this.setBounds(300, 240, 310, 90);

        //框架网络布局
        this.setLayout(new GridLayout(3, 3));
        this.add(new Label("字符", Label.RIGHT));//右对齐,文本框
        this.text_char = new TextField("test", 10);
//        this.text_char.addKeyListener(new KeyAdapt() );
        this.text_char.addActionListener(this);
        this.add(text_char);


        this.button_char = new Button("变成unicode");//第一行按钮
        this.add(button_char);
        this.button_char.addActionListener(this);

        this.add(new Label("uni", Label.RIGHT));//右对齐，第二行文本框
        this.text_uni = new TextField(" ", 10);
        this.text_uni.addActionListener(this);
        this.add(text_uni);
        this.button_uni = new Button("查询字符");
        this.add(button_uni);
        this.button_uni.addActionListener(this);

        //文本行，自动变成十六进制,这个应该不能有焦点吧,第三行
        this.add(new Label("十六进制unicode", Label.RIGHT));
        this.text_16 = new TextField("", 10);
        this.add(text_16);
        this.add(new Button("test"));
        //最后一定要注册窗口事件监听……
        this.setVisible(true);
        this.addWindowListener(new WinClose());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button_char || e.getSource() == this.text_char) {
            String str = this.text_char.getText();
            if (!str.isEmpty()) {
                char ch = str.charAt(0);
                //重新设置文本
                this.text_char.setText(ch + "");
                this.text_uni.setText((int) ch + "");
                //注意是toHesString
                String i = Integer.toHexString((int) ch);
                this.text_16.setText("0x" + i + "");
            }
        }

        if (e.getSource() == this.button_uni || e.getSource() == this.text_uni) {
            String str = this.text_uni.getText();
            if (!str.isEmpty()) {
                try {
                    this.text_char.setText("" + (char) Integer.parseInt(str));
//                    int i = Integer.parseInt(str+"",16);
                    String i = Integer.toHexString(Integer.parseInt(str));
                    this.text_16.setText(i + "");
                } catch (NumberFormatException ex) {
                    this.text_char.setText("无法转化");
                    this.text_16.setText("无法转化");
                }
            }
        }
    }

    public static void main(String[] args) {
        new QueryFrame();
    }

}


