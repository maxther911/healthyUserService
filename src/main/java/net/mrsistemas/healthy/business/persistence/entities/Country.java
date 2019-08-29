package net.mrsistemas.healthy.business.persistence.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {

    @Id
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String name;
}
