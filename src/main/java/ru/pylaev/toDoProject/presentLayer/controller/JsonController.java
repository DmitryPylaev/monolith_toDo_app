package ru.pylaev.toDoProject.presentLayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.presentLayer.BaseUI;
import ru.pylaev.toDoProject.presentLayer.view.JsonInput;
import ru.pylaev.toDoProject.presentLayer.view.View;

@Controller
public class JsonController extends BaseUI {
    @Autowired
    public JsonController(View view, UiState uiState) {
        super(view, uiState);
    }

    @PostMapping("/sendJson")
    public ResponseEntity<String> post(@RequestBody JsonInput jsonInput) {
        try {
            processingRequest(jsonInput.getContent());
            return ResponseEntity.ok(view.show());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("networkError") + " " + e.getMessage());
        }
    }
}
