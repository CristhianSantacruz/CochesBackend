package com.klashz.api.coches.domain.service;

import com.klashz.api.coches.domain.dto.ProjectDto;

import java.util.List;

public interface IProjectService {

    List<ProjectDto> getAllProjects();
    ProjectDto save(ProjectDto projectDto);

}
