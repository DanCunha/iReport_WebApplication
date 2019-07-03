<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PDM - Relatorio de Material</title>
</head>
<body>
    <form action="material" method="POST" target="_blank">

      Id Material: <input type="text"  name="id_material"/>  <br />

      <input type="submit" value="Gera PDF" />

    </form>
</body>
</html>