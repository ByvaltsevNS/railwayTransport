package com.byval.labs.railwaytransport.controller;

import com.byval.labs.railwaytransport.model.RailwayTransport;
import com.byval.labs.railwaytransport.service.RailwayTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping(value = "manufacturer/transmachineholding/locomotives")
public class RailwayController {

    @Autowired
    private RailwayTransportService service;

    @GetMapping(value = "/{model}/{locale}")
    public ResponseEntity<String> getRailwayTransport(
            @PathVariable("model") String model,
            @PathVariable("locale") Locale locale) {
        return ResponseEntity.ok(service.readRailwayTransport(model, locale));
    }

    @PostMapping
    public ResponseEntity<String> postRailwayTransport(
            @RequestParam("model") String model,
            @RequestParam("power") int power,
            @RequestParam("cost") int cost,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(service.createRailwayTransport(model, power, cost, locale));
    }

    @PutMapping
    public ResponseEntity<String> putRailwayTransport(
            @RequestParam("cost") int cost,
            @RequestBody RailwayTransport loco,
            @RequestParam("locale") Locale locale) {
        return ResponseEntity.ok(service.updateRailwayTransport(cost, loco, locale));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRailwayTransport(
            @RequestBody RailwayTransport loco,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(service.deleteRailwayTransport(loco, locale));
    }
}
