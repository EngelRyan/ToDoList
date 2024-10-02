package br.com.engelryan.todolist.Task;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Data
@Entity(name = "Tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @Column(nullable = false, length = 50)
    private String title;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String priority;

    private String idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;


}
