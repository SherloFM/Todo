package com.ga.Todo.Model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="TodoCategories")

public class Category {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String description;

    @Lob
    @Column(columnDefinition = "BYTEA")
    private byte[] img;

    private String imgtype;

}
