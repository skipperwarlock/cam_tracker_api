package org.stc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stc.model.Route;
import org.stc.service.RouteService;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Route> getAllRoutes() {
        return service.getAllRoutes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable BigInteger id) {
        Optional<Route> route = service.getRouteById(id);
        return route.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Route createRoute(@RequestBody Route route) {
        return service.createRoute(route);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable BigInteger id, @RequestBody Route newRoute) {
        Route updatedRoute = service.updateRoute(id, newRoute);
        return ResponseEntity.ok(updatedRoute);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable BigInteger id) {
        service.deleteRoute(id);
        return ResponseEntity.noContent().build();
    }
}