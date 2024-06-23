package test;

import java.util.List;

import dao.Classproductoimp;

import model.TblProductocl2;

public class Testproductocl2 {

	public static void main(String[] args) {
		TblProductocl2 prod=new TblProductocl2();
		Classproductoimp crud=new Classproductoimp();
		
		/*prod.setNombrecl2("Arroz");
		prod.setPrecioventacl2("10");
		prod.setPreciocompcl2("12");
		prod.setEstadocl2("vig");
		prod.setDescripcl2("oferta");
		
		crud.RegistrarProducto(prod);*/
		
		List<TblProductocl2> listadoproducto=crud.ListadoProducto();
		
		for(TblProductocl2 lis:listadoproducto){
			
			//imprimimos por pantalla
			System.out.println("nombre "+lis.getNombrecl2()+
					" precio venta "+lis.getPrecioventacl2()+" preciocomp "+lis.getPreciocompcl2()
					+" estado "+lis.getEstadocl2()+" descripcion "+lis.getDescripcl2());
		}

	}

}
