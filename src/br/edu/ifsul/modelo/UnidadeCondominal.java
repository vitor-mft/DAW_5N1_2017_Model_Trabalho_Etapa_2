
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;
/**
 * @author Vitor Mateus T
 */
@Entity
@Table(name = "unidade_condominal")
public class UnidadeCondominal implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_unidade_condominal", sequenceName = "seq_unidade_condominal_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_unidade_condominal", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O numero deve ser informado")
    @NotBlank(message = "O numero não pode ser em branco")
    @Column(name = "numero", length = 50, nullable = false)
    private String numero;
    
    //Descrição da unidade deve ser SEM LIMITE DE CARACTERES
    
    @NotNull(message = "A descrição deve ser informada")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", nullable = false,columnDefinition = "text")
    private String descricao;
    
    @NotNull(message = "A área deve ser informada")
    @Min(0)
    @Column(name = "area", nullable = false, columnDefinition = "numeric(10,2)")
    private Double area;
    
    @NotNull(message = "O número do quarto deve ser informado")
    @Min(0)
    @Column(name = "numero_quarto", nullable = false)
    private Integer numeroQuarto;
    
    @NotNull(message = "O condominio deve ser informado")
    @ManyToOne
    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_condominio_id")
    private Condominio condominio;
    
    @NotNull(message = "O proprietário deve ser informado")
    @ManyToOne
    @JoinColumn(name = "proprietario", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_proprietario_id")
    private Pessoa proprietario;

    public UnidadeCondominal() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
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
        final UnidadeCondominal other = (UnidadeCondominal) obj;
        if (this.id != other.id) {
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }
    
}
