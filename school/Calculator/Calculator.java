package Calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {

    public static final int WIDTH = 500 ;
    public static final int HEIGHT = 400 ;

    private JTextField result;

    private JPanel mainPane;
    private JPanel SzPane;
    private JPanel FhPane;
    private JPanel showPane;

    private JButton[] Sz;
    private JButton[] Fh;

    public Calculator(String title){

        setTitle(title);

        result = new JTextField("0.0",22);
        result.setEditable(false);

        mainPane = new JPanel();
        SzPane = new JPanel();
        FhPane = new JPanel();
        showPane = new JPanel();

        Sz = new JButton[12];
        for(int i=0; i<9; i++)
        {
            Sz[i] = new JButton(new Integer(i+1).toString());
        }
        Sz[9] = new JButton("0");
        Sz[10] = new JButton("C");
        Sz[11] = new JButton(".");

        Fh = new JButton[8] ;
        Fh[0] = new JButton("+");
        Fh[1] = new JButton("-");
        Fh[2] = new JButton("*");
        Fh[3] = new JButton("/");
        Fh[4] = new JButton("^");
        Fh[5] = new JButton("√");
        Fh[6] = new JButton("+/-");
        Fh[7] = new JButton("=");

        SzPane.setLayout(new GridLayout(4,3,1,1));
        for(int i=0;i<12;i++) {
            SzPane.add(Sz[i]);
        }

        FhPane.setLayout(new GridLayout(4,2,1,1));
        for(int i=0; i<8; i++) {
            FhPane.add(Fh[i]);
        }

        showPane.setLayout(new BorderLayout());
        showPane.add(result, BorderLayout.NORTH);

        mainPane.setLayout(new BorderLayout());
        mainPane.add(showPane, BorderLayout.NORTH);
        mainPane.add(SzPane, BorderLayout.WEST);
        mainPane.add(FhPane, BorderLayout.EAST);

        this.add(mainPane, BorderLayout.CENTER);
        this.setSize(WIDTH, HEIGHT);

        Toolkit too = Toolkit.getDefaultToolkit();
        Dimension screenSize = too.getScreenSize();
        this.setLocation((screenSize.width-WIDTH)/2, (screenSize.height-HEIGHT)/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();

        ButtonListener button = new ButtonListener();
        for(int i = 0; i < Sz.length; i++)
            Sz[i].addActionListener(button);
        for(int i=0;i<Fh.length;i++)
            Fh[i].addActionListener(button);
    }

    class ButtonListener implements ActionListener{
        private String last;
        private String Str;
        private double num01;
        private double num02;
        private boolean first;
        private boolean fhPressed;

        public ButtonListener(){
            first = true;
            Str = "";
        }


        public void actionPerformed(ActionEvent e){
            String str = ((JButton)e.getSource()).getText().trim();
            if(Character.isDigit(str.charAt(0)))
                dofh(str);
            else
                dosz(str);
        }


        public void dosz(String fh){
            fhPressed = true;

            if(first && !isOne(fh)){
                num01 = getnum02OnDisplay();
                first = false;
            }
            if(isOne(fh)){
                doOneJS(fh);
            }
            else if(last != null){
                doTwoJS(last);
            }
            if(! isOne(fh)){
                last = fh;
            }
        }


        public boolean isOne(String s){
            return s.equals("=") || s.equals("C") || s.equals("√") || s.equals("+/-") || s.equals(".");
        }


        public void doOneJS(String fh){
            if(fh.equals("+/-")){
                num02 = cancal(getnum02OnDisplay() + "");
                result.setText("");
                result.setText(num02 + "");
                return;
            }
            else if(fh.equals(".")){
                doDecPoint();
                return;
            }
            else if(fh.equals("√")){
                try{
                    num02 = Math.sqrt(getnum02OnDisplay());
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "开根数", "警告", JOptionPane.WARNING_MESSAGE);
                }
                result.setText("");
                result.setText(num02 + "");
                return;
            }
            else if(fh.equals("=")){
                if(last!= null && !isOne(last)){
                    doTwoJS(last);
                }
                last = null;
                first = true;
                return;
            }
            else{
                clear();
            }
        }

        public void doTwoJS(String fh){
            if(fh.equals("+")){
                num01 = num01 + num02;
            }
            else if(fh.equals("-")){
                num01 = num01 - num02;
            }
            else if(fh.equals("*")){
                num01 = num01 * num02;
            }
            else if(fh.equals("/")){
                if(num02 == 0) {
                    JOptionPane.showMessageDialog(null, "除数错误", "警告", JOptionPane.WARNING_MESSAGE);
                }else{
                    num01 = num01 / num02;
                }
            }
            else if(fh.equals("^"))
                num01 = Math.pow(num01, num02);

            last = null;

            num02 = 0;
            result.setText(num01 + "");


        }

        public void dofh(String s){
            if(!fhPressed){
                Str += s;
            }
            else{
                fhPressed = false;
                Str = s;
            }

            num02 = new Double(Str).doubleValue();
            result.setText("");
            result.setText(Str);
        }

        public void doDecPoint(){
            fhPressed = false;

            if(Str.indexOf(".")<0){
                Str += ".";
            }
            result.setText("");
            result.setText(Str);
        }

        public double getnum02OnDisplay(){
            return new Double(result.getText()).doubleValue();
        }

        public double cancal(String s){
            fhPressed = false;

            if(num02 == (int)num02){
                s = s.substring(0,s.indexOf("."));
            }

            if(s.indexOf("-")<0){
                Str = "-" + s;
            }
            else{
                Str = s.substring(1);
            }
            return new Double(Str).doubleValue();
        }

        public void clear(){
            first = true;
            last = null;
            Str = "";
            num01 = 0;
            num02 = 0;
            result.setText("0");
        }
    }

    public static void main(String[] args){
        Calculator c = new Calculator("计算器");
        c.setVisible(true);
    }
}