/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author campitos
 */
@SpringComponent
@UIScope
public interface RepositorioMensajes extends MongoRepository<Mensaje,String>{
    List<Mensaje> findByTitulo(String titulo);
}
