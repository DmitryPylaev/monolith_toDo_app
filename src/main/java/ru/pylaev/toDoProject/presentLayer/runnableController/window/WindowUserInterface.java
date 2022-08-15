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
    private final JTextField textField = new JTextField(72);
    private final JPanel panel = new JPanel();
    private final JFrame mainFrame;
    private String userInput;

    @Autowired
    public WindowUserInterface(View view, UiStateModel uiStateModel) {
        super(view, uiStateModel);
        mainFrame = new JFrame();
        mainFrame.setTitle("TODO");
        mainFrame.setDefaultCloseOperation((WindowConstants.DISPOSE_ON_CLOSE));
        mainFrame.setBounds(300, 300, 900, 400);
        mainFrame.setVisible(true);
        mainFrame.add(panel);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.addActionListener(e -> {
            userInput = textField.getText();
            textField.setText("");
        });
        view.setPrinter(content -> {
            panel.removeAll();
            panel.add(JScrollPaneWriter.write(content));
            panel.add(textField);
            panel.repaint();
            mainFrame.setVisible(true);
            textField.grabFocus();
        });
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
