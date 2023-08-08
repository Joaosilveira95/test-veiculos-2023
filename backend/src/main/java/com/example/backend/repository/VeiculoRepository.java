package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	Veiculo findByChassi(String chassi);

	List<Veiculo> findAllByVeiculoContainingAndMarcaContainingAndAno(String veiculo, String marca, Integer ano);

}
