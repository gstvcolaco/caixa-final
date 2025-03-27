package com.gstvcolaco.caixa.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Localiza {
    private Date dataInicial = new Date();
    private Date dataFinal = new Date();
    private boolean tipo;

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

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public boolean getTipo() {
        return tipo;
    }
}
