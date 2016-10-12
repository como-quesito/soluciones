/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author campitos
 */
@RestController
public class ControladorMensajes {
    
    @Autowired RepositorioMensajes repo;
 @CrossOrigin
    @RequestMapping(value="/mensaje-mongo", method=RequestMethod.GET, headers={"Accept=application/json"})
    @ResponseBody String leerTodos()throws Exception{
        ObjectMapper maper=new ObjectMapper();
        System.out.println("ya");
         return maper.writeValueAsString(repo.findAll());


    }
    
    
    @CrossOrigin
    @RequestMapping(value="/mensaje-mongo",
            method=RequestMethod.POST, headers={"Accept=application/json"})
    @ResponseBody String guardarRest(@RequestBody String json)throws Exception{
        Mensaje mm=new  Mensaje();

        System.out.println("SE ACTIVO GUARDAR CON MONGO con el sig JSON:"+json);
        ObjectMapper maper=new ObjectMapper();
     Mensaje mensa=   maper.readValue(json, Mensaje.class);
    String titulo= mensa.getTitulo();
    String cuerpo=mensa.getCuerpo();
    System.out.println("TITULO:"+mensa.getTitulo()+" CUERPO:"+mensa.getCuerpo());

    //Preparamos la respuesta
    Map map = new HashMap();
 map.put("success", true);
 //Si hubiera un error, aqui enviamos en el map en evz de tru false y agergamos el put de error con el
 //error que desees
 //map.put("errors", "File not found in the specified path.");
       // mm.setTitulo(titulo);
      //  mm.setCuerpo(cuerpo);
       /// servicio.agregarMensaje(mm);
         return maper.writeValueAsString(map);


    }

}
