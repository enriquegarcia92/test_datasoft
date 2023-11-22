package com.test.datasoft.datasoft.controllers;

import com.test.datasoft.datasoft.models.productos;
import com.test.datasoft.datasoft.services.productosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/productos")
public class productosController {
    @Autowired productosService prodService;
    @GetMapping("/getAll")
    public List<productos> list() {
        return prodService.getAllProducts();
    }
    @GetMapping("/getByCategory/{id}")
    public List<productos> getbycat(@PathVariable Integer id) {
        return prodService.getByCategory(id);
    }

    @GetMapping("/getDetail/{id}")
    public Optional<productos> getDetail(@PathVariable Integer id) {
        return prodService.getProductDetail(id);
    }
}
