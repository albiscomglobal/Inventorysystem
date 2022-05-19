package com.albiscomglobal.inventorysystem.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="category")
public class Category {

    @Id
    @SequenceGenerator(
            name="category_sequence",
            sequenceName="category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    @Column(name="category_id")
    private Long id;

    @NotBlank
    @Column(name="category_name")

    private String category;

    //@NotBlank
    @Column(name="status")
    private int status;

    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable = false)
    private Date CreatedAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Date UpdatedAt;
}
