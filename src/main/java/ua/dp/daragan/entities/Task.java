package ua.dp.daragan.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Bogdan Daragan on 05.12.16.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Comparable<Task>{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer priority;

    @Override
    public int compareTo(Task otherTask) {
        return this.priority.compareTo(otherTask.getPriority());
    }
}