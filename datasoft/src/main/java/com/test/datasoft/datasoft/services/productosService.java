package com.test.datasoft.datasoft.services;

import com.test.datasoft.datasoft.models.productos;
import com.test.datasoft.datasoft.repositories.productosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class productosService {

    @Autowired productosRepository productRepository;
    public List<productos> getProductsByCategoryId(Integer id) {
        return productRepository.getByCategory(id);
    }
    public List<productos> getAllProducts() {
        List<productos> productList = productRepository.findAll();
        productList.forEach(product -> {
            byte[] decodedImage = Base64.getDecoder().decode(product.getPrd_imagen());
            product.setPrd_imagen(decodedImage);
        });
        return productList;
    }
    public List<productos> getByCategory(Integer id) {
        List<productos> productList = productRepository.getByCategory(id);
        productList.forEach(product -> {
            byte[] decodedImage = Base64.getDecoder().decode(product.getPrd_imagen());
            product.setPrd_imagen(decodedImage);
        });
        return productList;
    }
    public Optional<productos> getProductDetail(Integer id) {
        Optional<productos> optionalProduct = productRepository.findById(id);

        optionalProduct.ifPresent(product -> {
            byte[] decodedImage = Base64.getDecoder().decode(product.getPrd_imagen());
            product.setPrd_imagen(decodedImage);
        });

        return optionalProduct;    }
}
