package lab3120;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class RightPanel extends JPanel{
    public RightPanel(){
        
        setBackground(Color.ORANGE);
        
        setLayout(new BorderLayout());
        
        JSlider sliderRed = new JSlider(0,255,125);
        add(sliderRed,BorderLayout.NORTH);
        sliderRed.setMajorTickSpacing(25);
        sliderRed.setPaintTicks(true);
        sliderRed.setPaintLabels(true);
        sliderRed.setName("Red");
        sliderRed.addChangeListener(Win.win);
        
        JSlider sliderGreen = new JSlider(0,255,125);
        add(sliderGreen,BorderLayout.CENTER);
        sliderGreen.setMajorTickSpacing(25);
        sliderGreen.setPaintTicks(true);
        sliderGreen.setPaintLabels(true);
        sliderGreen.setName("Green");
        sliderGreen.addChangeListener(Win.win);
        
        JSlider sliderBlue = new JSlider(0,255,125);
        add(sliderBlue,BorderLayout.SOUTH);
        sliderBlue.setMajorTickSpacing(25);
        sliderBlue.setPaintTicks(true);
        sliderBlue.setPaintLabels(true);
        sliderBlue.setName("Blue");
        sliderBlue.addChangeListener(Win.win);
        
        setToolTipText();
    }
}
