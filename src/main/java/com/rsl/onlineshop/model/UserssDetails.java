package com.rsl.onlineshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserssDetails extends BaseEntity {

    private String username;
    private String password;

    private Boolean enabled=true;
}
