package TestEntidades;

import Dao.ClassProductolmp;
import model.TblProductocl3;

public class TestEntidadProducto {
	public static void main(String[] args){
		TblProductocl3 producto = new TblProductocl3();
		ClassProductolmp crud = new ClassProductolmp ();
		producto.setNombrecl3("refrigeradora");
		producto.setPrecioventacl3(2324);
		producto.setPreciocompcl3(2000);
		producto.setEstadocl3("new");
		producto.setDescripcl3("te encantara");
		crud.RegistrarProducto(producto);
		
		
	}
}
