package ru.pylaev.toDoProject.presentLayer.runnableUi.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.presentLayer.runnableUi.BaseRunnableUI;
import ru.pylaev.toDoProject.presentLayer.runnableUi.CustomPrinter;
import ru.pylaev.toDoProject.presentLayer.view.View;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

@Component
public class WindowUserInterface extends BaseRunnableUI {
    private final JTextField textField = new JTextField(72);
    private final JPanel panel = new JPanel();
    private final JFrame mainFrame;
    private String input;

    @Autowired
    public WindowUserInterface(UiState uiState, View view) {
        super(uiState, view);
        mainFrame = new JFrame();
        mainFrame.setTitle("TODO");
        mainFrame.setDefaultCloseOperation((WindowConstants.DISPOSE_ON_CLOSE));
        mainFrame.setBounds(300, 300, 900, 400);
        mainFrame.setVisible(true);
        mainFrame.add(panel);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.addActionListener(e -> {
            input = textField.getText();
            textField.setText("");
        });
        printer = new WindowPrinter();
    }

    @Override
    public String getInput() {
        input = null;
        try {
            while (input == null) TimeUnit.MILLISECONDS.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input;
    }

    private class WindowPrinter implements CustomPrinter {
        @Override
        public void display(String s) {
            panel.removeAll();
            panel.add(JScrollPaneWriter.write(s));
            panel.add(textField);
            panel.repaint();
            mainFrame.setVisible(true);
            textField.grabFocus();
        }
    }
}
