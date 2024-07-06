package com.fiap.parquimetro.repositories;

import com.fiap.parquimetro.entities.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Long> {
}
