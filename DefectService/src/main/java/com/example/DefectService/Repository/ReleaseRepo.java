package com.example.DefectService.Repository;

import com.example.DefectService.Entity.ProjectTeamMembers;
import com.example.DefectService.Entity.Releases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepo extends JpaRepository<Releases,Integer> {

}
