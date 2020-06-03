package Directory06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentJFrame extends JFrame implements ActionListener {
    StudentJPanel stu;


    public StudentJFrame(StudentJPanel stuJP){
        super("student");
        this.setSize(700,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //split
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        this.getContentPane().add(split);
        this.stu = stuJP;
        split.add(this.stu);
        split.setDividerLocation(150);
        split.setOneTouchExpandable(true);

        //右边的列表
        JPanel jp = new JPanel(new BorderLayout());

        split.add(jp);

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //是右边面板的响应事件吧
    }
}
