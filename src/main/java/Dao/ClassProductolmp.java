package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.lProducto;
import model.TblProductocl3;

public class ClassProductolmp implements lProducto{

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		//establecer conexion con la unidad de persistencia.....
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_PILLCOPORLLESDAVID");
				//permite gestionar entidades
				EntityManager em=fabr.createEntityManager();
				//iniciar transmiciones
				em.getTransaction().begin();
				//registramos
				em.persist(producto);
				//emitimos mensaje por consola
			
				//confirmamos
				em.getTransaction().commit();
				//cerramos la transaccion
				em.close();
		
	}//fin del metodo registrar

	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
		//establecemos conexion con la unidad de persistencia
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_PILLCOPORLLESDAVID");
				//permite gestionar entidades
				EntityManager em=fabr.createEntityManager();
				//Iniciar transaccion
				em.getTransaction().begin();
				//actualizamos
				em.persist(producto);
				//emitimos mensaje por consola
			
				//confirmamos
				em.getTransaction().commit();
				//cerramos la transaccion
				em.close();
		
	}//fin del metodo actualizar

	@Override
	public void EliminarProducto(TblProductocl3 producto) {
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_PILLCOPORLLESDAVID");
		//permite gestionar entidades
		EntityManager em=fabr.createEntityManager();
		//Iniciar transaccion
		em.getTransaction().begin();
		//Recuperamos el codigo eliminar
		TblProductocl3 elim=em.merge(producto);
		//Procedemos a eliminar el registro
		em.remove(elim);
		//emitimos mensaje por consola
		System.out.println("producto eliminado de la base de datos");
		//confirmamos
		em.getTransaction().commit();
		//cerramos
		em.close();
		
	}//fin del metodo eliminar

	@Override
	public TblProductocl3 BuscarProducto(TblProductocl3 producto) {
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_PILLCOPORLLESDAVID");
		EntityManager em=fabr.createEntityManager();
		em.getTransaction().begin();
		//recuperamos el codigo
		TblProductocl3 buscpro=em.find(TblProductocl3.class, producto.getIdproductoscl3());
		em.getTransaction().commit();
		em.close();
		return buscpro;
	}//fin del metodo buscar

	@Override
	public List<TblProductocl3> ListadoProducto() {
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_PILLCOPORLLESDAVID");
		EntityManager em=fabr.createEntityManager();
		em.getTransaction().begin();
		List<TblProductocl3>listadoproducto=em.createQuery("select c from TblProductocl2 c", TblProductocl3.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listadoproducto;
	}//fin del metodo listar

}
