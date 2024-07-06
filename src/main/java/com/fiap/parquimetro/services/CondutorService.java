package com.fiap.parquimetro.services;

import com.fiap.parquimetro.entities.Condutor;
import com.fiap.parquimetro.repositories.CondutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondutorService {

    @Autowired
    private CondutorRepository condutorRepository;

    public List<Condutor> listarTodos() {
        return this.condutorRepository.findAll();
    }

    public Condutor cadastroCondutor(Condutor condutor) {
        return this.condutorRepository.save(condutor);
    }

    public Condutor listarCondutorPorId(Long idCondutor) {
        Optional<Condutor> condutorOptional = this.condutorRepository.findById(idCondutor);
        return condutorOptional.orElse(null);
    }

}


