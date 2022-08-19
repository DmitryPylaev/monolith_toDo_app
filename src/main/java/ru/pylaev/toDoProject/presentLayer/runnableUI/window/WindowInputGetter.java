package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.runnableUI.InputGetter;

import javax.swing.*;

@Component
public class WindowInputGetter extends InputGetter {
    private String userInput;

    public void setTextField(JTextField textField) {
        textField.addActionListener(e -> {
            userInput = textField.getText();
            textField.setText("");
        });
    }

    @Override
    public String get() {
        return userInput;
    }

    @Override
    public void setNull() {
        this.userInput = null;
    }
}
