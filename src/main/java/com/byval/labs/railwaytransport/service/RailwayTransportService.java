package com.byval.labs.railwaytransport.service;

import com.byval.labs.railwaytransport.config.ServiceConfig;
import com.byval.labs.railwaytransport.model.RailwayTransport;
import com.byval.labs.railwaytransport.repository.RailwayTransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class RailwayTransportService {

    @Autowired
    public MessageSource messages;
    @Autowired
    RailwayTransportRepository railwayTransportRepository;
    @Autowired
    ServiceConfig serviceConfig;

    public RailwayTransport readRailwayTransport(String model, Locale locale) {
        RailwayTransport railwayTransport = railwayTransportRepository.findByModel(model);
        if (railwayTransport == null) {
            throw new IllegalArgumentException(String.format(messages.getMessage("railwaytransport.search.error.message", null, null), model));
        }
        return railwayTransport.withComment(serviceConfig.getProperty());
    }

    public RailwayTransport createRailwayTransport(String model, int cost, int power, Locale locale){
        RailwayTransport loco = new RailwayTransport();
        loco.setId((int)(Math.random() * 1000));
        loco.setModel(model);
        loco.setPower(power);
        loco.setCost(cost);
        loco.setActual(true);
        loco.setWeight(30000);

        railwayTransportRepository.save(loco);
        return loco.withComment(serviceConfig.getProperty());
    }

    public String updateRailwayTransport(int id, int cost, Locale locale) {
        RailwayTransport railwayTransport = railwayTransportRepository.findById(id);
        railwayTransport.setCost(cost);
        railwayTransportRepository.save(railwayTransport);
        return String.format(messages.getMessage("loco.update.message", null, locale), railwayTransport);
    }

    public String deleteRailwayTransport(RailwayTransport loco, Locale locale) {
        String responseMessage = null;
        railwayTransportRepository.delete(loco);
        responseMessage = String.format(messages.getMessage("railwaytransport.delete.message", null, locale), loco);
        return responseMessage;
    }

    /*public String createRailwayTransport(String model, int cost, int power, Locale locale) {
        RailwayTransport loco = new RailwayTransport();
        loco.setId((int)(Math.random() * 1000));
        loco.setModel(model);
        loco.setPower(power);
        loco.setCost(cost);
        loco.setActual(true);
        loco.setWeight(30000);

        return String.format(messages.getMessage("loco.create.message", null, locale), loco);
    }

    public RailwayTransport readRailwayTransport(String model, Locale locale) {
        RailwayTransport loco = new RailwayTransport();
        loco.setId((int)(Math.random() * 1000));
        loco.setModel(model);
        loco.setPower(10000);
        loco.setCost(1000000);
        loco.setActual(true);
        loco.setWeight(25000);
        return loco;
    }

    public String updateRailwayTransport(int cost, RailwayTransport loco, Locale locale) {
        loco.setCost(cost);
        return String.format(messages.getMessage("loco.update.message", null, locale), loco);
    }

    public String deleteRailwayTransport(RailwayTransport loco, Locale locale) {
        loco.setActual(false);
        return String.format(messages.getMessage("loco.delete.message", null, locale), loco);
    }*/
}
