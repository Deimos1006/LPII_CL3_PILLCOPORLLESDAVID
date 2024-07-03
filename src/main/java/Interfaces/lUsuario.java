package Interfaces;

import java.util.List;

import model.TblUsuariocl3;

public interface lUsuario {
	
	public void RegistrarUsuario (TblUsuariocl3 usuario);
	public void ActualizarUsuario (TblUsuariocl3 usuario);
	public void EliminarUsuario (TblUsuariocl3 usuario);
	public TblUsuariocl3 BuscarUsuario (TblUsuariocl3 usuario);
	public List<TblUsuariocl3> ListadoUsuario();

}
