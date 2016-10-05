/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author campitos
 */
@RestController
public class ControladorMensajes {
    
    @Autowired RepositorioMensajes repo;
    
    @RequestMapping("/mensaje")
    String guardarMensaje(){
        repo.save(new Mensaje("primero","MI primer mensaje"));
        return "Mensaje guardado z";
    }
    
}
