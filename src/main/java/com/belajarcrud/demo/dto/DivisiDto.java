/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarcrud.demo.dto;

import com.belajarcrud.demo.validation.DivisiUnique;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Edric
 */
//@DivisiUnique(message = "Kode harus unique")
@Data
public class DivisiDto {
    @NotEmpty
    private String kode;
    @NotEmpty
    private String keterangan;
}
