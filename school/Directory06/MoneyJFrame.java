package Directory06;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MoneyJFrame extends JFrame implements CaretListener, ComponentListener {
    private MessageJDialoge jdialog;
    private JTextField money, text_str;

    public MoneyJFrame() {
        super("daxiejine");
        this.setBounds(300, 240, 360, 110);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addComponentListener(this);

        this.getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.getContentPane().add(new JLabel("money", JLabel.RIGHT));
        this.money = new JTextField("123.00", 40);
        this.money.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(money);
        this.money.addCaretListener(this);

        this.getContentPane().add(new JLabel("中文", JLabel.LEFT));
        this.text_str = new JTextField(40);
        this.text_str.setHorizontalAlignment(JTextField.RIGHT);
        this.text_str.setEditable(false);
        this.getContentPane().add(text_str);
        caretUpdate(null);//?默认为null，当监听到之后再做反应
        this.setVisible(true);
        this.jdialog = new MessageJDialoge();//内部类构造
    }


    private class MessageJDialoge extends JDialog {
        private JLabel jLabel;

        private MessageJDialoge() {
            super(MoneyJFrame.this, "提示", true);
            this.setSize(420, 110);
            this.jLabel = new JLabel("", JLabel.CENTER);
            this.getContentPane().add(this.jLabel);
            this.setDefaultCloseOperation(HIDE_ON_CLOSE);
            this.addComponentListener(MoneyJFrame.this);
        }

        private void show(String str) {
            this.jLabel.setText(str);
            this.setLocation(MoneyJFrame.this.getX() + 100, MoneyJFrame.this.getY() + 100);
            this.setVisible(true);
        }
    }

    //改变框架大小，其他的也改变
    @Override
    public void componentResized(ComponentEvent e) {
        Component c = e.getComponent();
        int size = (c.getWidth() + c.getHeight()) / 40;
        Font f = new Font("宋体", 1, size);
        if (c instanceof JFrame) {
            int n = this.getComponentCount();
            for (int i = 0; i < n; i++) {
                this.getContentPane().getComponent(i).setFont(f);
            }
        } else if (c instanceof JDialog) {
            this.jdialog.jLabel.setFont(f);
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void caretUpdate(CaretEvent e) {
        String money = this.money.getText();
        if (money.isEmpty()) {
            this.money.setText("");
        } else try {
            double x = Double.parseDouble(money);
            System.out.println(RMB.toString(x));
            this.text_str.setText(RMB.toString(x));
        } catch (Exception e1) {
            this.jdialog.show("\"" + "cannot be the china" + "\"");
//            System.out.println(e1);
        }
    }
}
