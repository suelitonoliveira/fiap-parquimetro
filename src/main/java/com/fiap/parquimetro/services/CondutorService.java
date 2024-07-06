package com.fiap.parquimetro.services;

import com.fiap.parquimetro.entities.Condutor;
import com.fiap.parquimetro.entities.Endereco;
import com.fiap.parquimetro.repositories.CondutorRepository;
import com.fiap.parquimetro.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CondutorService {

    @Autowired
    private CondutorRepository condutorRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Condutor> listarTodos() {
        return this.condutorRepository.findAll();
    }

    @Transactional
    public Condutor cadastrarCondutor(Condutor condutor) {
        Endereco endereco = condutor.getEndereco();
        enderecoRepository.save(endereco);
        return this.condutorRepository.save(condutor);
    }

    public Condutor listarCondutorPorId(Long idCondutor) {
        Optional<Condutor> condutorOptional = this.condutorRepository.findById(idCondutor);
        return condutorOptional.orElse(null);
    }

    public Condutor atualizarCondutor(Long idCondutor, Condutor condutor) {
        condutor = condutorRepository.findById(idCondutor)
                .orElseThrow(() -> new IllegalArgumentException("Condutor não encontrado"));
        return condutorRepository.save(condutor);
    }


}


