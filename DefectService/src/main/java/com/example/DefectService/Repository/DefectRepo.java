package com.example.DefectService.Repository;

import com.example.DefectService.Entity.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DefectRepo extends JpaRepository<Defect,Integer> {
    @Query(value = "select count(*) from defect where severity=?",nativeQuery = true)
    public String filterBySeverity(String severity);

    @Query(value = "select count(*) from defect where status=?",nativeQuery = true)
    public int filterByStatus(String status);

    @Query(value ="select count(*) from defect where project_id=? and status=?",nativeQuery = true)
    public int filterByProjectStatus(int project_id,String status);

    @Query(value = "select count(*) from defect where project_id=?",nativeQuery = true)
    public int defectCountForProject(int project_id);

}
