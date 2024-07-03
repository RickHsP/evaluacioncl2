<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="model.TblProductocl3" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Producto</title>
</head>
<body  bgcolor="#c5dec9">
<h1 align="center">Actualizar Producto</h1>

<form  method="post" action="Controladorproducto">

<%
// TblCliente codigo=(TblCliente)request.getAttribute("codigo");
String cod=request.getAttribute("codigo").toString();
String nom=(request.getAttribute("nombre")!=null)?request.getAttribute("nombre").toString():"";
String pre=(request.getAttribute("precioventa")!=null)?request.getAttribute("precioventa").toString():"";
String com=(request.getAttribute("preciocomp")!=null)?request.getAttribute("preciocomp").toString():"";
String est=(request.getAttribute("estado")!=null)?request.getAttribute("estado").toString():"";
String desc=(request.getAttribute("descripcion")!=null)?request.getAttribute("descripcion").toString():"";
if(cod!=null){
	
	
}
%>
<table align="center"  borde="2">


<input type="hidden" name="codigo"  value="">


<tr>
<td>Nombre</td>
<td><input type="text" name="nombre"></td>
</tr>
<tr>
<td>PrecioVentacl2</td>
<td><input type="text" name="precioventa"></td>
</tr>
<tr>
<td>PrecioCompcl2</td>
<td><input type="text" name="preciocomp"></td>
</tr>
<tr>
<td>Estado</td>
<td><input type="text" name="estado"></td>
</tr>
<tr>
<td>Descripcion</td>
<td><input type="text" name="descripcion"></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Actualizar Producto"></td>
</tr>

</table>



</form>

</body>
</html>