package com.klashz.api.coches.domain.repository;

import com.klashz.api.coches.domain.dto.ProjectDto;

import java.util.List;

public interface IProjectRepository {

    List<ProjectDto> getAllProjects();
    ProjectDto save(ProjectDto projectDto);
}
