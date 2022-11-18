package ru.pylaev.toDoProject.presentLayer.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.Controller;
import ru.pylaev.toDoProject.presentLayer.MainRespondLogic;
import ru.pylaev.util.ListToNumberingArrayConverter;

import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Controller
public class JsonController extends Controller {
    private String respond;

    @Autowired
    public JsonController(UiStateModel uiStateModel, MainRespondLogic respondLogic) {
        super(uiStateModel, respondLogic);
    }

    @PostMapping("/postJson")
    public ResponseEntity<String> post(@RequestBody JsonInput jsonInput) {
        respondLogic.accept(jsonInput.getContent(), uiStateModel);
        return prepareResponseEntity(respond);
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
        String[] arrTask = ListToNumberingArrayConverter.convert(tasks);
        var stringBuilder = new StringBuilder();
        if (arrTask.length > 0) Arrays.stream(arrTask).forEach(s -> stringBuilder.append(s).append("\n"));
        stringBuilder.append(message);
        respond = stringBuilder.toString();
    }

    private static class JsonInput {
        @Getter @Setter private String content;
    }
}
