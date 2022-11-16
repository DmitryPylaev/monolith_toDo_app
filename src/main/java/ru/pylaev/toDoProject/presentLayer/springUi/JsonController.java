package ru.pylaev.toDoProject.presentLayer.springUi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.BaseController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IBaseControllerFactory;

import java.util.List;

@org.springframework.stereotype.Controller
public class JsonController extends BaseController {
    @Autowired
    public JsonController(@Qualifier("baseControllerFactory") IBaseControllerFactory factory) {
        super(factory);
    }

    @PostMapping("/postJson")
    public ResponseEntity<String> post(@RequestBody JsonInput jsonInput) {
        respondControllerLogic.getRespond(jsonInput.getContent(), uiStateModel);
        return prepareResponseEntity(viewHandler.show());
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
//        throw new UnsupportedOperationException("Контроллер JSON пока не умеет управлять представлением");
    }

    private static class JsonInput {
        @Getter @Setter private String content;
    }
}
