package com.example.miapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HolaController {

    // Endpoint raíz: http://localhost:8080/
    @GetMapping("/")
    public Map<String, String> inicio() {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "API de Spring Boot desplegada en Render");
        respuesta.put("estado", "activo");
        return respuesta;
    }

    // Endpoint de saludo: http://localhost:8080/api/saludo?nombre=Juan
    @GetMapping("/api/saludo")
    public Map<String, String> saludo(@RequestParam(defaultValue = "Mundo") String nombre) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("saludo", "¡Hola, " + nombre + "!");
        return respuesta;
    }

    // Endpoint con parámetro de ruta: http://localhost:8080/api/suma/5/3
    @GetMapping("/api/suma/{a}/{b}")
    public Map<String, Object> suma(@PathVariable int a, @PathVariable int b) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("a", a);
        respuesta.put("b", b);
        respuesta.put("resultado", a + b);
        return respuesta;
    }
}
