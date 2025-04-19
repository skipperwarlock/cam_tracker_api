package org.stc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stc.model.Route;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, BigInteger> {
    List<Route> findByState(String state);
    List<Route> findByNameContainingIgnoreCase(String name);
    List<Route> findByStyle(String style);
    List<Route> findByGrade(String grade);
}
