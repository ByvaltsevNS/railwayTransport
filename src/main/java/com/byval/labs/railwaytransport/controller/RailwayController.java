package com.byval.labs.railwaytransport.controller;

import com.byval.labs.railwaytransport.model.RailwayTransport;
import com.byval.labs.railwaytransport.service.RailwayTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "manufacturer/transmachineholding/locomotives")
public class RailwayController {

    @Autowired
    private RailwayTransportService service;

    @GetMapping(value = "/{model}/{locale}")
    public ResponseEntity<RailwayTransport> getRailwayTransport(
            @PathVariable("model") String model,
            @PathVariable("locale") Locale locale) {

        RailwayTransport loco = service.readRailwayTransport(model, locale);
        loco.add(linkTo(methodOn(RailwayController.class).getRailwayTransport(model, locale)).withSelfRel(),
                linkTo(methodOn(RailwayController.class).postRailwayTransport(model, 15000, 2500000, locale)).withRel(service.messages.getMessage("loco.read.create.message", null, locale)),
                linkTo(methodOn(RailwayController.class).putRailwayTransport(loco.getId(), 15000, locale)).withRel(service.messages.getMessage("loco.read.update.message", null, locale)),
                linkTo(methodOn(RailwayController.class).deleteRailwayTransport(loco, locale)).withRel(service.messages.getMessage("loco.read.delete.message", null, locale)));
        return ResponseEntity.ok(loco);
    }

    @PostMapping
    public ResponseEntity<RailwayTransport> postRailwayTransport(
            @RequestParam("model") String model,
            @RequestParam("power") int power,
            @RequestParam("cost") int cost,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(service.createRailwayTransport(model, cost, power, locale));
    }

    @PutMapping
    public ResponseEntity<String> putRailwayTransport(
            @RequestParam("id") int id,
            @RequestParam("cost") int cost,
            @RequestParam("locale") Locale locale) {
        return ResponseEntity.ok(service.updateRailwayTransport(id, cost, locale));
    }

    /*@PutMapping
    public ResponseEntity<String> putRailwayTransport(
            @RequestParam("cost") int cost,
            @RequestBody RailwayTransport loco,
            @RequestParam("locale") Locale locale) {
        return ResponseEntity.ok(service.updateRailwayTransport(cost, loco, locale));
    }*/

    @DeleteMapping
    public ResponseEntity<String> deleteRailwayTransport(
            @RequestBody RailwayTransport loco,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(service.deleteRailwayTransport(loco, locale));
    }
}
