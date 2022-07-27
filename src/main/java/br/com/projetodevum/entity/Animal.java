package br.com.projetodevum.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nomeAnimal;
    private String raca;
    private boolean genero;
    private String obs;

    @Temporal(TemporalType.DATE)
    private Date dataNasc;

    @ManyToMany(mappedBy = "animais", cascade= CascadeType.ALL)
    private List<Cliente> clientes;
}
