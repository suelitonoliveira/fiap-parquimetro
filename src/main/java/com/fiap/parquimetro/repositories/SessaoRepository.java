package com.fiap.parquimetro.repositories;

import com.fiap.parquimetro.entities.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

    Optional<Sessao> findByUsuario_UsuarioId(Long usuarioId);

}
