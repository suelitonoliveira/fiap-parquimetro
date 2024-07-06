package com.fiap.parquimetro.repositories;

import com.fiap.parquimetro.entities.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
}
