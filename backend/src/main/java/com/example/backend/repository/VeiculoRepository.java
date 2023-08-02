package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
