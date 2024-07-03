package TestEntidades;

import Dao.ClassUsuariolmp;
import model.TblUsuariocl3;

public class TestEntidadUsuario {
	
	public static void main(String[] args){
		TblUsuariocl3 usuario = new TblUsuariocl3();
		ClassUsuariolmp crud = new ClassUsuariolmp ();
		usuario.setUsuariocl3("david pillco");
		usuario.setPasswordcl3("555corriente");
		crud.RegistrarUsuario(usuario);
	}

}
