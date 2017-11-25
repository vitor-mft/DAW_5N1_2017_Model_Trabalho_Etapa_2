
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 * @author Vitor Mateus T
 */
@Entity
@Table(name = "mensalidade")
public class Mensalidade implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_mensalidade", sequenceName = "seq_mensalidade_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_mensalidade", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O valor deve ser informado")
    @Min(0)
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valor;
    
    @NotNull(message = "O vencimento deve ser informado")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "vencimento", nullable = false)
    private Calendar vencimento;
    
    @Column(name = "valor_pagamento", nullable = true, columnDefinition = "numeric(10,2)")
    private Double valorPagamento;   
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_pagamento", nullable = true)    
    private Calendar dataPagamento;
    
    @NotNull(message = "O aluguel deve ser informado")
    @ManyToOne
    @JoinColumn(name = "aluguel", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_aluguel_id")
    private Aluguel aluguel;

    public Mensalidade() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mensalidade other = (Mensalidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
    
    
}
