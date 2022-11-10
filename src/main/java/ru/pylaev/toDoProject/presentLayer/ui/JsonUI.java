package ru.pylaev.toDoProject.presentLayer.ui;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.abstractions.Observer;
import ru.pylaev.toDoProject.presentLayer.controllerLogic.SimpleControllerLogic;

import java.util.List;

@org.springframework.stereotype.Controller
public class JsonUI extends PlainUI implements Observer {
    @Autowired
    public JsonUI(PlainUiFactory factory) {
        super(factory);
    }

    @PostMapping("/postJson")
    public ResponseEntity<String> post(@RequestBody JsonInput jsonInput) {
        SimpleControllerLogic.getRespond(jsonInput.getContent(), uiStateModel);
        return prepareResponseEntity(view.show());
    }

    private ResponseEntity<String> prepareResponseEntity(String content) {
        try {
            return ResponseEntity.ok(content);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ToDoMain.PROPERTIES.get("networkError") + " " + e.getMessage());
        }
    }

    @Override
    public void update(String message, List<Task> tasks) {
        throw new UnsupportedOperationException("Контроллер JSON пока не умеет управлять представлением");
    }

    private static class JsonInput {
        @Getter @Setter private String content;
    }
}
