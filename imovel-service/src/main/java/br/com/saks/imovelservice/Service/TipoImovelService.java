package br.com.saks.imovelservice.Service;

import br.com.saks.imovelservice.model.TipoImovel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="tipo-imovel-service")
public interface TipoImovelService {
    @GetMapping(value = "/tipoImoveis/{idTipoImovel}")
    TipoImovel listarPeloId (@PathVariable("idTipoImovel") Long idTipoImovel);
}
