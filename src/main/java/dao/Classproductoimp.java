package dao;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.Iproducto;

import model.TblProductocl3;

public class Classproductoimp implements Iproducto {

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		//establecer conexion con la unidad de persistencia...
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("evaluacioncl2");
			    //permite gestionar entidades
				EntityManager em=fabr.createEntityManager();
				//iniciar transaccion
				em.getTransaction().begin();
				//registramos
				em.persist(producto);
				//emitimos mensaje por consola
				System.out.println("producto registrado en la BD correctamente");
				//confirmamos
				em.getTransaction().commit();
				//cerramos la transaccion
				em.close();
		
	}

	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
		//establecemos conexion con la unidad de persistencia...
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("evaluacioncl2");
				//permite gestionar entidades
				EntityManager em=fabr.createEntityManager();
				//iniciar transaccion
				em.getTransaction().begin();
				//actualizamos
				em.merge(producto);
				//comfirmamos 
				em.getTransaction().commit();
				//cerramos
				em.close();
				
		
	}

	@Override
	public void EliminarProducto(TblProductocl3 producto) {
		//establecemos la conexion con unidad de persistencia.
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("evaluacioncl2");
				//gestionar las entidades
				EntityManager em=fabr.createEntityManager();
				//iniciamos la transaccion
				em.getTransaction().begin();
				//recuperamos el codigo a eliminar
				TblProductocl3 elim=em.merge(producto);
				//procedemos a eliminar el registro
				em.remove(elim);
				//emitimos mensaje por consola
				System.out.println("producto eliminado de la base de datos");
				//confirmamos
				em.getTransaction().commit();
				//cerramos
				em.close();
		
	}

	@Override
	public TblProductocl3 BuscarProducto(TblProductocl3 producto) {
		//establecemos la conexion con la unidad de persistencia..
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("evaluacioncl2");
				//gestionar las entidads
				EntityManager em=fabr.createEntityManager();
				//iniciamos la transaccion
				em.getTransaction().begin();
				//recuperamos el codigo a buscar
				TblProductocl3 buscliente=em.find(TblProductocl3.class,producto.getIdproductocl3());
				//confirmamos 
				em.getTransaction().commit();
				//cerramos
				em.close();
				return buscliente;
	}

	@Override
	public List<TblProductocl3> ListadoProducto() {
		//establecemos la conexion con la unidad de persistencia..
        EntityManagerFactory fabr=Persistence.createEntityManagerFactory("evaluacioncl2");
        //gestionamos las entidads
        EntityManager em=fabr.createEntityManager();
        //iniciamos la transaccion
        em.getTransaction().begin();
        //recuperamos los clientes  de la base de datos
        //***********utilizando jpql
        List<TblProductocl3> listadoproducto=em.createQuery("select c from TblProductocl2 c",TblProductocl3.class).getResultList();
       // List<TblProductocl2> listadoproducto=em.createQuery("select c from TblProducto c",TblProductocl2.class).getResultList();
        //confirmamos la transaccion
        em.getTransaction().commit();
        //cerramos
        em.close();
		return listadoproducto;
	}

}
