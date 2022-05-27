
package br.com.saks.administradorservice.repository;

import br.com.saks.administradorservice.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador,Long>{
    
}
