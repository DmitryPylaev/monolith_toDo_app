package ru.pylaev.toDoProject.dataAccessLayer.dataBase;

import org.springframework.data.repository.CrudRepository;
import ru.pylaev.toDoProject.dataAccessLayer.User;

import java.util.List;

public interface UserSpringRepository extends CrudRepository<User, Long> {
    List<User> findByName(String userName);
}
