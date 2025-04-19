package org.stc.service;

import org.springframework.stereotype.Service;
import org.stc.model.Route;
import org.stc.repository.RouteRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public List<Route> getAllRoutes() {
        return repository.findAll();
    }

    public Optional<Route> getRouteById(BigInteger id) {
        return repository.findById(id);
    }

    public List<Route> getRoutesByState(String state) {
        return repository.findByState(state);
    }

    public List<Route> getRoutesByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Route> getRoutesByStyle(String style) {
        return repository.findByStyle(style);
    }

    public List<Route> getRoutesByGrade(String grade) {
        return repository.findByGrade(grade);
    }

    public Route createRoute(Route route) {
        return repository.save(route);
    }

    public Route updateRoute(BigInteger id, Route newRoute) {
        return repository.findById(id)
                .map(route -> {
                    route.setName(newRoute.getName());
                    route.setGrade(newRoute.getGrade());
                    route.setCrag(newRoute.getCrag());
                    route.setState(newRoute.getState());
                    route.setStyle(newRoute.getStyle());
                    route.setUrl(newRoute.getUrl());
                    route.setType(newRoute.getType());
                    return repository.save(route);
                })
                .orElseGet(() -> {
                    newRoute.setId(id);
                    return repository.save(newRoute);
                });
    }

    public void deleteRoute(BigInteger id) {
        repository.deleteById(id);
    }
}
