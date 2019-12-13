package lab3120;

import static java.awt.BorderLayout.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorWin extends JFrame {

    public static CalculatorWin calcWin = null;

    final private JButton but1;
    final private JButton but2;
    final private JButton but3;
    final private JButton but4;
    final private JButton but5;
    final private JButton but6;
    final private JButton but7;
    final private JButton but8;
    final private JButton but9;
    final private JButton but0;
    final private JButton butEquils;
    final private JButton butCE;
    final private JButton butPoint;
    final private JButton butPlus;
    final private JButton butMinus;
    final private JButton butMult;
    final private JButton butDev;

    public static JLabel label;

    public CalculatorWin() {

        this.butDev = new JButton("/");
        this.butMult = new JButton("*");
        this.butMinus = new JButton("-");
        this.butPlus = new JButton("+");
        this.butPoint = new JButton(".");
        this.butCE = new JButton("CE");
        this.butEquils = new JButton("=");
        this.but0 = new JButton("0");
        this.but9 = new JButton("9");
        this.but8 = new JButton("8");
        this.but7 = new JButton("7");
        this.but6 = new JButton("6");
        this.but5 = new JButton("5");
        this.but4 = new JButton("4");
        this.but3 = new JButton("3");
        this.but2 = new JButton("2");
        this.but1 = new JButton("1");

        calcWin = this;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Калькулятор");
        setSize(600, 800);
        setLayout(null);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 30);

        LayoutManager layout = new BorderLayout(50, 50);
        setLayout(layout);

        this.setMaximumSize(new Dimension(1000, 1200));
        this.setMinimumSize(new Dimension(250, 400));

        JPanel panelUp = new JPanel();
        JPanel panelCen = new JPanel();
        JPanel panelDown = new JPanel();

        calcWin.add(panelUp, NORTH);
        calcWin.add(panelCen, CENTER);
        calcWin.add(panelDown, SOUTH);

        panelUp.setPreferredSize(new Dimension(300, 100));
        panelUp.setBackground(Color.WHITE);

        label = new JLabel("");
        label.setFont(BigFontTR);
        label.setPreferredSize(new Dimension(500, 100));
        label.setHorizontalAlignment(JLabel.RIGHT);
        panelUp.add(label);

        panelCen.setLayout(new GridLayout(4, 4, 10, 10));

        panelCen.add(but7);
        panelCen.add(but8);
        panelCen.add(but9);
        panelCen.add(butPlus);

        panelCen.add(but4);
        panelCen.add(but5);
        panelCen.add(but6);
        panelCen.add(butMinus);

        panelCen.add(but1);
        panelCen.add(but2);
        panelCen.add(but3);
        panelCen.add(butMult);

        panelCen.add(butCE);
        panelCen.add(but0);
        panelCen.add(butPoint);
        panelCen.add(butDev);

        panelDown.setLayout(new GridLayout(1, 1, 10, 10));

        panelDown.add(butEquils);

        String[] buffer = new String[5];

        buffer[0] = ""; //Первое число
        buffer[1] = ""; //Второе число
        buffer[2] = ""; //Результат
        buffer[3] = ""; //Знак
        buffer[4] = ""; //Если первое число отрицательное

        MouseListener butMouseListener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {

                JButton button = (JButton) me.getComponent();

                if ("".equals(buffer[3]) && buffer[0].codePoints()
                        .filter(Character::isDigit).count() != 5) {  //Вывод первого числа

                    switch (button.getText()) {

                        case ".":
                            if (buffer[0] != "") {
                                buffer[0] += button.getText();
                                label.setText(buffer[0]);
                            }
                            break;

                        case "0":
                            if (buffer[0] != "0" && buffer[0] != "-0") {
                                buffer[0] += button.getText();
                                label.setText(buffer[0]);
                            }
                            break;
                        default:
                            buffer[0] += button.getText();
                            label.setText(buffer[0]);
                            break;
                    }
//                    if (buffer[4] == "-" && buffer[0] == "") {
//                        buffer[0] = buffer[4];
//                    }
//                    if (button.getText() == "." && buffer[0] == "") {
//                        
//                    }
//                    if (button.getText() == "0" && buffer[0] == "0"){
//                        
//                    }
//                    buffer[0] = (buffer[0] + button.getText());
//                    label.setText(buffer[0]);
                }

                if (!"".equals(buffer[3]) && buffer[1].codePoints()
                        .filter(Character::isDigit).count() != 5) { //Вывод второго числа

                    buffer[1] += button.getText();
                    label.setText(buffer[0] + buffer[3] + buffer[1]);
                }
            }
        };

        MouseListener butCEMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                label.setText("");
                buffer[0] = "";
                buffer[1] = "";
                buffer[2] = "";
                buffer[3] = "";
                buffer[4] = "";
            }
        };

        MouseListener butSingsMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                JButton button = (JButton) me.getComponent();

                if (buffer[0] == "" && button.getText() == "-") {
                    buffer[0] = button.getText();

                    label.setText(buffer[0]);
                } else {
                    if (buffer[0] != "-" && button.getText() != "=" && buffer[0] != "") {
                        buffer[3] = button.getText();
                        label.setText(buffer[0] + buffer[3]);
                    }
                }

                if (button.getText() == "=" && buffer[0] != "" && buffer[1] != "") {

                    double a = Double.parseDouble(buffer[0]);
                    double b = Double.parseDouble(buffer[1]);

                    switch (buffer[3]) {
                        case ("+"):
                            buffer[2] = String.valueOf(a + b);
                            break;
                        case ("-"):
                            buffer[2] = String.valueOf(a - b);
                            break;
                        case ("*"):
                            buffer[2] = String.valueOf(a * b);
                            break;
                        case ("/"):
                            buffer[2] = String.valueOf(a / b);
                            break;
                    }
                    label.setText(buffer[2]); //Вывод ответа
                    buffer[0] = "";
                    buffer[1] = "";
                    buffer[2] = "";
                    buffer[3] = "";
                    buffer[4] = "";
                }
            }
        };
        setVisible(true);


        but1.addMouseListener(butMouseListener);
        but2.addMouseListener(butMouseListener);
        but3.addMouseListener(butMouseListener);
        but4.addMouseListener(butMouseListener);
        but5.addMouseListener(butMouseListener);
        but6.addMouseListener(butMouseListener);
        but7.addMouseListener(butMouseListener);
        but8.addMouseListener(butMouseListener);
        but9.addMouseListener(butMouseListener);
        but0.addMouseListener(butMouseListener);
        butPoint.addMouseListener(butMouseListener);

        butCE.addMouseListener(butCEMouseListener);

        butPlus.addMouseListener(butSingsMouseListener);
        butMinus.addMouseListener(butSingsMouseListener);
        butDev.addMouseListener(butSingsMouseListener);
        butMult.addMouseListener(butSingsMouseListener);
        butEquils.addMouseListener(butSingsMouseListener);
    }

    public static CalculatorWin getCalculator() {
        return new CalculatorWin();
    }
}
