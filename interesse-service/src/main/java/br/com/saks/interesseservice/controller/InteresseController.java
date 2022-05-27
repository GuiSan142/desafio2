package br.com.saks.interesseservice.controller;
import br.com.saks.interesseservice.repository.InteresseRepository;
import br.com.saks.interesseservice.model.Interesse;
import br.com.saks.interesseservice.model.InteresseIdentity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interesses")
public class InteresseController {
    
    @Autowired
    private InteresseRepository interesseRepository;
    
    @GetMapping
    public List<Interesse> listarTodos() {
        return interesseRepository.findAll();
    }
    
    @GetMapping(value="/{idCliente}")
    public List<Interesse>listarpeloIdCliente(@PathVariable Long idCliente){
        return interesseRepository.findByInteresseIdentityIdCliente(idCliente);
    }
    
    @GetMapping(value="/{idImovel}")
    public List<Interesse>listarpeloIdImovel(@PathVariable Long idImovel){
        return interesseRepository.findByInteresseIdentityIdImovel(idImovel);
    }
    
    @PostMapping
    public Interesse adicionar(@RequestBody Interesse Interesse) {
        return interesseRepository.save(Interesse);
    }
    
    @GetMapping(value = "/{idImovel}/{idCliente}")
    public Optional<Interesse> findByInteresseIdentityIdImovelIdCliente(@PathVariable Long idImovel, @PathVariable Long idCliente){
        final InteresseIdentity identity = new InteresseIdentity(idCliente,idImovel);
        return interesseRepository.findById(identity);
    } 
    
    @DeleteMapping(value="/{idImovel}/{idCliente}")
    public ResponseEntity deletar(@PathVariable Long idImovel, @PathVariable Long idCliente) {
        final InteresseIdentity identity = new InteresseIdentity(idCliente,idImovel);
        return interesseRepository.findById(identity)
                .map(record-> {
                    interesseRepository.deleteById(identity);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
