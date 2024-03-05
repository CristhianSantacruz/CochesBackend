package com.klashz.api.coches.exception.persistence.repository.impl;

import com.klashz.api.coches.domain.dto.ProjectDto;
import com.klashz.api.coches.domain.repository.IProjectRepository;
import com.klashz.api.coches.exception.persistence.repository.IProjectJpaRepository;
import com.klashz.api.coches.exception.persistence.mapper.IProjectMapper;
import com.klashz.api.coches.exception.persistence.models.ProjectEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProjectRepository implements IProjectRepository {

    private final IProjectJpaRepository iProjectJpaRepository;
    private final IProjectMapper iProjectMapper;

    public ProjectRepository(IProjectJpaRepository iProjectJpaRepository, IProjectMapper iProjectMapper) {
        this.iProjectJpaRepository = iProjectJpaRepository;
        this.iProjectMapper = iProjectMapper;
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return iProjectMapper.toProjectsDto(iProjectJpaRepository.findAll());
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {
        ProjectEntity projectEntity = iProjectMapper.toProjectEntity(projectDto);
        return iProjectMapper.toProjectDto(iProjectJpaRepository.save(projectEntity));
    }
}
