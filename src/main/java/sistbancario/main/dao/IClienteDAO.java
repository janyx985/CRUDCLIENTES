package sistbancario.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistbancario.main.modelo.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, String>{

}
