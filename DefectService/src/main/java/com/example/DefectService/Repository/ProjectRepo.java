package com.example.DefectService.Repository;

import com.example.DefectService.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer> {
    @Query(value = "select project_name from project where id=?",nativeQuery = true)
    public String getProjectNameById(int id);
    }


