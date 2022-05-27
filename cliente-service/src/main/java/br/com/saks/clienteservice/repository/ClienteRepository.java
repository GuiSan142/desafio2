
package br.com.saks.clienteservice.repository;

import br.com.saks.clienteservice.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
    
}
