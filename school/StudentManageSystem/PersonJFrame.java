package StudentManageSystem;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Comparator;

public class PersonJFrame extends JFrame implements ActionListener, ListSelectionListener {
    protected JList<Person> jList;
    protected DefaultListModel<Person> listModel;
    protected PersonJPanel personJPanel;
    protected JComboBox[] comboxs;
    protected static Equalable[] equalables = {new EqualName(), new EqualBirth(), new EqualProvince(), new EqualCity()};

    protected static Comparator[] comparators = {new CompareName(), new CompareBirth(), new CompareProvince(), new CompareCity()};

    public PersonJFrame(Person[] pers) {
        this(pers, new PersonJPanel());
    }

    public PersonJFrame(Person[] pers, PersonJPanel personJPanel) {
        super("person对象管理");
        this.setSize(900, 253);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //分割窗格
        JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        this.getContentPane().add(jsp);
        this.personJPanel = personJPanel;
        jsp.add(this.personJPanel);
        jsp.setDividerLocation(190);
        jsp.setOneTouchExpandable(true);

        //右边面板
        JPanel right = new JPanel(new BorderLayout());
        jsp.add(right);
        this.listModel = new DefaultListModel<Person>();
        if (pers != null) {
            for (int i = 0; i < pers.length; i++) {
                this.listModel.addElement(pers[i]);//列表框塞东西
            }
        }
        this.jList = new JList<Person>(this.listModel);
        this.jList.addListSelectionListener(this);//列表监听
        right.add(new JScrollPane(this.jList));

        JPanel cmdPanel = new JPanel();//命令面板的操作
        right.add(cmdPanel, "South");
        String[][] cmd = {{"增加项", "删除左边面板上的项", "删除选中项"}, {"查找选中项", "排列组合框"}, {"姓名", "出生日期", "省份", "城市"}};
        for (int i = 0; i < cmd.length; i++) {
            JButton button = new JButton(cmd[0][i]);
            button.addActionListener(this);
            cmdPanel.add(button);
        }
        this.comboxs = new JComboBox[cmd[1].length];
        for (int i = 0; i < cmd[1].length; i++) {
            cmdPanel.add(new Label(cmd[1][i]));
            cmdPanel.add(this.comboxs[i] = new JComboBox<>(cmd[2]));//每一个查找都可以根据姓名和生日
            this.comboxs[i].addActionListener(this);
        }

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            Person per = null;
            switch (e.getActionCommand()) {
                case "增加项":
                    //添加某一person
                    if ((per = this.personJPanel.get()) != null) {
                        this.listModel.addElement(per);
                    }
                    break;
                case "删除左边面板上的项":
                    remove(listModel, this.personJPanel.get());
                    break;
                case "删除选中项":
                    removeSelected(this.listModel, this.jList);//直接传整个参数进去，在函数内部循环用get函数
                    break;
            }
        } else if (e.getSource() instanceof JComboBox) {
            //查找和排序组合框
            jList.clearSelection();
            if (e.getSource() == this.comboxs[0]) {
                //查找
                int i = this.comboxs[0].getSelectedIndex();
                if (i < equalables.length) {
                    selectAll(this.listModel, this.jList, this.personJPanel.get(), equalables[i]);
                }
            } else if (e.getSource() == this.comboxs[1]) {
                //排序
                int i = this.comboxs[1].getSelectedIndex();
                if (i < comparators.length) {
                    sort(this.listModel, comparators[i]);
                }
            }
        }
    }

    //删除选项，函数调用
    public <T> void remove(DefaultListModel<T> listModel, T obj) {
        //确认对话框
        if (obj != null && JOptionPane.showConfirmDialog(this,
                "删除左边面板上的项" + obj.toString() + "？", "确认", JOptionPane.YES_NO_OPTION) == 0) {

            //这边能不能直接实现 能一下删除所有名字匹配的对象啊？####
            boolean remove = this.listModel.removeElement(obj);
            JOptionPane.showMessageDialog(this, remove ? "seccess" : "找不到" + obj.toString());
        }
    }

    //删除多个选项，函数调用
    public <T> void removeSelected(DefaultListModel<T> listModel, JList<? super T> jList) {
        if (this.listModel.getSize() == 0) {
            JOptionPane.showMessageDialog(this, "列表框为空");
        } else {
            int i = this.jList.getSelectedIndex();
            if (i == -1) {
                JOptionPane.showMessageDialog(this, "请选中列表框中的项");
            } else {
                String string = this.jList.getSelectedValue().toString();
                if (JOptionPane.showConfirmDialog(this, "删除第" + (i + 1) + "项？",
                        "确认", JOptionPane.YES_NO_OPTION) == 0) {
                    this.listModel.removeElementAt(i);
                }
            }
        }
    }

    public <T> void selectAll(DefaultListModel<T> listModel, JList<? super T> jList, T key, Equalable<? super T> equalable) {
        try {
            int n = listModel.getSize();//for循环的末尾吧
            for (int i = 0; i < n; i++) {
                if (equalable.equals(key, (T) listModel.getElementAt(i))) {
                    jList.addSelectionInterval(i, i);//添加选中第i项
                }
            }
        }catch (NullPointerException e){}
    }

    //排序算法（把person的复制粘贴了orz
    public <T> void sort(DefaultListModel<? super T> listModel, Comparator<? super T> comparator) {
        try {
            for (int i = 0; i < listModel.getSize() - 1; i++) {
                int min = i;
//            System.out.println("111");
                for (int j = i + 1; j < listModel.getSize(); j++) {
//                System.out.println("222");
//                System.out.println((T) listModel.getElementAt(j));
                    if (comparator.compare((T) listModel.getElementAt(j), (T) listModel.getElementAt(min)) < 0) {
//                    System.out.println("333");
                        min = j;
                    }
                }
                if (min != i) {
                    T temp = (T) listModel.getElementAt(i);
                    listModel.setElementAt((T) listModel.getElementAt(min), i);
                    listModel.setElementAt(temp, min);
                }
            }
        }catch (NullPointerException e){}
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //选中列表框的时候执行
        this.personJPanel.set(this.jList.getSelectedValue());
    }
}
