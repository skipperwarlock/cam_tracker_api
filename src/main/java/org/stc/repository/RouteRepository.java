package org.stc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stc.model.Route;

import java.math.BigInteger;

@Repository
public interface RouteRepository extends JpaRepository<Route, BigInteger> {
}
