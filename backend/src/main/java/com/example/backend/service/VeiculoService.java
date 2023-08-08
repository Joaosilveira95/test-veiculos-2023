package com.example.backend.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

	public Veiculo getVeiculoById(Long id) {
		return veiculoRepository.findById(id).orElse(null);
	}

	public List<Veiculo> getVeiculosByFilters(String veiculo, String marca, Integer ano) {
		return veiculoRepository.findAllByVeiculoContainingAndMarcaContainingAndAno(veiculo, marca, ano);
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

	public Veiculo updateVeiculo(Long id, Veiculo updatedVeiculo) {
		Veiculo veiculo = veiculoRepository.findById(id).orElse(null);
		if (veiculo == null) {
			throw new IllegalArgumentException("Veículo não encontrado.");
		}
		veiculo.setVeiculo(updatedVeiculo.getVeiculo());
		veiculo.setMarca(updatedVeiculo.getMarca());
		veiculo.setAno(updatedVeiculo.getAno());
		veiculo.setDescricao(updatedVeiculo.getDescricao());
		veiculo.setVendido(updatedVeiculo.isVendido());
		veiculo.setDataAtualizacao(new Date());
		veiculo.setChassi(updatedVeiculo.getChassi());
		veiculo.setPreco(updatedVeiculo.getPreco());
		return veiculoRepository.save(veiculo);
	}

	public void deleteVeiculo(Long id) {
		veiculoRepository.deleteById(id);
	}

	public List<Veiculo> getPagedVeiculos(int page, int size) {
		return veiculoRepository.findAll(PageRequest.of(page, size)).getContent();
	}

}
