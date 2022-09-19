package com.byval.labs.railwaytransport.controller;

import com.byval.labs.railwaytransport.model.RailwayTransport;
import com.byval.labs.railwaytransport.service.RailwayTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "manufacturer/transmachineholding/locomotives")
public class RailwayController {

    @Autowired
    private RailwayTransportService service;

    @GetMapping(value = "/{model}")
    public ResponseEntity<RailwayTransport> getRailwayTransport(
            @PathVariable("model") String model) {
        return ResponseEntity.ok(service.readRailwayTransport(model));
    }

    @PostMapping
    public ResponseEntity<RailwayTransport> postRailwayTransport(
            @RequestParam("model") String model,
            @RequestParam("power") int power,
            @RequestParam("cost") int cost) {
        return ResponseEntity.ok(service.createRailwayTransport(model, power, cost));
    }

    @PutMapping
    public ResponseEntity<RailwayTransport> putRailwayTransport(
            @RequestParam("cost") int cost,
            @RequestBody RailwayTransport loco) {
        return ResponseEntity.ok(service.updateRailwayTransport(cost, loco));
    }

    @DeleteMapping
    public ResponseEntity<RailwayTransport> deleteRailwayTransport(
            @RequestBody RailwayTransport loco) {
        return ResponseEntity.ok(service.deleteRailwayTransport(loco));
    }
}
