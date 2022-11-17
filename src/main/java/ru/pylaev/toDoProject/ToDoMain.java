package ru.pylaev.toDoProject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import ru.pylaev.toDoProject.presentLayer.controller.runnable.ConsoleController;
import ru.pylaev.toDoProject.presentLayer.factories.console.ConsoleUiFactory;
import ru.pylaev.toDoProject.presentLayer.factories.telegram.TelegramController;
import ru.pylaev.toDoProject.presentLayer.factories.telegram.TelegramUiFactory;
import ru.pylaev.toDoProject.presentLayer.factories.window.WindowController;
import ru.pylaev.toDoProject.presentLayer.factories.window.WindowUiFactory;
import ru.pylaev.util.CustomProperties;

import java.util.concurrent.Executors;

@SpringBootApplication
public class ToDoMain {
    public static final CustomProperties PROPERTIES = new CustomProperties("customConfig");

    public static void main (String[] args){
        ApplicationContext context = new SpringApplicationBuilder(ToDoMain.class).headless(false).run(args);

        var executorService = Executors.newCachedThreadPool();

        executorService.execute(new ConsoleController(context.getBean(ConsoleUiFactory.class)));
        executorService.execute(new WindowController(context.getBean(WindowUiFactory.class)));
        executorService.execute(new TelegramController(context.getBean(TelegramUiFactory.class)));
    }
}

