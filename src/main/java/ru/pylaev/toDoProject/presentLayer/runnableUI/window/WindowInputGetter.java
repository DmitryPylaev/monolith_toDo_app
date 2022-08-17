package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import ru.pylaev.toDoProject.presentLayer.runnableUI.InputGetter;

import javax.swing.*;

public class WindowInputGetter extends InputGetter {
    private String userInput;

    public WindowInputGetter(JTextField textField) {
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
