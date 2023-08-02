package com.example.backend.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.Veiculo;
import com.example.backend.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }
    
    public Veiculo addVeiculo(Veiculo veiculo) {
        if (veiculoRepository.findByChassi(veiculo.getChassi()) != null) {
            throw new IllegalArgumentException("Já existe um veículo com esse número de chassi.");
        }
        if (veiculo.getPreco() < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (veiculo.getAno() > currentYear) {
            throw new IllegalArgumentException("O ano do veículo não pode ser superior ao ano corrente.");
        }
        return veiculoRepository.save(veiculo);
    }

}
