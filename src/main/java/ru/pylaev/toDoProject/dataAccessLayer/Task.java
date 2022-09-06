package ru.pylaev.toDoProject.dataAccessLayer;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter private long id;
    private String owner;
    private String text;
    private String date;
    @Setter private String status;

    public Task (String owner, String text, Date date, String status) {
        this.owner = owner;
        this.text = text;
        this.date = String.valueOf(date).substring(0,16);
        this.status = status;
    }

    @Override
    public String toString () { return  text + ' ' + date + ' ' + status; }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        if (!Objects.equals(owner, task.owner)) return false;
        if (!Objects.equals(text, task.text)) return false;
        if (!Objects.equals(date, task.date)) return false;
        return Objects.equals(status, task.status);
    }

    @Override
    public int hashCode ( ) {
        int result = owner != null ? owner.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}

