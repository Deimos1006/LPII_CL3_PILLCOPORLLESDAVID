package Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.TblProductocl3;
import Interfaces.lProducto;

public class ClassProductolmp implements lProducto {

    @Override
    public void RegistrarProducto(TblProductocl3 producto) {
        EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_DAVIDPILLCOPORLLES");
        EntityManager em = fabr.createEntityManager();
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void ActualizarProducto(TblProductocl3 producto) {
        EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_DAVIDPILLCOPORLLES");
        EntityManager em = fabr.createEntityManager();
        em.getTransaction().begin();
        em.merge(producto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void EliminarProducto(TblProductocl3 producto) {
        EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_DAVIDPILLCOPORLLES");
        EntityManager em = fabr.createEntityManager();
        em.getTransaction().begin();
        TblProductocl3 elim = em.merge(producto);
        em.remove(elim);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public TblProductocl3 BuscarProducto(TblProductocl3 producto) {
        EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_DAVIDPILLCOPORLLES");
        EntityManager em = fabr.createEntityManager();
        em.getTransaction().begin();
        TblProductocl3 buscproducto = em.find(TblProductocl3.class, producto.getIdproductoscl3());
        em.getTransaction().commit();
        em.close();
        return buscproducto;
    }

    @Override
    public List<TblProductocl3> ListadoProducto() {
        EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_DAVIDPILLCOPORLLES");
        EntityManager em = fabr.createEntityManager();
        em.getTransaction().begin();
        List<TblProductocl3> listadoproducto = em.createQuery("SELECT c FROM TblProductocl3 c", TblProductocl3.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return listadoproducto;
    }
}

