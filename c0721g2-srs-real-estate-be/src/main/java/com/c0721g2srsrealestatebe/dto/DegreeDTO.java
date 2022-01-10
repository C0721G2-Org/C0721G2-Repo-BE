package com.c0721g2srsrealestatebe.dto;

public class DegreeDTO {
    private Long id;
    private String name;

    public DegreeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DegreeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
