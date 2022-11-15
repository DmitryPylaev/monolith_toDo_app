package ru.pylaev.toDoProject.presentLayer.abstractions;

import ru.pylaev.toDoProject.presentLayer.BaseInputGetter;

public interface IRunnableControllerFactory extends IBaseControllerFactory {
    BaseInputGetter getInputGetter();
}
