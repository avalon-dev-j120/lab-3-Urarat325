package lab3120;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action implements ActionListener{

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command){
            case "north":
                Win.labe1.setText("Верхняя кнопка");
                break;
            case "south":
                Win.labe1.setText("Нижняя кнопка");
                break;
            default:
                Win.labe1.setText("=D");
        }
    }
}
