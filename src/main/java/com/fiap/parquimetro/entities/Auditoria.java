package com.fiap.parquimetro.entities;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class Auditoria {

    private LocalDateTime dataDeInclusao;

    private LocalDateTime dataDeAlteracao;

    @PrePersist
    protected void onCreate() {
            this.dataDeInclusao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataDeAlteracao = LocalDateTime.now();
    }
}
