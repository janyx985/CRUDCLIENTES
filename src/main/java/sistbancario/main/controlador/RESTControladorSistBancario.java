package sistbancario.main.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sistbancario.main.dao.IClienteDAO;
import sistbancario.main.modelo.Cliente;

@RestController
public class RESTControladorSistBancario {

	@Autowired
	IClienteDAO clienteDao;
	
	//-------------------------------lista todos los clientes de la tabla-----------------
	@GetMapping("/clientes")
	public List<Cliente> getListaClientes(){
		return this.clienteDao.findAll();
	}
	
	//------------------retorna el registro del cliente {rut}------------------------------
	@GetMapping("/clientes/{rut}")
	public Cliente getCliente(@PathVariable String rut) {
		return this.clienteDao.findById(rut).orElse(new Cliente());
	}
	
	//--------Insertar nuevo cliente si este no existe en el registro----------------------
	@PostMapping("/clientes")
	public boolean addClienteNuevo(@RequestBody Cliente nuevo) {
		if(!this.clienteDao.existsById(nuevo.getRut())) {
			this.clienteDao.save(nuevo);
			return true;
		}
		return false;
	}
	
	//----------------------modifica los datos del cliente {rut}----------------------------
	@PutMapping("/clientes")
	public boolean modifyCliente(@RequestBody Cliente modificar) {
		if(this.clienteDao.existsById(modificar.getRut())) {
			this.clienteDao.save(modificar);
			return true;
		}
		return false;
	}
	
	//-------elimina un cliente, o todos los clientes al ingresar el 99999999-9-------------- 
	@DeleteMapping("/clientes/{rut}")
	public boolean deleteCliente(@PathVariable String rut) {
		if(rut.equals("99999999-9")) {
			if(this.clienteDao.count()==0)
				return false;
			else {
				this.clienteDao.deleteAll();
				return true;
			}	
		}		
		if(this.clienteDao.existsById(rut)) {
			this.clienteDao.deleteById(rut);
			return !this.clienteDao.existsById(rut);
		}
		return false;
	}
	
	
}
