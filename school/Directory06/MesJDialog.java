package Directory06;

import javax.swing.*;

public class MesJDialog extends JDialog {
    private JLabel jLabel;
    private JFrame jf;

    public MesJDialog(JFrame jf) {
        super(jf,"tips",true);
        this.jf = jf;
        this.setSize(420, 110);
        this.jLabel = new JLabel("", JLabel.CENTER);
        this.getContentPane().add(this.jLabel);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public void show(String str) {
        this.jLabel.setText(str);
        this.setLocation(jf.getX() + 100, jf.getY() + 100);
        this.setVisible(true);
    }
}
