package com.klashz.api.coches.persistence.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "projects")
public class ProjectEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id

    private Long id;
    @Column(name = "titulo")
    private String title;
    @Column(name = " descripcion",length = 1024)
    private String description;
    @Column(name = "linkGithubFronted")
    private String urlGithubFrontend;
    @Column(name = "linkGithubBackend")
    private String urlGithubBackend;
    @Column(name = "Año")
    private String year;
}
