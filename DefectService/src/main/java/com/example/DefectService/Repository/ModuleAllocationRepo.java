package com.example.DefectService.Repository;

import com.example.DefectService.Entity.ModuleAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ModuleAllocationRepo extends JpaRepository<ModuleAllocation,Integer> {
    @Query(value = "select * from module_allocation where modules_id=?",nativeQuery = true)
    ModuleAllocation getAllocationDetails(int module_id);
    @Transactional
    @Modifying
    @Query(value = "delete  from module_allocation where project_team_members_id=?",nativeQuery = true)
    void deleteModuleAllocationByMemberId(int id);

}
