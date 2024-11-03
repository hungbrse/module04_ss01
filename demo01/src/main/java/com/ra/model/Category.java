package com.ra.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long categoryId;
    @Column(name = "category_name",length = 50,unique = true)
    private String categoryName;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private Boolean status;
}
