package ru.pylaev.toDoProject.presentLayer.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.MainControllerLogic;
import ru.pylaev.toDoProject.presentLayer.UI;
import ru.pylaev.toDoProject.presentLayer.view.JsonInput;
import ru.pylaev.toDoProject.presentLayer.view.View;

@org.springframework.stereotype.Controller
public class JsonUI extends UI {
    private final MainControllerLogic controllerLogic;

    @Autowired
    public JsonUI(View view, UiStateModel uiStateModel) {
        super(view, uiStateModel);
        controllerLogic = new MainControllerLogic();
    }

    @PostMapping("/postJson")
    public ResponseEntity<String> post(@RequestBody JsonInput jsonInput) {
        controllerLogic.processUserInput(jsonInput.getContent(), uiStateModel);
        return prepareResponseEntity(view.show());
    }

    private ResponseEntity<String> prepareResponseEntity(String content) {
        try {
            return ResponseEntity.ok(content);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("networkError") + " " + e.getMessage());
        }
    }
}
