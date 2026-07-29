package com.rsl.onlineshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Setter
@Getter
@Table(schema = SchemaName.SchemaName)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Where(clause = "deleted is null")
@SQLDelete(sql = "update onlineshop.book set deleted =now() where id = ? ")
public class Book extends BaseEntity {

    private String name;
    private long price;
}
