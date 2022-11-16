package ru.pylaev.toDoProject.presentLayer.abstractions;

import java.util.function.Supplier;

public interface IRunnableControllerFactory extends IBaseControllerFactory {
    Supplier<String> getInputGetter();
}
