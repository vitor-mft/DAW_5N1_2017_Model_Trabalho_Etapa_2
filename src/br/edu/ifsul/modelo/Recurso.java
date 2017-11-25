
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
/**
 * @author Vitor Mateus T
 */
@Entity
@Table(name = "recurso") //define o nome da tabela
@Inheritance(strategy = InheritanceType.JOINED)
public class Recurso implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_recurso", sequenceName = "seq_recurso_id", allocationSize = 1) //criando uma sequencia
    @GeneratedValue(generator = "seq_recurso", strategy = GenerationType.SEQUENCE) //uma sequencia pra cada tabela
    private Integer id;
    
    @NotNull(message = "A descrição deve ser informada")
    @Length(max = 50, message = "A descrição não pode ter mais que {max} caracteres")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", length = 50, nullable = false) //definindo a coluna da tabela nome
    private String descricao;    
    @ManyToMany
    @JoinTable(name = "condominio_recursos",
            joinColumns
            = @JoinColumn(name = "recurso", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false))
    private List<Condominio> rCondominio = new ArrayList<>();

    public List<Condominio> getrCondominio() {
        return rCondominio;
    }

    public void setrCondominio(List<Condominio> rCondominio) {
        this.rCondominio = rCondominio;
    }
 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recurso other = (Recurso) obj;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Recurso() {
    }
    
}