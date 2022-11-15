package ru.pylaev.toDoProject.presentLayer.window;

import lombok.Getter;
import ru.pylaev.toDoProject.presentLayer.BaseInputGetter;

import javax.swing.*;

public class WindowInputGetter extends BaseInputGetter {
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
