package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import lombok.Getter;
import ru.pylaev.toDoProject.presentLayer.runnableUI.InputGetter;

import javax.swing.*;

public class WindowInputGetter extends InputGetter {
    @Getter private String userInput;

    WindowInputGetter (JTextField textField) {
        textField.addActionListener(e -> {
            userInput = textField.getText();
            textField.setText("");
        });
    }

    @Override
    public void setNull() {
        this.userInput = null;
    }
}
