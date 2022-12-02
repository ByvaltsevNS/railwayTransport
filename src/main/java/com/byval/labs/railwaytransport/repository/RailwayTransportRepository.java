package com.byval.labs.railwaytransport.repository;

import com.byval.labs.railwaytransport.model.RailwayTransport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RailwayTransportRepository extends CrudRepository<RailwayTransport, String> {
    public RailwayTransport findByModel(String model);
    public RailwayTransport findById(int id);
}
