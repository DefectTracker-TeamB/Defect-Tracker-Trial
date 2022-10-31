package com.example.DefectService.Repository;

import com.example.DefectService.Entity.ProjectTeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface ProjectTeamMemberRepo extends JpaRepository<ProjectTeamMembers,Integer> {
    @Query(value = "select sum(contribution) from project_team_members where user_id=?",nativeQuery = true)
    public int contributionById(int id);

    @Query(value = "select * from project_team_members where project_id=?",nativeQuery = true)
    public List<ProjectTeamMembers> getTeamByProject(int project_id);
    @Transactional
    @Modifying
    @Query(value = "delete  from project_team_members where user_id=?",nativeQuery = true)
    public void deleteMembersByUserId(int user_id);

}
