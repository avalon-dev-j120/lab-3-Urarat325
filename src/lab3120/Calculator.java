package lab3120;

import javax.swing.JFrame;

public class Calculator extends JFrame{

    public Calculator() {
        setTitle("Калькулятор");
        setSize(600, 600);
        
        setVisible(true);

    }
    public static Calculator getCalculator(){
        return new Calculator();
    }
}
