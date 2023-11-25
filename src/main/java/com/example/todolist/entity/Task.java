package com.example.todolist.entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import io.hypersistence.utils.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
        @TypeDef(name = "json", typeClass = JsonStringType.class)
})
@ToString(exclude = "user")
@EqualsAndHashCode(of = "id")
public class Task extends TaskAuditing<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


  //  @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private String description;

    @Column(name = "date_of_creation")
    private LocalDateTime dateOfCreation;

    @JoinColumn(name = "users_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Enumerated(EnumType.STRING)
    private Status status;
}
