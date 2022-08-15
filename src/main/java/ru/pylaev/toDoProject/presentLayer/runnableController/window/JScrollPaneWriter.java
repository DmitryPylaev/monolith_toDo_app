package ru.pylaev.toDoProject.presentLayer.runnableController.window;

import javax.swing.*;
import java.util.List;

public class JScrollPaneWriter {
    public static JScrollPane write (String content) {
        DefaultListModel<String> dlm = new DefaultListModel<>();
        dlm.addAll(List.of(content.split("\n")));
        JList<String> jList = new JList<>(dlm);
        jList.setFixedCellWidth(790);
        return new JScrollPane(jList);
    }
}
