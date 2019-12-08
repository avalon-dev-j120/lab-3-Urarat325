package lab3120;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorPicker extends JFrame implements ChangeListener {

    public static ColorPicker win = null;
    private static ColorBox colorBox = null;
    private static RightPanel rightPanel = null;
    public static JLabel labe1 = null;
    public static int colorRed = 125;
    private static int colorGreen = 125;
    private static int colorBlue = 125;
    private static String hexCode = "7d7d7d";

    private ColorPicker() {

        win = this;
        this.setTitle("Color picker");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setLayout(new GridLayout(1, 2));
        colorBox = new ColorBox();
        rightPanel = new RightPanel();
        colorBox.setToolTipText(hexCode);
        add(colorBox);
        add(rightPanel);

        setVisible(true);
        // setResizable(false);
    }

    public static ColorPicker getInstance() {
        return new ColorPicker();
    }

    @Override
    public void stateChanged(ChangeEvent ce) {

        JSlider slider = (JSlider) ce.getSource();
        String sliderName = slider.getName();
        switch (sliderName) {
            case "Red":
                colorRed = slider.getValue();
                break;
            case "Green":
                colorGreen = slider.getValue();
                break;
            case "Blue":
                colorBlue = slider.getValue();
                break;
        }
        Color color = new Color(colorRed, colorGreen, colorBlue);
        hexCode = "#" + Integer.toHexString(colorRed) + Integer.toHexString(colorGreen) + Integer.toHexString(colorBlue);
        colorBox.setBackground(color);
        colorBox.setToolTipText(hexCode);
    }
}
