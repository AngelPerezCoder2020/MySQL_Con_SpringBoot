package com.example.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.DAO.ProductoDao;
import com.example.app.Entities.Producto;

@Service
public class ProductoServiceImp implements ProductoService{
	
	@Autowired
	ProductoDao dao;
	
	@Override
	public List<Producto> ListarProductos() {
		return (List<Producto>) dao.findAll();
	}

	@Override
	public Producto BuscarPorId(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Producto> BuscarPorNombre(String nombre) {
		return dao.findByName(nombre);
	}

	@Override
	public void IngresarProducto(Producto producto) {
		dao.save(producto);
	}

	@Override
	public void EliminarProducto(Long id) {
		if(dao.existsById(id)) {
			dao.deleteById(id);
		}
	}

	@Override
	public void ModificarProducto(Producto producto, Long id) {
		if(dao.existsById(id)) {
			producto.setId(id);
			dao.save(producto);
		}
	}
}