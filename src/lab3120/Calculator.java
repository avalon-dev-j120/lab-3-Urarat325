package lab3120;

import javax.swing.BorderFactory;
import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame{

    public Calculator() {
        setTitle("Калькулятор");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(Color.DARK_GRAY);
        setVisible(true);
        setMaximumSize(new Dimension(600, 600));
        
    }
    
    
    public static Calculator getCalculator(){
        return new Calculator();
    }
}
