package com.service.serralheria.models;

import com.sun.istack.NotNull;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @Column
    private String nome;

    @NotNull
    @Column
    private String telefone;

    @NotNull
    @Column
    private String tipoServico;

    @NotNull
    @Column
    private String bairro;

    @NotNull
    @Column
    private String endereco;

    @NotNull
    @Column
    private double valorServico;

    @Column
    private Date data;

    @Column
    private String possuiNota = "Não";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPossuiNota() {
        return possuiNota;
    }

    public void setPossuiNota(String possuiNota) {
        this.possuiNota = possuiNota;
    }
}
