package ru.pylaev.toDoProject.presentLayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;
import ru.pylaev.toDoProject.presentLayer.BaseUI;
import ru.pylaev.toDoProject.presentLayer.view.JsonInput;
import ru.pylaev.toDoProject.presentLayer.view.View;

@Controller
public class JsonController extends BaseUI {

    @Autowired
    public JsonController(UiState uiState, View view) {
        super(uiState, view);
    }

    @PostMapping("/sendJson")
    public ResponseEntity<String> post(@RequestBody JsonInput jsonInput) {
        try {
            view.setTasks(UiStateService.processUserInput(jsonInput.getContent(), uiState));
            view.setMessage(uiState.getStep().toString());

            StringBuilder stringBuilder = new StringBuilder();
            for (String s : view.getTasks()) {
                stringBuilder.append(s).append("\n");
            }
            return ResponseEntity.ok(stringBuilder + view.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("networkError") + " " + e.getMessage());
        }
    }
}
