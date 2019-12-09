package lab3120;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiseWin implements ActionListener {

    public static void main(String[] args) {

        SelectionWin sWin = SelectionWin.getInstance();
        //ColorPicker win = ColorPicker.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String command = ae.getActionCommand();
        switch (command) {
            case "Calculator":
                Calculator cal = Calculator.getCalculator();
                break;

            case "Colorpicker":
                ColorPicker cp = ColorPicker.getInstance();
                break;
        }
    }
}
