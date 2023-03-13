package com.devphilip.robotapocalypse.repository;

import com.devphilip.robotapocalypse.model.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long> {
}
