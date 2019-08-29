package net.mrsistemas.healthy.business.persistence.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "city")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City extends BaseIdEntity{

    @Id
    @Getter
    @Setter
    @Column(insertable=false, updatable=false)
    private Long id;

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Location location;
}
