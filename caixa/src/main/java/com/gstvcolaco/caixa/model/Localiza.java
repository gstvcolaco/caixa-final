package com.gstvcolaco.caixa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.SimpleDateFormat;
import java.util.Date;
@Entity
public class Localiza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dataInicial = new Date();
    private Date dataFinal = new Date();

    public String getDataFormatadaFinal(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dataFinal);
    }

    public void setDataFormatadaFinal(String dataFormatada){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            dataFinal = sdf.parse(dataFormatada);
        }catch(Exception e){
            System.out.println("Erro de formato de data");
        }
    }

    public String getDataFormatadaBRFinal(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataFinal);
    }

    public String getDataFormatadaInicial(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dataInicial);
    }

    public void setDataFormatadaInicial(String dataFormatada){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            dataInicial = sdf.parse(dataFormatada);
        }catch(Exception e){
            System.out.println("Erro de formato de data");
        }
    }

    public String getDataFormatadaBRInicial(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataInicial);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

}
