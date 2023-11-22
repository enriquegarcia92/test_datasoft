package com.test.datasoft.datasoft.repositories;

import com.test.datasoft.datasoft.models.productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface productosRepository extends JpaRepository<productos,Integer> {
    @Query("SELECT p FROM productos p INNER JOIN p.categoria c WHERE c.cat_id=:id")
    List<productos> getByCategory(Integer id);
}
