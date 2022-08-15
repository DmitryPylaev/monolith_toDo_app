package ru.pylaev.toDoProject.presentLayer.runnableController.window;

import ru.pylaev.toDoProject.presentLayer.CustomPrinter;
import javax.swing.*;

class WindowPrinter implements CustomPrinter {
    private final JTextField textField = new JTextField(72);
    private final JPanel panel = new JPanel();
    private final JFrame mainFrame;

    public WindowPrinter() {
        mainFrame = new JFrame();
        mainFrame.setTitle("TODO");
        mainFrame.setDefaultCloseOperation((WindowConstants.DISPOSE_ON_CLOSE));
        mainFrame.setBounds(300, 300, 900, 400);
        mainFrame.setVisible(true);
        mainFrame.add(panel);
        textField.setHorizontalAlignment(JTextField.CENTER);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void display(String content) {
        panel.removeAll();
        panel.add(JScrollPaneWriter.write(content));
        panel.add(textField);
        panel.repaint();
        mainFrame.setVisible(true);
    }
}
