package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.presentLayer.runnableUI.CustomPrinter;

import javax.swing.*;

@Component
public class WindowPrinter implements CustomPrinter {
    @Getter private final JTextField textField = new JTextField(72);
    private final JPanel panel = new JPanel();
    private final JFrame mainFrame = new JFrame();

    {
        mainFrame.setTitle(ToDoMain.PROPERTIES.get("windowTitle"));
        mainFrame.setDefaultCloseOperation((WindowConstants.DISPOSE_ON_CLOSE));
        mainFrame.setBounds(300, 300, 900, 400);
        mainFrame.setVisible(true);
        mainFrame.add(panel);
        textField.setHorizontalAlignment(JTextField.CENTER);
    }

    public void display(String content) {
        panel.removeAll();
        panel.add(JScrollPaneWriter.write(content));
        panel.add(textField);
        panel.repaint();
        mainFrame.setVisible(true);
        textField.grabFocus();
    }
}
