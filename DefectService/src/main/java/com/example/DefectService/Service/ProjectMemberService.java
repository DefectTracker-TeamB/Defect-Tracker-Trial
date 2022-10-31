package com.example.DefectService.Service;

import com.example.DefectService.Dto.ProjectTeamMembersDto;
import com.example.DefectService.Entity.ProjectTeamMembers;

public interface ProjectMemberService {
    int sumOfContribution(int id);
    void SaveProjectMembers(int project_id,int user_id,ProjectTeamMembersDto projectTeamMembersDto);
    void deleteProjectMembers(int id);
    void editProjectMembers(int project_id,int user_id,int project_memberId,ProjectTeamMembersDto projectTeamMembersDto);
}
