package lab3120;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import static lab3120.CalculatorWin.*;

public class Calculator {

    public Calculator() {
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

                    if (buffer[4] == "-" && buffer[0] == "") {
                        buffer[0] = buffer[4];
                    }
                    buffer[0] = (buffer[0] + button.getText());
                    label.setText(buffer[0]);
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
                    buffer[4] = button.getText();
                    label.setText(buffer[4]);
                }

                if (button.getText() != "=" && buffer[0] != "") {

                    buffer[3] = button.getText();
                    label.setText(buffer[0] + buffer[3]);

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
    }
}
