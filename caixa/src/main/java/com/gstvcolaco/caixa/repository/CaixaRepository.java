package com.gstvcolaco.caixa.repository;

import com.gstvcolaco.caixa.model.Caixa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CaixaRepository extends JpaRepository<Caixa, Integer>{
    List<Caixa> findByDataBetween(Date dataInicial, Date dataFinal);
}
