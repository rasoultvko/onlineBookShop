package com.rsl.onlineshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@Table(schema = SchemaName.SchemaName)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book extends BaseEntity {

    private String name;
    private long price;
}
