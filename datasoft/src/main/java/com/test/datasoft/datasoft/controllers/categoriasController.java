package com.test.datasoft.datasoft.controllers;

import com.test.datasoft.datasoft.models.categorias;
import com.test.datasoft.datasoft.models.productos;
import com.test.datasoft.datasoft.services.categoriasService;
import com.test.datasoft.datasoft.services.productosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class categoriasController {
    @Autowired
    categoriasService categoriasService;
    @GetMapping("/getAll")
    public List<categorias> list() {
        return categoriasService.getAllCategories();
    }
}
