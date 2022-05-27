
package br.com.saks.interesseservice.repository;

import br.com.saks.interesseservice.model.Interesse;
import br.com.saks.interesseservice.model.InteresseIdentity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InteresseRepository extends JpaRepository<Interesse,InteresseIdentity>{
    List<Interesse>findByInteresseIdentityIdCliente(Long idCliente);
    List<Interesse>findByInteresseIdentityIdImovel(Long idImovel);
}
