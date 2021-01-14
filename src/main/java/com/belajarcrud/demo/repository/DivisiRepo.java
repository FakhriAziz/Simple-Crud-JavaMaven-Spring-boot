/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarcrud.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.belajarcrud.demo.entity.Divisi;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author Edric
 */
@Repository
public interface DivisiRepo extends JpaRepository<Divisi, Integer>{
    Optional<Divisi> findByKodeOrKeterangan(@Param("kode") String kode, @Param("keterangan") String keterangan);
}
