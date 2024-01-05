package com.joelmaciel.hotelservice.domain.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Builder
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "hotels")
public class Hotel {

    @Id
    @EqualsAndHashCode.Include
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID hotelId;
    private String name;
    private String location;
    private String information;
}
