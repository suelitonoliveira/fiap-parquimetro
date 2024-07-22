package com.fiap.parquimetro.repositories;

import com.fiap.parquimetro.entities.Pagamento;
import com.fiap.parquimetro.entities.Sessao;
import com.fiap.parquimetro.enums.StatusPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    Optional<Pagamento> findBySessao(Sessao sessao);
}
