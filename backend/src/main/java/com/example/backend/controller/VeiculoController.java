package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Veiculo;
import com.example.backend.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	private final VeiculoService veiculoService;

	@Autowired
	public VeiculoController(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	@GetMapping
	public List<Veiculo> getAllVeiculos() {
		return veiculoService.getAllVeiculos();
	}

	@GetMapping("/{id}")
	public Veiculo getVeiculoById(@PathVariable Long id) {
		return veiculoService.getVeiculoById(id);
	}

	@GetMapping("/busca")
	public List<Veiculo> getVeiculosByFilters(@RequestParam(required = false) String veiculo,
			@RequestParam(required = false) String marca, @RequestParam(required = false) Integer ano) {
		return veiculoService.getVeiculosByFilters(veiculo, marca, ano);
	}

	@PostMapping
	public Veiculo addVeiculo(@RequestBody Veiculo veiculo) {
		return veiculoService.addVeiculo(veiculo);
	}

	@PutMapping("/{id}")
	public Veiculo updateVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
		return veiculoService.updateVeiculo(id, veiculo);
	}

	@DeleteMapping("/{id}")
	public void deleteVeiculo(@PathVariable Long id) {
		veiculoService.deleteVeiculo(id);
	}

	@GetMapping("/paginado")
	public List<Veiculo> getPagedVeiculos(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		return veiculoService.getPagedVeiculos(page, size);
	}

}
