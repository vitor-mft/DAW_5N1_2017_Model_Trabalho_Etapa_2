/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @author Vitor Mateus T
 */
@Entity
@Table(name = "locatario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Locatario extends Pessoa implements Serializable {

    @NotNull(message = "A renda deve ser informada")
    @Column(name = "renda", nullable = false,
            columnDefinition = "numeric(12,2)")
    Double renda;
    @NotNull(message = "O local  deve ser informado")
    @Length(max = 50, message = "O local  não pode ter mais que {max} caracteres")
    @NotBlank(message = "O local  não pode ser em branco")
    @Column(name = "localtrabalho", length = 50, nullable = false)
    String localTrabalho;
    @NotNull(message = "O telefone de trabalho deve ser informado")
    @Length(max = 15, message = "O telefone de trabalho não pode ter mais que {max} caracteres")
    @NotBlank(message = "O telefone de trabalho não pode ser em branco")
    @Column(name = "telefonetrabalho", length = 15, nullable = false)
    String telefoneTrabalho;

    public Locatario() {
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }
}
