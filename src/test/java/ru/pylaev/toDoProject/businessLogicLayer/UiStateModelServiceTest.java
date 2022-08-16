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
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.dataAccessLayer.DAO;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.view.View;
import ru.pylaev.util.HeadlessSpringBootContextLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(loader = HeadlessSpringBootContextLoader.class)
class UiStateModelServiceTest {
    @MockBean
    private DAO tasksDAO;

    @Autowired
    TaskRepository taskRepository;

    List<Task> tasks = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Task task1 = new Task("3", "user", "note3", "Wed Mar 25 16:01", "WAIT");
        Task task2 = new Task("11", "user", "note1", "Wed Mar 24 16:01", "WAIT");
        Task task3 = new Task("14", "user", "note2", "Thu Mar 23 16:01", "DONE");

        tasks.clear();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        Mockito.when(tasksDAO.findByOwner("user")).thenReturn(tasks);
        Mockito.when(tasksDAO.findById(3L)).thenReturn(Optional.of(task1));
        Mockito.when(tasksDAO.findById(11L)).thenReturn(Optional.of(task2));
        Mockito.when(tasksDAO.findById(14L)).thenReturn(Optional.of(task3));
    }

//    @Test
//    void getCurrentIndexIsOk() {
//        assertEquals(validateIndex("3", tasks.size()), 3);
//    }
//
//    @Test
//    void getCurrentIndexIsNull() {
//        assertEquals(validateIndex("2", 0), 0);
//    }
//
//    @Test
//    void getCurrentIndexIsRejected() {
//        assertEquals(validateIndex("4", tasks.size()), -1);
//    }

    @Test
    void processOwnerIsOk () {
        UiStateModel uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        View actualView = new View();
        uiStateModel.addObserver(actualView);

        String[] expectedTasks = tasks.stream().map(Task::toString).toArray(String[]::new);
        IntStream.range(0, expectedTasks.length).forEach(i -> expectedTasks[i] = i + 1 + " " + expectedTasks[i]);
        String expectedMessage = ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askNumber");
        View expectedView = new View();
        expectedView.update(expectedMessage, expectedTasks);

        UiStateService.processUserInput("user", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processOwnerInvalidSymbol () {
        UiStateModel uiStateModel = new UiStateModel();

        UiStateModel expectedUiStateModel = new UiStateModel();

        UiStateService.processUserInput( "???", uiStateModel);

        Assertions.assertEquals(expectedUiStateModel, uiStateModel);
    }

    @Test
    void processOwnerNull () {
        UiStateModel uiStateModel = new UiStateModel();

        UiStateModel expectedUiStateModel = new UiStateModel();

        UiStateService.processUserInput( null, uiStateModel);

        Assertions.assertEquals(expectedUiStateModel, uiStateModel);
    }

    @Test
    void processAskNumberOk () {
        UiStateModel uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        View actualView = new View();
        uiStateModel.addObserver(actualView);

        String[] expectedTasks = tasks.stream().map(Task::toString).toArray(String[]::new);
        IntStream.range(0, expectedTasks.length).forEach(i -> expectedTasks[i] = i + 1 + " " + expectedTasks[i]);
        String expectedMessage = ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askStatus");
        View expectedView = new View();
        expectedView.update(expectedMessage, expectedTasks);

        UiStateService.processUserInput( "1", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processAskNumberOutRange () {
        UiStateModel uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        View actualView = new View();
        uiStateModel.addObserver(actualView);

        String[] expectedTasks = tasks.stream().map(Task::toString).toArray(String[]::new);
        IntStream.range(0, expectedTasks.length).forEach(i -> expectedTasks[i] = i + 1 + " " + expectedTasks[i]);
        String expectedMessage = ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askNumber");
        View expectedView = new View();
        expectedView.update(expectedMessage, expectedTasks);

        UiStateService.processUserInput( "10", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processAskNumberNull () {
        UiStateModel uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        View actualView = new View();
        uiStateModel.addObserver(actualView);

        String[] expectedTasks = new String[] {};
        String expectedMessage = ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askNumber");
        View expectedView = new View();
        expectedView.update(expectedMessage, expectedTasks);

        UiStateService.processUserInput( null, uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processAskNewOk () {
        UiStateModel uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        uiStateModel.setStep(LogicStep.ASK_NEW);
        View actualView = new View();
        uiStateModel.addObserver(actualView);

        Task task = new Task("33", "user", "note4", "Wed Mar 25 16:01", "WAIT");
        tasks.add(task);
        String[] expectedTasks = tasks.stream().map(Task::toString).toArray(String[]::new);
        IntStream.range(0, expectedTasks.length).forEach(i -> expectedTasks[i] = i + 1 + " " + expectedTasks[i]);
        String expectedMessage = ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askNumber");
        View expectedView = new View();
        expectedView.update(expectedMessage, expectedTasks);

        UiStateService.processUserInput( "note4", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processAskStatusDone () {
        UiStateModel uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        uiStateModel.setCurrentTaskIndex(1);
        uiStateModel.setStep(LogicStep.ASK_STATUS);
        View actualView = new View();
        uiStateModel.addObserver(actualView);

        List <Task> expectList = new ArrayList<>(tasks);
        expectList.set(0, new Task("3", "user", "note3", "Wed Mar 25 16:01", "DONE"));
        String[] expectedTasks = expectList.stream().map(Task::toString).toArray(String[]::new);
        IntStream.range(0, expectedTasks.length).forEach(i -> expectedTasks[i] = i + 1 + " " + expectedTasks[i]);
        String expectedMessage = ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askNumber");
        View expectedView = new View();
        expectedView.update(expectedMessage, expectedTasks);

        UiStateService.processUserInput( "DONE", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processAskStatusArch () {
        UiStateModel uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        uiStateModel.setCurrentTaskIndex(3);
        uiStateModel.setStep(LogicStep.ASK_STATUS);
        View actualView = new View();
        uiStateModel.addObserver(actualView);

        List <Task> expectList = new ArrayList<>(tasks);
        expectList.remove(2);
        String[] expectedTasks = expectList.stream().map(Task::toString).toArray(String[]::new);
        IntStream.range(0, expectedTasks.length).forEach(i -> expectedTasks[i] = i + 1 + " " + expectedTasks[i]);
        String expectedMessage = ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askNumber");
        View expectedView = new View();
        expectedView.update(expectedMessage, expectedTasks);

        UiStateService.processUserInput("ARCH", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }

    @Test
    void processAskStatusInvalid () {
        UiStateModel uiStateModel = new UiStateModel();
        uiStateModel.manageOwner("user");
        View actualView = new View();
        uiStateModel.addObserver(actualView);

        String[] expectedTasks = tasks.stream().map(Task::toString).toArray(String[]::new);
        IntStream.range(0, expectedTasks.length).forEach(i -> expectedTasks[i] = i + 1 + " " + expectedTasks[i]);
        String expectedMessage = ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("askNumber");
        View expectedView = new View();
        expectedView.update(expectedMessage, expectedTasks);

        UiStateService.processUserInput( "arc", uiStateModel);

        Assertions.assertEquals(expectedView, actualView);
    }
}