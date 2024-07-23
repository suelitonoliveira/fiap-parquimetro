package com.fiap.parquimetro.repositories;

import com.fiap.parquimetro.entities.Parquimetro;
import com.fiap.parquimetro.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculo, Long> {
    Optional<Veiculo> findByPlacaIgnoreCase(String placa);
}
