package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.entities.Condutor;
import com.fiap.parquimetro.repositories.CondutorRepository;
import com.fiap.parquimetro.services.CondutorService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary= "Lista todos os condutores", tags = "Condutor")
    @GetMapping
    public ResponseEntity<List<Condutor>> listarTodos() {
        List<Condutor> condutors = this.condutorService.listarTodos();
        return ResponseEntity.ok(condutors);
    }
    @Operation(summary= "Cadastra Novo Condutor", tags = "Condutor")
    @PostMapping
    public ResponseEntity<Condutor> cadastrarCondutor(@RequestBody Condutor condutor) {
        if (condutor.getEndereco() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        Condutor cadastrarCondutor = condutorService.cadastrarCondutor(condutor);

        return ResponseEntity.ok(cadastrarCondutor);
    }

}
