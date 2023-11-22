package com.test.datasoft.datasoft.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Base64;

@Entity
@Table(name = "productos")
public class productos {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "prd_id")
    private Integer prd_id;
    @Column(nullable=false, length = 50, name = "prd_nombre")
    private String prd_nombre;
    @Column(nullable=false, length = 200, name = "prd_descripcion")
    private String prd_descripcion;
    @Column(nullable=false, precision = 6, scale = 2, name = "prd_precio")
    private BigDecimal prd_precio;
    @Lob
    @Column(nullable= false , name ="prd_imagen", length=1000)
    private byte[] prd_imagen;
    @Column(nullable=false ,length = 3,name = "prd_estado")
    private String prd_estado;

    @ManyToOne
    @JoinColumn(name = "cat_id")  // This is the foreign key column in the productos table
    private categorias categoria;


    public productos(Integer prd_id, String prd_nombre, String prd_descripcion, BigDecimal prd_precio, byte[] prd_imagen, String prd_estado, categorias categoria) {
        this.prd_id = prd_id;
        this.prd_nombre = prd_nombre;
        this.prd_descripcion = prd_descripcion;
        this.prd_precio = prd_precio;
        this.prd_imagen = prd_imagen;
        this.prd_estado = prd_estado;
        this.categoria = categoria;
    }

    public productos() {
    }

    public Integer getPrd_id() {
        return prd_id;
    }

    public void setPrd_id(Integer prd_id) {
        this.prd_id = prd_id;
    }

    public String getPrd_nombre() {
        return prd_nombre;
    }

    public void setPrd_nombre(String prd_nombre) {
        this.prd_nombre = prd_nombre;
    }

    public String getPrd_descripcion() {
        return prd_descripcion;
    }

    public void setPrd_descripcion(String prd_descripcion) {
        this.prd_descripcion = prd_descripcion;
    }

    public BigDecimal getPrd_precio() {
        return prd_precio;
    }

    public void setPrd_precio(BigDecimal prd_precio) {
        this.prd_precio = prd_precio;
    }

    public byte[] getPrd_imagen() {
        return prd_imagen;
    }

    public void setPrd_imagen(byte[] prd_imagen) {
        this.prd_imagen = prd_imagen;
    }

    public String isPrd_estado() {
        return prd_estado;
    }

    public void setPrd_estado(String prd_estado) {
        this.prd_estado = prd_estado;
    }

    public String getPrd_estado() {
        return prd_estado;
    }

    public categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(categorias categoria) {
        this.categoria = categoria;
    }
}
