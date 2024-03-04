package com.klashz.api.coches.controller;

import com.klashz.api.coches.domain.dto.ProjectDto;
import com.klashz.api.coches.domain.service.IProjectService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping()
    public ResponseEntity<List<ProjectDto>> getAllProjects(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(projectService.getAllProjects());
    }
    @PostMapping()
    public ResponseEntity<ProjectDto> saveProject(@RequestBody ProjectDto projectDto){
        ProjectDto projectDto1 = this.projectService.save(projectDto);
        if( projectDto1 != null ){
            return ResponseEntity.status(HttpStatus.CREATED).body(projectDto1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
