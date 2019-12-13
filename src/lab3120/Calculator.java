package lab3120;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import static lab3120.CalculatorWin.*;

public class Calculator implements ActionListener {

    private static final JLabel forLabel = CalculatorWin.getLabel();

    @Override
    public void actionPerformed(ActionEvent ae) {

        String[] buffer = new String[5];

        buffer[0] = ""; //Первое число
        buffer[1] = ""; //Второе число
        buffer[2] = ""; //Результат
        buffer[3] = ""; //Знак
        buffer[4] = ""; //Если первое число отрицательное

        String command = ae.getActionCommand();

        switch (command) {
            case ".":
                if (buffer[0] != "") {
                    buffer[0] += command;
                    forLabel.setText(buffer[0]);
                }
                break;
            case "0":
                if (buffer[0] != "0" && buffer[0] != "-0") {
                    buffer[0] += command;
                    forLabel.setText(buffer[0]);
                }
                break;

            case "CE":
                forLabel.setText("");
                buffer[0] = "";
                buffer[1] = "";
                buffer[2] = "";
                buffer[3] = "";
                buffer[4] = "";
                break;

            case "-":
                if (buffer[0] == "" && command == "-") {
                    buffer[0] = command;

                    forLabel.setText(buffer[0]);
                } else {
                    if (buffer[0] != "-" && buffer[0] != "") {
                        buffer[3] = command;
                        forLabel.setText(buffer[0] + buffer[3]);
                    }
                }
                break;

            case "=":
                if (command == "=" && buffer[0] != "" && buffer[1] != "") {

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
                    forLabel.setText(buffer[2]); //Вывод ответа
                    buffer[0] = "";
                    buffer[1] = "";
                    buffer[2] = "";
                    buffer[3] = "";
                    buffer[4] = "";
                }
                break;

            case "+":
                if (buffer[0] != "") {
                    buffer[3] = command;
                    forLabel.setText(buffer[0] + buffer[3] + buffer[1]);
                }
                break;

            case "*":
                if (buffer[0] != "") {
                    buffer[3] = command;
                    forLabel.setText(buffer[0] + buffer[3] + buffer[1]);
                }
                break;
            case "/":
                if (buffer[0] != "") {
                    buffer[3] = command;
                    forLabel.setText(buffer[0] + buffer[3] + buffer[1]);
                }
                break;
            default:
                if ("".equals(buffer[3]) && buffer[0].codePoints()
                        .filter(Character::isDigit).count() != 5) {  //Вывод первого числа

                    buffer[0] += command;
                    forLabel.setText(buffer[0]);
                }

                if (!"".equals(buffer[3]) && buffer[1].codePoints()
                        .filter(Character::isDigit).count() != 5) { //Вывод второго числа

                    buffer[1] += command;
                    forLabel.setText(buffer[0] + buffer[3] + buffer[1]);
                }
                break;
        }
    }
}
