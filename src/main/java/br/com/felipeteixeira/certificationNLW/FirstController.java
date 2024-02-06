package br.com.felipeteixeira.certificationNLW;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Essa anotação define uma rest controller. Portanto estamos trabalhando com JSON
// Um API rest
@RestController
@RequestMapping("/firstController")
public class FirstController {
    
    @GetMapping("/returnFirstController")
    public Usuario returnFirstController() {
        // Em versões atuais, o tipo da variável que vai referenciar o objeto
        // Não é mais obrigatório, podendo ser colocado var
        // Notação antiga: 
        // Usuario usuario = new Usuario("Felipe", 24);
        var usuario = new Usuario("Felipe", 24);
        return usuario;
    }
    
    // Define uma classe com métodos pré-definidos
    record Usuario (String nome, int idade) {}

}