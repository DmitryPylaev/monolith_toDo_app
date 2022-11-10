package ru.pylaev.toDoProject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.ui.RunnableUI;
import ru.pylaev.toDoProject.presentLayer.runnableUI.console.ConsoleUIFactory;
import ru.pylaev.toDoProject.presentLayer.runnableUI.window.WindowUIFactory;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.util.CustomProperties;

import java.util.concurrent.Executors;

@SpringBootApplication
public class ToDoMain {
    public static final CustomProperties PROPERTIES = new CustomProperties("customConfig");

    public static void main (String[] args){
        ApplicationContext context = new SpringApplicationBuilder(ToDoMain.class).headless(false).run(args);

        var executorService = Executors.newCachedThreadPool();

        executorService.execute(new RunnableUI(context.getBean(View.class), context.getBean(UiStateModel.class), context.getBean(ConsoleUIFactory.class)));
        executorService.execute(new RunnableUI(context.getBean(View.class), context.getBean(UiStateModel.class), context.getBean(WindowUIFactory.class)));
//        executorService.execute(new RunnableUI(context.getBean(View.class), context.getBean(UiStateModel.class), context.getBean(TelegramUIFactory.class)));
    }
}

