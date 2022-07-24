package br.com.projetodevum.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
//adicionado implements serializable
public class Telefone implements Serializable{
    //adicionado constante serialVersionUID
    private static final long serialVersionUID =1L;

    @Id
    //utilização de AUTO para não sobrescrever telefone na tabela
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipo;
    private byte ddd;
    private int numero;

    @ManyToOne
    private Cliente cliente;
}