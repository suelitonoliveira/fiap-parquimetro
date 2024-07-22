package com.fiap.parquimetro.repositories;

import com.fiap.parquimetro.entities.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

    Optional<Sessao> findByIdAndUsuario_UsuarioId(Long id, Long usuarioId);


    List<Sessao> findByFimSessaoBefore(LocalDateTime now);

}
