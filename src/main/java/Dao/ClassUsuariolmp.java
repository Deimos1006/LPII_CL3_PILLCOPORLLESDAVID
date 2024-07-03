package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.lUsuario;
import model.TblUsuariocl3;


public class ClassUsuariolmp implements lUsuario{

	@Override
	public void RegistrarUsuario(TblUsuariocl3 usuario) {
		//establecer conexion con la unidad de persistencia.....
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_PILLCOPORLLESDAVID");
				//permite gestionar entidades
				EntityManager em=fabr.createEntityManager();
				//iniciar transmiciones
				em.getTransaction().begin();
				//registramos
				em.persist(usuario);
				//emitimos mensaje por consola
			
				//confirmamos
				em.getTransaction().commit();
				//cerramos la transaccion
				em.close();
	}

	@Override
	public void ActualizarUsuario(TblUsuariocl3 usuario) {
		//establecemos conexion con la unidad de persistencia
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_PILLCOPORLLESDAVID");
				//permite gestionar entidades
				EntityManager em=fabr.createEntityManager();
				//Iniciar transaccion
				em.getTransaction().begin();
				//actualizamos
				em.persist(usuario);
				//emitimos mensaje por consola
			
				//confirmamos
				em.getTransaction().commit();
				//cerramos la transaccion
				em.close();
		
	}

	@Override
	public void EliminarUsuario(TblUsuariocl3 usuario) {
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_PILLCOPORLLESDAVID");
		//permite gestionar entidades
		EntityManager em=fabr.createEntityManager();
		//Iniciar transaccion
		em.getTransaction().begin();
		//Recuperamos el codigo eliminar
		TblUsuariocl3 elim=em.merge(usuario);
		//Procedemos a eliminar el registro
		em.remove(elim);
		//emitimos mensaje por consola
		System.out.println("usuario eliminado de la base de datos");
		//confirmamos
		em.getTransaction().commit();
		//cerramos
		em.close();
		
	}

	@Override
	public TblUsuariocl3 BuscarUsuario(TblUsuariocl3 usuario) {
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_PILLCOPORLLESDAVID");
		EntityManager em=fabr.createEntityManager();
		em.getTransaction().begin();
		//recuperamos el codigo
		TblUsuariocl3 buscusuario=em.find(TblUsuariocl3.class, usuario.getIdusuariocl3());
		em.getTransaction().commit();
		em.close();
		return buscusuario;
	}

	@Override
	public List<TblUsuariocl3> ListadoUsuario() {
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_PILLCOPORLLESDAVID");
		EntityManager em=fabr.createEntityManager();
		em.getTransaction().begin();
		List<TblUsuariocl3>listadousuario=em.createQuery("select c from TblUsuariocl3 c", TblUsuariocl3.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listadousuario;
	}



}
