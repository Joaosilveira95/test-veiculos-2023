package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "veiculo")
public class Veiculo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String veiculo;
    private String marca;
    private Integer ano;
    private String descricao;
    private boolean vendido;
    private String chassi;
    private Double preco;

}
