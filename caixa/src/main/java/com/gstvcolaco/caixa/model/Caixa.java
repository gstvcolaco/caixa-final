package com.gstvcolaco.caixa.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
@Entity
public class Caixa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date data = new Date();
    private String descricao;
    private double valor;
    private int tipo;
    public Integer getId() {
        return id;
    }

    public String getDataFormatada(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(data);
    }

    public void setDataFormatada(String dataFormatada){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            data = sdf.parse(dataFormatada);
        }catch(Exception e){
            System.out.println("Erro de formato de data");
        }
    }

    public String getDataFormatadaBR(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    public String getValorFormatado(){
        DecimalFormat df = new DecimalFormat("0.00");
        return "R$" + df.format(valor);
    }

    public String getTipoText(){
        return tipo== 0 ?"Saída":"Entrada";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int isTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

}
