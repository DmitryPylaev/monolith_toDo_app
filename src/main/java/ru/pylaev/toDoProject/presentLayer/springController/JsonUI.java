package ru.pylaev.toDoProject.presentLayer.springController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.SimpleControllerLogic;
import ru.pylaev.toDoProject.presentLayer.UI;
import ru.pylaev.toDoProject.presentLayer.view.JsonInput;
import ru.pylaev.toDoProject.presentLayer.view.View;

@org.springframework.stereotype.Controller
public class JsonUI extends UI {
    private final SimpleControllerLogic controllerLogic;

    @Autowired
    public JsonUI(View view, UiStateModel uiStateModel) {
        super(view, uiStateModel);
        controllerLogic = new SimpleControllerLogic();
    }

    @PostMapping("/postJson")
    public ResponseEntity<String> post(@RequestBody JsonInput jsonInput) {
        controllerLogic.processUserInput(jsonInput.getContent(), uiStateModel);
        return JsonViewHandler.prepareResponseEntity(view.show());
    }
}
