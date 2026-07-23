package com.rsl.onlineshop.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@Table(schema = SchemaName.SchemaName)
@AllArgsConstructor
@NoArgsConstructor
public class Factor extends BaseEntity {

@ManyToOne
private UserssDetails userssDetails;

//private UsersDetails usersDetails;
@Enumerated(EnumType.STRING)
private Payed payed;
}
