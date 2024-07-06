package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.entities.Condutor;
import com.fiap.parquimetro.repositories.CondutorRepository;
import com.fiap.parquimetro.services.CondutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/condutor")
public class CondutorController {
    @Autowired
    private CondutorService condutorService;
    @Autowired
    private final CondutorRepository condutorRepository;

    public CondutorController(CondutorRepository condutorRepository) {
        this.condutorRepository = condutorRepository;
    }

    @GetMapping
    public ResponseEntity<List<Condutor>> listarTodos() {
        List<Condutor> condutors = this.condutorService.listarTodos();
        return ResponseEntity.ok(condutors);
    }

    @PostMapping
    public ResponseEntity<Condutor> cadastrarCondutor(@RequestBody Condutor condutor) {
        if (condutor.getEndereco() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        Condutor cadastrarCondutor = condutorService.cadastrarCondutor(condutor);

        return ResponseEntity.ok(cadastrarCondutor);
    }

}
