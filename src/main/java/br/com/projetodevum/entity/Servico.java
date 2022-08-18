package br.com.projetodevum.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servico implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String servicoRealizado;
    private String produtoUtilizado;
    private int valor;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    //@Temporal(TemporalType.DATE)
    private Calendar data;

    @OneToOne
    private Cliente cliente;
    //@OneToOne
    //private Animal animal;
}
