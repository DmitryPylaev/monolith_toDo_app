package ru.pylaev.toDoProject.businessLogicLayer;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TranslatorService {
    private static Translator translator;

    @Autowired
    public TranslatorService(Translator t) {
        translator = t;
    }
    public static Respond addTranslate (Respond respond) {
        String[] tasks = respond.getTasks();
        for (var task:tasks) {
        }
        return respond;
    }
}
