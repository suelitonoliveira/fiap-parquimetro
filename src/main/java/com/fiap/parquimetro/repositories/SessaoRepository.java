package com.fiap.parquimetro.repositories;

import com.fiap.parquimetro.entities.Secao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Secao, Long> {
}
