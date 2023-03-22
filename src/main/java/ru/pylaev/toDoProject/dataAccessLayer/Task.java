package ru.pylaev.toDoProject.dataAccessLayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "task")
@Getter
@NoArgsConstructor
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_generator")
    @Setter private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @Setter
    private Owner owner;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private String date;

    @Column(name = "status")
    @Setter private String status;

    public Task (String text, String date, String status) {
        this.text = text;
        this.date = date.substring(0,16);
        this.status = status;
    }

    public Task (Long id, String text, String date, String status) {
        this.id = id;
        this.text = text;
        this.date = date.substring(0,16);
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

