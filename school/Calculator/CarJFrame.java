package Calculator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarJFrame extends JFrame implements ActionListener {
    private JTextField text_car;
    private JButton button_add, button_search;
    protected JList<String> jList;
    protected DefaultListModel<String> listmodel;
    private static String[] provinces = {"京", "沪", "津", "渝", "鲁", "冀", "晋", "蒙", "辽", "吉", "黑", "苏", "浙", "皖", "闽", "赣", "豫", "湘", "鄂", "粤", "桂", "琼", "川", "贵", "云", "藏", "陕", "甘", "青", "宁", "新"};
    private static String[][] cities = {{"A", "B", "C", "E", "F", "G", "H", "J", "K", "L", "M", "N", "O", "P", "Q",}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "R"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L"}, {"A", "B", "C", "F", "G", "H"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "U", "V", "Y"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "R", "T"}, {"A", "B", "C", "D", "E", "F", "H", "J", "K", "L", "M"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "V"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "U"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "U"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "U", "V", "W", "X", "Y", "Z"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R"}, {"A", "B", "C", "D", "E"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "O", "Q", "R", "S", "U", "V", "W", "X", "Y", "Z"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S"}, {"A", "B", "C", "D", "E", "F", "G"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "V"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P"}, {"A", "B", "C", "D", "E"}, {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M"}};

    public CarJFrame(String[] car) {
        super("车牌号的添加和查找");
        this.setBounds(300, 240, 350, 300);
        this.setBackground(Color.lightGray);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //新建一个面板
        JPanel jp = new JPanel(new FlowLayout());
        jp.add(new Label("车牌号"), "North");
        jp.add(this.text_car = new JTextField("苏A112233", 8));
        jp.add(this.button_add = new JButton("添加"), "North");
        this.button_add.addActionListener(this);
        jp.add(this.button_search = new JButton("查找"));
        this.button_search.addActionListener(this);
        this.add(jp, "North");

        //列表框
        this.listmodel = new DefaultListModel<String>();
        if (car != null)
            for (int a = 0; a < car.length; a++)
                this.listmodel.addElement(car[a]);
        this.jList = new JList<String>(this.listmodel);
        this.add(new JScrollPane(this.jList));

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String c = text_car.getText();
        if (e.getSource() == this.button_add) {
            try {
                if (isPlateNumber(c)) {
                    this.listmodel.addElement(c);
                }
            } catch (Exception e1) {
                JOptionPane.showConfirmDialog(this, "请输入正确的车牌！", "车牌不合法！", JOptionPane.OK_OPTION);
            }
        } else if (e.getSource() == this.button_search) {
            try {
                int n = listmodel.getSize();
                for (int i = 0; i < n; i++) {
                    if (this.text_car.getText().equals(listmodel.getElementAt(i))) {
                        this.jList.addSelectionInterval(i, i);
                        return;
                    }
                }
            } catch (Exception e3) {
                JOptionPane.showMessageDialog(this, "查找失败");
            }
            if (this.jList.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(this, "查找失败");
            }
        }
    }

    public boolean isPlateNumber(String car) {
        String m = this.text_car.getText();
        if (m.length()>8){
            JOptionPane.showConfirmDialog(this, "长度大于6", "车牌不合法！", JOptionPane.OK_OPTION);
            return false;
        }

        for (int j = 3;j<=7;j++) {
//            System.out.println(m.indexOf(i));
            if (!((m.charAt(j) >= '0' && m.charAt(j) <= '9') || (m.charAt(j) >= 'A' && m.charAt(j) <= 'Z'))) {
//            System.out.println("test");
//                System.out.println(m.indexOf(3));
                JOptionPane.showConfirmDialog(this, "后五位要为数字或大写字母", "车牌不合法！", JOptionPane.OK_OPTION);
                return false;

            }
        }
        for (int i = 0; i < 31; i++) {
            if (m.substring(0, 1).equals(provinces[i]) ){
                //只要有一个相等就行……
                for (int j = 0; j <= cities[i].length; j++) {
                    if (m.substring(1, 2).equals(cities[i][j]) )
                        return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        new CarJFrame(new String[]{"苏A12345", "苏B99999"});
    }
}

