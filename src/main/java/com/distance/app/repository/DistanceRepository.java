package com.distance.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.distance.app.entity.DistanceInfo;

@Repository
public interface DistanceRepository extends JpaRepository<DistanceInfo, Integer> {

}
