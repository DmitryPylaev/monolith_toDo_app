package ru.pylaev.toDoProject.presentLayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.pylaev.toDoProject.businessLogicLayer.LogicStep;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.util.HeadlessSpringBootContextLoader;
import ru.pylaev.util.ListToNumberingArrayConverter;
import ru.pylaev.util.SQLRequestExecutor;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(loader = HeadlessSpringBootContextLoader.class)
class JsonControllerTest {
    @Autowired
    private MockMvc mvc;

    List<Task> tasks = new ArrayList<>();

    @BeforeEach
    void setUp() throws URISyntaxException, IOException {
        SQLRequestExecutor.executeFromFile("PrepareData.sql");
    }

    @Test
    void processUserInput () throws Exception {
        var task1 = new Task(3, "user", "помидоры (tomatoes)", "Wed Mar 25 16:01", "WAIT");
        var task2 = new Task(11, "user", "гречка (buckwheat)", "Wed Mar 24 16:01", "WAIT");
        var task3 = new Task(14, "user", "картошка (potatoes)", "Thu Mar 23 16:01", "DONE");

        tasks.clear();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        var expectedTasks = ListToNumberingArrayConverter.convert(tasks);
        var stringBuilder = new StringBuilder();
        Arrays.stream(expectedTasks).forEach(task -> stringBuilder.append(task).append("\n"));

        stringBuilder.append(LogicStep.ASK_NUMBER);

        this.mvc.perform(post("/postJson")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"content\": \"user\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(stringBuilder.toString()));
    }
}