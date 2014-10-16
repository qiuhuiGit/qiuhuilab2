<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Find by Author</title>
</head>
<body>
	<h1>Find by Author's name</h1>
   <form action="books" method="post">
      Authorname:<br/><input type="text" name="authorname"/><br/>
      <input type="submit" value="Find"/>		
   </form>
</body>
</html>