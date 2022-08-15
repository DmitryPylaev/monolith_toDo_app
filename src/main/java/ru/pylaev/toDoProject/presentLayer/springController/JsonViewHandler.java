package ru.pylaev.toDoProject.presentLayer.springController;

import org.springframework.http.ResponseEntity;
import ru.pylaev.toDoProject.ToDoMain;

public class JsonViewHandler {
    public static ResponseEntity<String> prepareResponseEntity(String content) {
        try {
           return ResponseEntity.ok(content);
        } catch (Exception e) {
           return ResponseEntity.badRequest().body(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("networkError") + " " + e.getMessage());
        }
    }
}
