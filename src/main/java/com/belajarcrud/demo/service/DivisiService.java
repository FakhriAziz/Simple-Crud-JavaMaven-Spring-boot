/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarcrud.demo.service;

import com.belajarcrud.demo.repository.DivisiRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.belajarcrud.demo.entity.Divisi;
import java.util.List;

/**
 *
 * @author Edric
 */
@Service
public class DivisiService {

    @Autowired
    private DivisiRepo divisiRepo;

    public Divisi save(Divisi divisi) {
        divisiRepo.save(divisi);
        return divisi;
    }

    public List<Divisi> getall() {
        return divisiRepo.findAll();
    }

    public void delete(int nomor) {
        Divisi divisi = divisiRepo.findById(nomor).get();
        divisiRepo.delete(divisi);
    }

    public Divisi findById(int nomor) {
        Divisi divisi = divisiRepo.findById(nomor).get();
        return divisi;
    }

    public Divisi findByKodeOrKeterangan(String kode, String keterangan) {
        Divisi divisi = divisiRepo.findByKodeOrKeterangan(kode, keterangan).orElse(null);
        return divisi;
    }
}
