package com.klashz.api.coches.domain.service.impl;

import com.klashz.api.coches.domain.dto.ProjectDto;
import com.klashz.api.coches.domain.repository.IProjectRepository;
import com.klashz.api.coches.domain.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectService implements IProjectService {

    private final IProjectRepository iProjectRepository;

    public ProjectService(IProjectRepository iProjectRepository) {
        this.iProjectRepository = iProjectRepository;
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return this.iProjectRepository.getAllProjects();
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {
        return iProjectRepository.save(projectDto);
    }
}
