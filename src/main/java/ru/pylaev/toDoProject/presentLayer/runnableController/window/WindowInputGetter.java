package ru.pylaev.toDoProject.presentLayer.runnableController.window;

import ru.pylaev.toDoProject.presentLayer.runnableController.InputGetter;

import javax.swing.*;

public class WindowInputGetter extends InputGetter {
    private String userInput;

    public WindowInputGetter(JTextField textField) {
        textField.addActionListener(e -> {
            userInput = textField.getText();
            textField.grabFocus();
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
