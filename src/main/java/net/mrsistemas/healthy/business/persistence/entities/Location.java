package net.mrsistemas.healthy.business.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity(name = "location")
public class Location extends BaseIdEntity{

    @Getter
    @Setter
    private Long latitude;

    @Getter
    @Setter
    private Long longitude;

    @Getter
    @Setter
    private Long altitude;
}
