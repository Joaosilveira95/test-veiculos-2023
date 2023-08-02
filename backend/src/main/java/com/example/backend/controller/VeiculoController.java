package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Veiculo;
import com.example.backend.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAllVeiculos() {
        List<Veiculo> veiculos = veiculoService.getAllVeiculos();
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

}
