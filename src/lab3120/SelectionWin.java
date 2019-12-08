package lab3120;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;


public class SelectionWin extends JFrame{

public static SelectionWin sWin = null;
    
    public SelectionWin(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        setBackground(Color.DARK_GRAY);
        
        sWin = this;
        this.setTitle("Selection");
        setSize(400, 200);
        
        JButton iChooseACalculator = new JButton("Калькулятор");
        JButton iChooseAColorpicker = new JButton("Color picker");
        setLayout(new GridLayout(1, 2,10,200));
        
        //iChooseACalculator.setBounds(5, 5, 150, 20);
        sWin.add(iChooseACalculator);
        
        //iChooseAColorpicker.setBounds(100, 100, 150, 20);
        sWin.add(iChooseAColorpicker);
        
        ChoiseWin choise = new ChoiseWin();
        iChooseACalculator.addActionListener(choise);
        iChooseAColorpicker.addActionListener(choise);
        
        iChooseACalculator.setActionCommand("Calculator");
        iChooseAColorpicker.setActionCommand("Colorpicker");
        
        setVisible(true);
    }
    public static SelectionWin getInstance() {
        return new SelectionWin();
    }
}
