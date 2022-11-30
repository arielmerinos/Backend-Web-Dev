package com.HelloWorldSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * La anotación controller sirve para exponer endpoints (siempre, todos los controladores)
 *
 * La Segunda parte es un response body
 */
public class CtrlHelloWordl {

    /**
     * Necitamos agregar la notación para saber que es un método
     * @return
     */
    @GetMapping("/hello")
    /**
     * Get mapping puede o no tener parámetros, es decir podría quedar como por defecto al acceder al inicio de la app
     */
    public String HelloWorld(){
        return "Hola mundo desde Sprin";
    }

}
