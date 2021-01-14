/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarcrud.demo.validation;
import com.belajarcrud.demo.service.DivisiService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.belajarcrud.demo.dto.DivisiDto;
/**
 *
 * @author Edric
 */
public class DivisiUniqueValidator implements ConstraintValidator<DivisiUnique, DivisiDto>{

    @Autowired
    DivisiService divisiService;
    @Override
    public boolean isValid(DivisiDto t, ConstraintValidatorContext cvc) {
        return divisiService.findByKodeOrKeterangan(t.getKode(), t.getKeterangan()) == null;
    }
    
}
