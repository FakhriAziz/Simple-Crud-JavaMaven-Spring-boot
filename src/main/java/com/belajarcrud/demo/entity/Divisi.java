/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarcrud.demo.entity;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.Data;

/**
 *
 * @author Edric
 */
@Data
@Entity
public class Divisi {

    @Id
    @SequenceGenerator(name = "my_seq", sequenceName = "GENNOMORDIVISI", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @Basic(optional = false)
    @Column(name = "NOMOR")
    private Integer nomor;
    @Basic(optional = false)
    @Column(name = "KODE")
    private String kode;
    @Column(name = "KETERANGAN")
    private String keterangan;

}
