package lab3120;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Calculator extends JFrame {

    public Calculator() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Калькулятор");
        setSize(600, 600);
        setVisible(true);
        setLocationByPlatform(true);

        this.setMaximumSize(new Dimension(800, 800));
        this.setMinimumSize(new Dimension(400, 400));
        
        
        
        
    }

    public static Calculator getCalculator() {
        return new Calculator();
    }
}
