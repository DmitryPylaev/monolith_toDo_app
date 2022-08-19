package ru.pylaev.toDoProject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import ru.pylaev.toDoProject.presentLayer.runnableUI.console.ConsoleUI;
import ru.pylaev.toDoProject.presentLayer.runnableUI.telegram.TelegramUi;
import ru.pylaev.toDoProject.presentLayer.runnableUI.window.WindowUi;
import ru.pylaev.util.CustomProperties;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ToDoMain {
    public static final CustomProperties CUSTOM_PROPERTIES = new CustomProperties("customConfig");
    public static ApplicationContext context;

    public static void main (String[] args) {
        context = new SpringApplicationBuilder(ToDoMain.class).headless(false).run(args);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(context.getBean(ConsoleUI.class));
        executorService.execute(context.getBean(WindowUi.class));
        executorService.execute(context.getBean(TelegramUi.class));
    }
}

