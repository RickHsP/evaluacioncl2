<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.*" %>
    <%@page import="model.TblProductocl2" %>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
 
  
    
<!DOCTYPE htm>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Productos</title>
</head>
<body bgcolor="#c5dec9">
<h1  align="center">Listado de Productos Registrados en BD</h1>

<h2 align="center">

</h2>
<table border="2" align="center">

<tr>
<td>ID</td>
<td>Nombre</td>
<td>PrecioVenta</td>
<td>PrecioComp</td>
<td>Estado</td>
<td>Descripcion</td>

<td colspan="2" align="center">Acciones</td>
</tr>

<%
List<TblProductocl2> listadoproducto=(List<TblProductocl2>)request.getAttribute("listaditos");
//aplicamos una condicion..
if(listadoproducto!=null){
	//aplicamos un bucle for..
	for(TblProductocl2 lis:listadoproducto){
		%>
		<tr>
		<td><%=lis.getIdproductocl2() %></td>
		<td><%=lis.getNombrecl2() %></td>
		<td><%=lis.getPrecioventacl2() %></td>
		<td><%=lis.getPreciocompcl2() %></td>
		<td><%=lis.getEstadocl2() %></td>
		<td><%=lis.getDescripcl2() %></td>
		<td><a href="">Eliminar</a></td>
	    <td><a href="">Actualizar</a></td>
		
		</tr>
		
		
	<%	
	}   //fin del bucle for...
	%>
	<%
}  //fin de la condicion ...

%>
</table>
</body>
</html>