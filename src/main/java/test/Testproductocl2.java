package test;

import java.util.List; 

import dao.Classproductoimp;

import model.TblProductocl3;

public class Testproductocl2 {

	public static void main(String[] args) {
		TblProductocl3 prod=new TblProductocl3();
		Classproductoimp crud=new Classproductoimp();
		
		/*prod.setNombrecl2("Arroz");
		prod.setPrecioventacl2("10");
		prod.setPreciocompcl2("12");
		prod.setEstadocl2("vig");
		prod.setDescripcl2("oferta");
		
		crud.RegistrarProducto(prod);*/
		
		List<TblProductocl3> listadoproducto=crud.ListadoProducto();
		
		for(TblProductocl3 lis:listadoproducto){
			
			//imprimimos por pantalla
			System.out.println("nombre "+lis.getNombrecl3()+
					" precio venta "+lis.getPrecioventacl3()+" preciocomp "+lis.getPreciocompcl3()
					+" estado "+lis.getEstadocl3()+" descripcion "+lis.getDescripcl3());
		}

	}

}
