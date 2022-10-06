package com.byval.labs.railwaytransport.service;

import com.byval.labs.railwaytransport.model.RailwayTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class RailwayTransportService {

    @Autowired
    MessageSource messages;

    public String createRailwayTransport(String model, int cost, int power, Locale locale) {
        RailwayTransport loco = new RailwayTransport();
        loco.setId((int)(Math.random() * 1000));
        loco.setModel(model);
        loco.setPower(power);
        loco.setCost(cost);
        loco.setActual(true);
        loco.setWeight(30000);
        return String.format(messages.getMessage("loco.create.message", null, locale), loco);
    }

    public String readRailwayTransport(String model, Locale locale) {
        RailwayTransport loco = new RailwayTransport();
        loco.setId((int)(Math.random() * 1000));
        loco.setModel(model);
        loco.setPower(10000);
        loco.setCost(1000000);
        loco.setActual(true);
        loco.setWeight(25000);
        return String.format(messages.getMessage("loco.read.message", null, locale), loco.toString());
    }

    public String updateRailwayTransport(int cost, RailwayTransport loco, Locale locale) {
        loco.setCost(cost);
        return String.format(messages.getMessage("loco.update.message", null, locale), loco);
    }

    public String deleteRailwayTransport(RailwayTransport loco, Locale locale) {
        loco.setActual(false);
        return String.format(messages.getMessage("loco.update.message", null, locale), loco);
    }
}
