package com.example.app.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.Entities.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, Long>{
	@Query(value="SELECT * FROM productos WHERE nombre = ?1",
			nativeQuery = true)
	public List<Producto> findByName(String nombre);
}