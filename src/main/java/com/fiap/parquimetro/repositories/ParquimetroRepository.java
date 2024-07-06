package com.fiap.parquimetro.repositories;

import com.fiap.parquimetro.entities.Parquimetro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParquimetroRepository extends JpaRepository<Parquimetro, Long> {
}
