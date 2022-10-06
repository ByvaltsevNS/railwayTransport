package com.byval.labs.railwaytransport.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@ToString
public class RailwayTransport extends RepresentationModel<RailwayTransport> {
    private int id;
    private String model;
    private int power;
    private int cost;
    private boolean isActual;
    private int weight;
}
