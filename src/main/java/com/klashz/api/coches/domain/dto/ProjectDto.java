package com.klashz.api.coches.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private Long id;

    private String title;

    private String year;

    private String description;

    private String urlGithubFrontend;

    private String urlGithubBackend;
}
