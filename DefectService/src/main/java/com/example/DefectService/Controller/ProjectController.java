package com.example.DefectService.Controller;

import com.example.DefectService.Dto.*;
import com.example.DefectService.Entity.Project;
import com.example.DefectService.Entity.ProjectTeamMembers;
import com.example.DefectService.Entity.Releases;
import com.example.DefectService.Entity.User;
import com.example.DefectService.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.Consumer;

@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    ProjectMemberService projectMemberService;
    @Autowired
    ReleaseServices releaseServices;
    @Autowired
    ModuleServices moduleServices;
    @Autowired
    ModuleAllocationService moduleAllocationService;
    @Autowired
    SmokeTestService smokeTestService;
    @PostMapping("/saveProject")
    public ResponseEntity<Object> saveProject(@RequestBody ProjectDto projectDto){
        projectService.saveProject(projectDto);
        return ResponseEntity.ok("Project Saved");
    }

    @GetMapping("getProject/{id}")
    public ResponseEntity<Object>getProjectById(@PathVariable("id")int id){
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @DeleteMapping("/deleteProject/{id}")
    public ResponseEntity<Object>deleteProjectById(@PathVariable("id") int id){
        projectService.deleteProjectById(id);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("/editProject/{id}")
    public ResponseEntity<Object>editProject(@PathVariable("id") int id, @RequestBody ProjectDto projectDto){
        projectService.editProjectById(id, projectDto);
        return ResponseEntity.ok("Successfully edited");
    }
    @PostMapping("/saveRelease/{project_id}")
    public ResponseEntity<Object>saveRelease(@PathVariable("project_id")int project_id, @RequestBody ReleaseDto releaseDto){
        releaseServices.saveRelease(project_id,releaseDto);
        return ResponseEntity.ok("Release Saved");
    }

    @PostMapping("/addMembers/{project_id}/{user_id}")
    public ResponseEntity<Object> addMembers(@PathVariable("project_id") int project_id, @PathVariable("user_id")
    int user_id, @RequestBody ProjectTeamMembersDto projectTeamMembersDto){
        projectMemberService.SaveProjectMembers(project_id,user_id,projectTeamMembersDto);
        return ResponseEntity.ok("added to project");
    }
    @DeleteMapping("deleteMembers/{id}")
    public ResponseEntity<Object> addMembers(@PathVariable("id") int id){
        projectMemberService.deleteProjectMembers(id);
        return ResponseEntity.ok("removed from project");
    }
    @PostMapping("edit_team_members/{project_id}/{user_id}/{project_member_id}")
    public ResponseEntity<Object> editMembers(@PathVariable("project_id") int project_id,@PathVariable("user_id") int user_id,
                                              @PathVariable("project_member_id") int project_member_id,
                                              @RequestBody ProjectTeamMembersDto projectTeamMembersDto){
        projectMemberService.editProjectMembers(project_id,user_id,project_member_id,projectTeamMembersDto);
        return ResponseEntity.ok("Member edited");
    }

    @PostMapping("addModule/{project_id}/{user_id}")
    public ResponseEntity<Object>addModules(@PathVariable("project_id") int project_id,
                                            @PathVariable("user_id") int user_id,
                                             @RequestBody ModuleDto moduleDto){
        moduleServices.addModule(project_id,user_id,moduleDto);
        return ResponseEntity.ok("module added");

    }

    @DeleteMapping("deleteModule/{module_id}")
    public ResponseEntity<Object>deleteModule(@PathVariable("module_id") int module_id){
        moduleServices.deleteModule(module_id);
        return ResponseEntity.ok("module deleted");
    }

    @PostMapping("allocateModule/{module_id}/{project_member_id}")
    public ResponseEntity<Object>allocateModule(@PathVariable("module_id") int module_id,
                                                @PathVariable("project_member_id") int project_member_id){
        moduleAllocationService.allocateModule(module_id,project_member_id);
        return ResponseEntity.ok("Allocated");
    }


    @PostMapping("saveTest/{release_id}")
    public ResponseEntity<Object>saveTest(@PathVariable("release_id") int release_id,@RequestBody SmokeDto smokeDto){
        smokeTestService.saveTest(release_id,smokeDto);
        return ResponseEntity.ok("Test created");

    }
    @PostMapping("changeSmokeStatus/{test_id}")
    public ResponseEntity<Object>changeStatus(@PathVariable("test_id")int test_id,@RequestBody DefectStatusDto defectStatusDto){
        smokeTestService.editSmokeStatus(test_id,defectStatusDto);
        return ResponseEntity.ok("Test status changed");
    }
    @PostMapping("setDeveloper/{module_id}/{user_id}")
    public ResponseEntity<Object> setDeveloper(@PathVariable("module_id") int module_id,
                                               @PathVariable("user_id") int user_id){
        moduleServices.setDeveloper(module_id,user_id);
        return ResponseEntity.ok("developer changed");
    }




}

