package ru.pylaev.toDoProject.businessLogicLayer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import ru.pylaev.toDoProject.dataAccessLayer.DAO;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.SimpleControllerLogic;
import ru.pylaev.toDoProject.presentLayer.view.View;
import ru.pylaev.util.HeadlessSpringBootContextLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(loader = HeadlessSpringBootContextLoader.class)
class UiStateModelServiceTest {
    @MockBean
    private DAO tasksDAO;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    SimpleControllerLogic controllerLogic;

    List<Task> tasks = new ArrayList<>();

    @BeforeEach
    void setUp() {
        var task1 = new Task(3, "user", "помидоры (tomatoes)", "Wed Mar 25 16:01", "WAIT");
        var task2 = new Task(11, "user", "гречка (buckwheat)", "Wed Mar 24 16:01", "WAIT");
        var task3 = new Task(14, "user", "картошка (potatoes)", "Thu Mar 23 16:01", "DONE");

        tasks.clear();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        Mockito.when(tasksDAO.findByOwner("user")).thenReturn(tasks);
        Mockito.when(tasksDAO.findById(3L)).thenReturn(Optional.of(task1));
        Mockito.when(tasksDAO.findById(11L)).thenReturn(Optional.of(task2));
        Mockito.when(tasksDAO.findById(14L)).thenReturn(Optional.of(task3));
    }


    @Test
    void processOwnerIsOk () {
        var uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        var actualView = new View();
        uiStateModel.addObserver(actualView);

        String expectedMessage = LogicStep.ASK_NUMBER.toString();
        var expectedView = new View();
        expectedView.update(expectedMessage, tasks);

        controllerLogic.processUserInput("user", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processOwnerInvalidSymbol () {
        var uiStateModel = new UiStateModel();
        var expectedUiStateModel = new UiStateModel();
        controllerLogic.processUserInput( "???", uiStateModel);
        Assertions.assertEquals(expectedUiStateModel, uiStateModel);
    }

    @Test
    void processOwnerNull () {
        var uiStateModel = new UiStateModel();
        var expectedUiStateModel = new UiStateModel();
        controllerLogic.processUserInput( null, uiStateModel);
        Assertions.assertEquals(expectedUiStateModel, uiStateModel);
    }

    @Test
    void processAskNumberOk () {
        var uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        var actualView = new View();
        uiStateModel.addObserver(actualView);

        String expectedMessage = LogicStep.ASK_STATUS.toString();
        var expectedView = new View();
        expectedView.update(expectedMessage, tasks);

        controllerLogic.processUserInput( "1", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processAskNumberOutRange () {
        var uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        var actualView = new View();
        uiStateModel.addObserver(actualView);

        String expectedMessage = LogicStep.ASK_NUMBER.toString();
        var expectedView = new View();
        expectedView.update(expectedMessage, tasks);

        controllerLogic.processUserInput( "10", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processAskNumberNull () {
        var uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        var actualView = new View();
        uiStateModel.addObserver(actualView);

        String expectedMessage = LogicStep.ASK_NUMBER.toString();
        var expectedView = new View();
        expectedView.update(expectedMessage, new ArrayList<>());

        controllerLogic.processUserInput( null, uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processAskNewOk () {
        var uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        uiStateModel.setLogicStep(LogicStep.ASK_NEW);
        var actualView = new View();
        uiStateModel.addObserver(actualView);

        var task = new Task(33, "user", "печень и икра минтая (pollock liver and caviar)", "Wed Mar 25 16:01", "WAIT");
        tasks.add(task);
        String expectedMessage = LogicStep.ASK_NUMBER.toString();
        var expectedView = new View();
        expectedView.update(expectedMessage, tasks);

        controllerLogic.processUserInput( "печень и икра минтая (pollock liver and caviar)", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processAskStatusDone () {
        var uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        uiStateModel.setCurrentTaskIndex(1);
        uiStateModel.setLogicStep(LogicStep.ASK_STATUS);
        var actualView = new View();
        uiStateModel.addObserver(actualView);

        var expectList = new ArrayList<>(tasks);
        expectList.set(0, new Task(3, "user", "помидоры (tomatoes)", "Wed Mar 25 16:01", "DONE"));
        String expectedMessage = LogicStep.ASK_NUMBER.toString();
        var expectedView = new View();
        expectedView.update(expectedMessage, expectList);

        controllerLogic.processUserInput( "DONE", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processAskStatusArch () {
        var uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        uiStateModel.setCurrentTaskIndex(3);
        uiStateModel.setLogicStep(LogicStep.ASK_STATUS);
        var actualView = new View();
        uiStateModel.addObserver(actualView);

        var expectList = new ArrayList<>(tasks);
        expectList.remove(2);
        String expectedMessage = LogicStep.ASK_NUMBER.toString();
        var expectedView = new View();
        expectedView.update(expectedMessage, expectList);

        controllerLogic.processUserInput("ARCH", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processAskStatusInvalid () {
        var uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        var actualView = new View();
        uiStateModel.addObserver(actualView);

        String expectedMessage = LogicStep.ASK_NUMBER.toString();
        var expectedView = new View();
        expectedView.update(expectedMessage, tasks);

        controllerLogic.processUserInput( "arc", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }
}