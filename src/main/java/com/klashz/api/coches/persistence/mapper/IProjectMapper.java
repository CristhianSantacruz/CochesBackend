package com.klashz.api.coches.persistence.mapper;

import com.klashz.api.coches.domain.dto.ProjectDto;
import com.klashz.api.coches.persistence.models.ProjectEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProjectMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "urlGithubFrontend", target = "urlGithubFrontend")
    @Mapping(source = "urlGithubBackend", target = "urlGithubBackend")
    ProjectDto toProjectDto(ProjectEntity projectEntity);
    @InheritInverseConfiguration
    ProjectEntity toProjectEntity(ProjectDto projectDto);

    List<ProjectDto> toProjectsDto(List<ProjectEntity> projectEntities);


}
