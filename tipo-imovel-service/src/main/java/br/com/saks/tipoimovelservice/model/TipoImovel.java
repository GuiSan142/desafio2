package br.com.saks.tipoimovelservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class TipoImovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Column(nullable=false)
    private String nome;
    
    @Transient
    Imovel imovel[];

    public Imovel[] getImovel() {
        return imovel;
    }

    public void setImovel(Imovel[] imovel) {
        this.imovel = imovel;
    }
}
