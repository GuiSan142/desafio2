package br.com.saks.imovelservice.controller; 
import br.com.saks.imovelservice.Repository.ImovelRepository;
import br.com.saks.imovelservice.Service.TipoImovelService;
import br.com.saks.imovelservice.model.Imovel;
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
@RequestMapping("/imoveis")
public class ImovelController {
    
    @Autowired
    private ImovelRepository imovelRepository;
    
    @Autowired
    private TipoImovelService tipoImovelService;
    
    
    @GetMapping
    public List<Imovel> listarTodos() {
        return imovelRepository.findAll();
    }
    
    @GetMapping(value="/{id}")
    public Imovel listarPeloId(@PathVariable Long id) {
        Optional<Imovel>imovelResponse = imovelRepository.findById(id);
        Imovel imovel = imovelResponse.get();
        imovel.setTipoImovel(tipoImovelService.listarPeloId(imovel.getIdTipoImovel()));
        return imovel;
    }
    
    @GetMapping(value="/tipoImoveis/{idTipoImovel}")
    public List<Imovel> listarTipoImovel(@PathVariable Long idTipoImovel){
        List<Imovel> listaImovel = new ArrayList<Imovel>();
        for(Imovel imovel :imovelRepository.findAll()){
            if(imovel.getIdTipoImovel().equals(idTipoImovel) && imovel.getStatus()==1){
                listaImovel.add(imovel);
            }
        }
        return listaImovel;
    }
    
    @PostMapping
    public Imovel adicionar(@RequestBody Imovel Imovel) {
        return imovelRepository.save(Imovel);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Imovel Imovel) {
        return imovelRepository.findById(id)
                .map(record -> {
                    record.setIdTipoImovel(Imovel.getIdTipoImovel());
                    record.setTitulo(Imovel.getTitulo());
                    record.setDescricao(Imovel.getDescricao());
                    record.setDataCriacao(Imovel.getDataCriacao());
                    record.setValor(Imovel.getValor());
                    record.setStatus(Imovel.getStatus());
                    Imovel imovelUpdated = imovelRepository.save(record);
                    return ResponseEntity.ok().body(imovelUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return imovelRepository.findById(id)
                .map(record-> {
                    imovelRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
