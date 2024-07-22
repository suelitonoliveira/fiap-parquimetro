package com.fiap.parquimetro.repositories;

import com.fiap.parquimetro.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findDistinctByUsuario_Cpf(String cpf);
}
