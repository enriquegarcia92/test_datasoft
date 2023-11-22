package com.test.datasoft.datasoft.services;

import com.test.datasoft.datasoft.models.categorias;
import com.test.datasoft.datasoft.models.productos;
import com.test.datasoft.datasoft.repositories.categoriasRepository;
import com.test.datasoft.datasoft.repositories.productosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoriasService {
    @Autowired
    categoriasRepository catRepository;

    public List<categorias> getAllCategories() {
        return catRepository.findAll();
    }

}
