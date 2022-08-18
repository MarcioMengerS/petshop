package br.com.projetodevum.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Animal implements Serializable{

    private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeAnimal;
    private String raca;
    private boolean genero;
    private String obs;

    @Temporal(TemporalType.DATE)
    private Date dataNasc;

    //@ManyToMany()
    //private Set<Cliente> clientes = new HashSet<>();
}