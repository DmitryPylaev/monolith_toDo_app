package ru.pylaev.util;

import java.util.List;
import java.util.stream.IntStream;

public class ListToNumberingArrayConverter {
    public static <T> String[] convert(List<T> list) {
        String[] arrTasks = new String[list.size()];
        IntStream.range(0, list.size()).forEach(i -> arrTasks[i] = i + 1 + " " + list.get(i));
        return arrTasks;
    }
}
