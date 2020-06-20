package EditorFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//首先，是要继承JFRame，否则无法setDEfault
public class EditorFrame extends JFrame implements ActionListener, MouseListener {
    private JComboBox<String> comboBox_char;//字体
    protected JComboBox<Integer> comboBox_size;//字大小
    private JCheckBox[] checkbox;//字形（斜体/
    private JRadioButton[] radios;//颜色单选
    private Color[] colors = {Color.red, Color.green, Color.blue};
    private String[] colorsname = {"red", "green", "blue"};
    protected JTextArea text;
    protected JPopupMenu popupMenus;//快捷菜单
    protected JMenu[] menus;//菜单数组
    private JCheckBoxMenuItem[] cbmenuitem;//复选菜单项数组
    protected JToolBar toolBar;//工具栏


    public EditorFrame() {
        super("文本编辑器");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //添加工具栏
        this.toolBar = new JToolBar();
        this.getContentPane().add(this.toolBar, "North");

        // 获取运行时刻的图形环境
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontsName = ge.getAvailableFontFamilyNames();
        this.comboBox_char = new JComboBox<String>(fontsName);
        this.comboBox_char.addActionListener(this);
        this.toolBar.add(comboBox_char);

        Integer[] sizes = {10, 20, 30, 40};
        this.comboBox_size = new JComboBox<>(sizes);
        this.comboBox_size.addActionListener(this);
        this.toolBar.add(comboBox_size);

        //加字体
        String[] str = {"斜体", "粗体"};
        this.checkbox = new JCheckBox[str.length];
        for (int i = 0; i < str.length; i++) {
            this.toolBar.add(this.checkbox[i] = new JCheckBox(str[i]));
            this.checkbox[i].addActionListener(this);
        }

        //工具栏加按钮，颜色
        ButtonGroup bg = new ButtonGroup();
        this.radios = new JRadioButton[colors.length];
        for (int i = 0; i < colors.length; i++) {
            this.radios[i] = new JRadioButton(colorsname[i]);
            this.radios[i].setForeground(colors[i]);
            this.radios[i].addActionListener(this);
            bg.add(this.radios[i]);
            this.toolBar.add(this.radios[i]);
        }
        this.radios[0].setSelected(true);

        //打开和保存按钮,图片就先不实现了，路径加一个就行了
        JButton bopen = new JButton("打开");
        bopen.addActionListener(this);
        this.toolBar.add(bopen);

        JButton bsave = new JButton("保存");
        bsave.addActionListener(this);
        this.toolBar.add(bsave);

        //在文本区添加字
        this.text = new JTextArea("Hello World");
        this.text.addMouseListener(this);
        this.getContentPane().add(new JScrollPane(this.text));//滚动窗格
        this.text.setForeground(colors[0]);
        //这里去改一个设置字体大小的bug

        this.addMenu();//添加菜单
        this.setVisible(true);
    }

    private void addMenu() {
//        创建窗口，添加到框架
        String[] menustr = {"文件", "编辑", "插入", "格式", "工具", "窗口", "帮助"};
        String[][] menuitem = {{"新建", "打开", "保存", "另存为", "|", "退出"},
                {"撤销", "恢复", "|", "剪切", "复制", "粘贴", "|", "查找", "替换"}, {"日期", "文本"}, {"字体"}, {"test"}, {"tessst"}, {"tesst"}};

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);//框架上加菜单栏
        this.menus = new JMenu[menustr.length];
        JMenuItem[][] jMenuItems = new JMenuItem[menuitem.length][];//菜单项二维数组

        for (int i = 0; i < menuitem.length; i++) {
            this.menus[i] = new JMenu(menustr[i]);
            menuBar.add(menus[i]);//菜单栏加菜单
            jMenuItems[i] = new JMenuItem[menuitem[i].length];


            for (int j = 0; j < menuitem[i].length; j++) {
                if (menuitem[i][j].equals("|")) {
                    this.menus[i].addSeparator();//加分割线
                } else {
                    //加二级菜单
                    jMenuItems[i][j] = new JMenuItem(menuitem[i][j]);
                    this.menus[i].add(jMenuItems[i][j]);
                    jMenuItems[i][j].addActionListener(this);
                }
            }

        }

        //设置菜单项图标（没图片可以不设置
//            jMenuItems[0][1].setIcon(new ImageIcon("xxx.png"));

//            二级菜单，可以继续选择
        JMenu menu_style = new JMenu("字形");
        menus[3].add(menu_style);
        String[] stylestr = {"粗体", "斜体"};
        this.cbmenuitem = new JCheckBoxMenuItem[stylestr.length];

        //往里面扔粗体和斜体
        for (int i = 0; i < stylestr.length; i++) {
            this.cbmenuitem[i] = new JCheckBoxMenuItem(stylestr[i]);
            menu_style.add(cbmenuitem[i]);
            cbmenuitem[i].addActionListener(this);
        }

        JMenu menu_color = new JMenu("颜色");
        menus[3].add(menu_color);
        ButtonGroup bottong = new ButtonGroup();//这里不太一样
        for (int i = 0; i < this.colorsname.length; i++) {
            JRadioButtonMenuItem rbmi = new JRadioButtonMenuItem(this.colorsname[i]);
            bottong.add(rbmi);//按钮组添加菜单选项
            menu_color.add(rbmi);
            rbmi.setForeground(this.colors[i]);
            rbmi.addActionListener(this);
        }

        //接下来是快捷菜单，右键的
        this.popupMenus = new JPopupMenu();
        String[] menuitem_cut = {"剪切", "复制", "粘贴"};
        JMenuItem[] popmenuitem = new JMenuItem[menuitem.length];//里面的选项
        for (int i = 0; i < menuitem_cut.length; i++) {
            popmenuitem[i] = new JMenuItem(menuitem_cut[i]);
            this.popupMenus.add(popmenuitem[i]);
            popmenuitem[i].addActionListener(this);
        }
        //快捷键
        popmenuitem[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        this.text.add(this.popupMenus);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //color单选按钮
        if (e.getSource() instanceof JRadioButton) {
            this.text.setForeground(((JRadioButton) e.getSource()).getForeground());
        } else if (e.getSource() instanceof JMenuItem) {
            switch (e.getActionCommand()) {
                case "退出":
                    //按下yes就退出
                    if (JOptionPane.showConfirmDialog(this,
                            "终止当前程序？", "yes", JOptionPane.YES_NO_OPTION) == 0) {
                        System.exit(0);
                    }
                case "剪切":
                    this.text.cut();
                    break;
                case "复制":
                    this.text.copy();
                    break;
                case "粘贴":
                    this.text.paste();
                    break;
            }
        }
        //都是改变字号字体的，放在同一个里面
        else if (e.getSource() instanceof JRadioButton || e.getSource() instanceof JCheckBox) {
            int size = 0;
            String fontname = (String) this.comboBox_char.getSelectedItem();
            Object obj = this.comboBox_size.getSelectedItem();//组合框选中项或者输入值

            if (obj != null) {
                try {
                    if (obj instanceof Integer) {
                        size = ((Integer) obj).intValue();
                    } else if (obj instanceof String) {
                        size = Integer.parseInt((String) obj);
                    }
                    if (size < 20 || size > 200) {
                        throw new Exception(size + "超出范围");
                    }
                    Font f = this.text.getFont();
                    int style = f.getStyle();
                    switch (e.getActionCommand()) {
                        case "粗体":
                            style ^= 1;
                            break;
                        case "斜体":
                            style ^= 2;
                    }

                    this.text.setFont(new Font(fontname, style, size));
                    insert(this.comboBox_size, size);

                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(this, e1.getMessage() + "转化成整数");
                } catch (Exception e1) {
                    JOptionPane.showConfirmDialog(this, e1.toString());
                }
            }
        }

    }

    public <T extends Comparable<? super T>> void insert(JComboBox<T> comboBox, T x) {
//二分法排序
        int begin = 0, end = comboBox.getItemCount() - 1, mid = end;
        while (begin < end) {
            mid = (begin + end) / 2;
            if (x.compareTo(comboBox.getItemAt(mid)) == 0) {
                return;
            } else if (x.compareTo(comboBox.getItemAt(mid)) < 0) {
                end = mid - 1;
            } else if (x.compareTo(comboBox.getItemAt(mid)) > 0) {
                begin = mid + 1;
            }
        }
        comboBox.insertItemAt(x, begin);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 3) {
            this.popupMenus.show(this.text, e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
