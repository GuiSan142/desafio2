package br.com.saks.tipoimovelservice.service;

import br.com.saks.tipoimovelservice.model.Imovel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="imovel-service")
public interface ImovelService {
    @GetMapping(value="/imoveis/tipoImoveis/{idTipoImovel}")
    Imovel[] listarPeloTipoImovel(@PathVariable("idTipoImovel")Long idTipoImovel);
}
