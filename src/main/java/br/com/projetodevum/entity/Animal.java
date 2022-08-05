package br.com.projetodevum.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
    //private boolean genero;
    //private String obs;

    //@Temporal(TemporalType.DATE)
    //private Date dataNasc;

    @ManyToMany()//fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "animais")
    //@JoinTable(name="cliente_animal",
    //            uniqueConstraints = @UniqueConstraint(columnNames = {"animal_id", "cliente_id"}),
    //            joinColumns = @JoinColumn(name="animal_id"),
    //            inverseJoinColumns = @JoinColumn(name="cliente_id"))
    private Set<Cliente> clientes = new HashSet<>();
}