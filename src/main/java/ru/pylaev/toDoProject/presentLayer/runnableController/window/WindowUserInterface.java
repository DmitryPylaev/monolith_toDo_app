package ru.pylaev.toDoProject.presentLayer.runnableController.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.runnableController.RunnableController;
import ru.pylaev.toDoProject.presentLayer.view.View;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

@Component
public class WindowUserInterface extends RunnableController {
    private String userInput;

    @Autowired
    public WindowUserInterface(View view, UiStateModel uiStateModel) {
        super(view, uiStateModel);
        WindowPrinter windowPrinter = new WindowPrinter();
        JTextField textField = windowPrinter.getTextField();
        textField.addActionListener(e -> {
            userInput = textField.getText();
            textField.grabFocus();
            textField.setText("");
        });
        view.setPrinter(windowPrinter);
    }

    @Override
    public String getInput() {
        userInput = null;
        try {
            while (userInput == null) TimeUnit.MILLISECONDS.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userInput;
    }
}
