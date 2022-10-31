package com.example.DefectService.Repository;

import com.example.DefectService.Entity.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepo extends JpaRepository<Modules,Integer> {
    @Query(value = "select module_name from modules where project_id=?",nativeQuery = true)
    public List<String> moduleByProject(int project_id);


}
