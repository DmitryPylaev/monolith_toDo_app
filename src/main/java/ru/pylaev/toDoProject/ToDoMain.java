package ru.pylaev.toDoProject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import ru.pylaev.toDoProject.presentLayer.runnableUi.console.ConsoleUserInterface;
import ru.pylaev.toDoProject.presentLayer.runnableUi.window.WindowUserInterface;
import ru.pylaev.util.CustomProperties;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ToDoMain {
    public static final CustomProperties CUSTOM_PROPERTIES = new CustomProperties("customConfig");
    public static ApplicationContext applicationContext;

    public static void main (String[] args) {
        applicationContext = new SpringApplicationBuilder(ToDoMain.class).headless(false).run();

        ConsoleUserInterface consoleUserInterface = applicationContext.getBean("consoleUserInterface", ConsoleUserInterface.class);
        WindowUserInterface windowUserInterface = applicationContext.getBean("windowUserInterface", WindowUserInterface.class);
//        TelegramUserInterface telegramUserInterface = applicationContext.getBean("telegramUserInterface", TelegramUserInterface.class);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(consoleUserInterface);
        executorService.execute(windowUserInterface);
//        executorService.execute(telegramUserInterface);
    }
}

