package com.example.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.app.Entities.Producto;
import com.example.app.Service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	ProductoService imp;
	
	@GetMapping()
	public List<Producto> ListarProductos() {
		return imp.ListarProductos();
	}
	@GetMapping(value = "/{id}")
	public Producto BuscarporId(@PathVariable Long id) {
		return imp.BuscarPorId(id);
	}
	@GetMapping(value = "/Nombre/{nombre}")
	public List<Producto> findByName(@PathVariable String nombre){
		return imp.BuscarPorNombre(nombre);
	}
	@PostMapping
	public void NuevoProducto(@RequestBody Producto producto) {
		producto.setId(null);
		imp.IngresarProducto(producto);
	}
	@PutMapping(value = "/{id}")
	public void ModificarProducto(@PathVariable Long id, @RequestBody Producto producto) {
		imp.ModificarProducto(producto, id);
	}
	@DeleteMapping(value = "/{id}")
	public void EliminarProducto(@PathVariable Long id) {
		imp.EliminarProducto(id);
	}
}