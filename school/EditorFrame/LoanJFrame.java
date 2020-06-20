package EditorFrame;

import StudentManageSystem.MyDate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class LoanJFrame extends JFrame implements ActionListener {

    private JSpinner spin_year, spin_month;//微调文本行，起始年月
    private JTextField[] texts;
    private MyDate payday;//还款日期
    private JButton botton;//计算按钮
    private DefaultTableModel tableModel;//表格模型

    public LoanJFrame() {
        super("银行贷款");
        this.setBounds(300, 240, 800, 360);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel cmdjp = new JPanel();
        this.getContentPane().add(cmdjp, "North");

        String[] str = {"还款金额", "贷款利率", "%月   贷款年限", "年    还款起始", "年", "月"};
        String[] str_text = {"1000", "0.5025", "1"};
        this.texts = new JTextField[str.length];
        for (int i = 0; i < str_text.length; i++) {
            cmdjp.add(new JLabel(str[i]));
            cmdjp.add(this.texts[i] = new JTextField(str_text[i]));
//            this.texts[i].addActionListener(this);
//            this.texts[i] = new JTextField(str[i]);
        }
        for (int i = str_text.length; i < str.length; i++) {
            cmdjp.add(new JLabel(str[i]));
        }

        //获取系统当前时间
        Calendar start = Calendar.getInstance();
        int year = start.get(Calendar.YEAR);
        int month = start.get(Calendar.MONTH) + 1;
        month = month % 12 + 1;//下个月（防止数据溢出
        if (month == 1) {
            year++;
        }
        int day = MyDate.dayOfMonth(year, month);
        this.payday = new MyDate(year, month, day);

        //年份数值序列，初值为当前，范围是之后的2年，步长为1
        this.spin_year = new JSpinner(new SpinnerNumberModel(year, year, year + 2, 1));
        cmdjp.add(this.spin_year, 7);
        //月份
        this.spin_month = new JSpinner(new SpinnerNumberModel(month, 1, 12, 1));
        cmdjp.add(this.spin_month, 9);

        cmdjp.add(this.botton = new JButton("计算"));
        this.botton.addActionListener(this);

        //框架内部添加表格
        String[] titles = {"还款日期", "本金", "月还本金", "月还利息", "月还本息"};
        this.tableModel = new DefaultTableModel(titles, 1);//列标题，一行
        JTable jtable = new JTable(this.tableModel);//创建表格
        this.getContentPane().add(new JScrollPane(jtable));

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            double leavings = Double.parseDouble("" + texts[0].getText());
            double rate = Double.parseDouble("" + texts[1].getText());
            int months = Integer.parseInt(texts[2].getText()) * 12;
            double pay = leavings / months;
            this.tableModel.setRowCount(months);

            //还款起始日期
            int year = (Integer) this.spin_year.getValue();//还款起始年份（微调文本行）
            int month = (Integer) this.spin_month.getValue();

            MyDate md = new MyDate(year, month, MyDate.dayOfMonth(year, month));//还款日期，每个月最后一天
            if (md.compareTo(this.payday) < 0) {
                JOptionPane.showMessageDialog(this, "还款日期为" + md.toString() + "月份错误");
                return;
            }
            for (int row = 0; row < months; row++) {
                this.tableModel.setValueAt(md.toString(), row, 0);
                this.tableModel.setValueAt(leavings, row, 1);
                this.tableModel.setValueAt(pay,row,2);
                this.tableModel.setValueAt(leavings*rate*0.01,row,3);
                this.tableModel.setValueAt(pay+leavings*rate*0.01,row,4);
                month = month%12+1;
                if (month ==1){
                    year++;
                }

                md = new MyDate(year,month,MyDate.dayOfMonth(year,month));
                leavings-=pay;
            }
        }
    }
}
