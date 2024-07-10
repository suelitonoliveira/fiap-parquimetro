package com.fiap.parquimetro.repositories;

import com.fiap.parquimetro.entities.Pagamento;
import com.fiap.parquimetro.enums.StatusPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    boolean existsBySessao_Usuario_UsuarioIdAndSessao_Parquimetro_IdAndStatusPagamento(Long usuarioId, Long parquimetroId, StatusPagamento status);
}
