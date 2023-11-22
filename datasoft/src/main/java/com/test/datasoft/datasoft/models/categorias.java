package com.test.datasoft.datasoft.models;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class categorias {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Integer cat_id;

    @Column(nullable=false, length = 50, name = "nombre")
    private String nombre;

    public categorias(Integer cat_id, String nombre) {
        this.cat_id = cat_id;
        this.nombre = nombre;
    }

    public categorias() {

    }

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
