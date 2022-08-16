package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.projections.MovieMinProjection;

import java.util.Objects;

public class MovieMinDTO {
    private Long id;
    private String nome;

    public MovieMinDTO() {
    }

    public MovieMinDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public MovieMinDTO(MovieMinProjection projection) {
        id = projection.getId();
        nome = projection.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieMinDTO)) return false;
        MovieMinDTO that = (MovieMinDTO) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
