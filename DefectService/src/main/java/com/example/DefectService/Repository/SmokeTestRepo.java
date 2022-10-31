package com.example.DefectService.Repository;

import com.example.DefectService.Entity.Smoke_Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmokeTestRepo extends JpaRepository<Smoke_Test,Integer> {

}
