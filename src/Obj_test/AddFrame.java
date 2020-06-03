package Obj_test;

import java.awt.*;

public class AddFrame extends Frame {
    public AddFrame(){
        //title,size,flow,background
        super("加法运算");
        this.setBackground(Color.WHITE);
        this.setSize(300,400);
        //框架布局居中
        this.setLayout(new FlowLayout());

        //label,textarea,botton
        this.add(new TextField("200",4));
        this.add(new Label("+"));
        this.add(new TextField("100",4));
        this.add(new Button("="));
        this.add(new TextField(20));

        //显示框架，在添加组件之后
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new AddFrame();
    }
}
