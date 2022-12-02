package com.byval.labs.railwaytransport.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter @ToString
@Entity
@Table(name="railway_transport")
public class RailwayTransport extends RepresentationModel<RailwayTransport> {
    @Id
    @Column(name="id", nullable = false)
    private int id;
    @Column(name="model", nullable = false)
    private String model;
    @Column(name="power", nullable = false)
    private int power;
    @Column(name="cost", nullable = false)
    private int cost;
    @Column(name="actual", nullable = false)
    private boolean actual;
    @Column(name="weight", nullable = false)
    private int weight;
    @Column(name="comment")
    private String comment;
    public com.byval.labs.railwaytransport.model.RailwayTransport withComment(String comment) {
        this.setComment(comment);
        return this;
    }
}
