package com.c0721g2srsrealestatebe.dto.realstatenews;

public class CusDTO {
    private String id;

    public CusDTO() {
    }

    public CusDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CusDTO{" +
                "id='" + id + '\'' +
                '}';
    }
}
