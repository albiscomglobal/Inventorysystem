package com.albiscomglobal.inventorysystem.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Brand")
@Builder
public class Brand {


    @Id

    @SequenceGenerator(
            name="brand_sequence",
            sequenceName="brand_sequence",
            allocationSize = 1

    )
    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "brand_sequence"
    )

    private Long id;
    private String brand;
    private int status;

    @Column(name="created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date CreatedAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private Date UpdatedAt;
}
