package ru.pylaev.toDoProject.presentLayer.ui;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.controllerLogic.SimpleControllerLogic;
import ru.pylaev.toDoProject.presentLayer.View;

@org.springframework.stereotype.Controller
public class JsonUI extends BaseUI {
    private final SimpleControllerLogic controllerLogic;

    @Autowired
    public JsonUI(View view, UiStateModel uiStateModel, SimpleControllerLogic controllerLogic) {
        super(view, uiStateModel);
        this.controllerLogic = controllerLogic;
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
            return ResponseEntity.badRequest().body(ToDoMain.PROPERTIES.get("networkError") + " " + e.getMessage());
        }
    }

    private static class JsonInput {
        @Getter @Setter private String content;
    }
}
