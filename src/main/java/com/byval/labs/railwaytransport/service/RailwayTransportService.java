package com.byval.labs.railwaytransport.service;

import com.byval.labs.railwaytransport.model.RailwayTransport;
import org.springframework.stereotype.Service;

@Service
public class RailwayTransportService {

    public RailwayTransport createRailwayTransport(String model, int cost, int power) {
        RailwayTransport loco = new RailwayTransport();
        loco.setId((int)(Math.random() * 1000));
        loco.setModel(model);
        loco.setPower(power);
        loco.setCost(cost);
        loco.setActual(true);
        loco.setWeight(30000);
        return loco;
    }

    public RailwayTransport readRailwayTransport(String model) {
        RailwayTransport loco = new RailwayTransport();
        loco.setId((int)(Math.random() * 1000));
        loco.setModel(model);
        loco.setPower(10000);
        loco.setCost(1000000);
        loco.setActual(true);
        loco.setWeight(25000);
        return loco;
    }

    public RailwayTransport updateRailwayTransport(int cost, RailwayTransport loco) {
        loco.setCost(cost);
        return loco;
    }

    public RailwayTransport deleteRailwayTransport(RailwayTransport loco) {
        loco.setActual(false);
        loco = null;
        return loco;
    }
}
