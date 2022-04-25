package com.example.app.Service;

import java.util.List;

import com.example.app.Entities.Producto;

public interface ProductoService {
	public List<Producto> ListarProductos();
	public Producto BuscarPorId(Long ig);
	public List<Producto> BuscarPorNombre(String nombre);
	public void IngresarProducto(Producto producto);
	public void ModificarProducto(Producto producto, Long id);
	public void EliminarProducto(Long id);
}
