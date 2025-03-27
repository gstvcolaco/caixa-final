package com.gstvcolaco.caixa.repository;

import com.gstvcolaco.caixa.model.Caixa;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CaixaRepository extends JpaRepository<Caixa, Integer>{
    @Query("select m from Localiza m where m.data between :di and :df order by m.data")
    public List<Caixa> listaLocaliza(@Param("di") Date dataInicial, @Param("df") Date dataFinal);
}
