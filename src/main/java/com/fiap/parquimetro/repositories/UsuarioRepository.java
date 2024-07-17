package com.fiap.parquimetro.repositories;

import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCpf(String cpf);
}
