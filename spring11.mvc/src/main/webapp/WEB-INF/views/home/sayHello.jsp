<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page session="false" %>

<html>
<head>
    <meta charset="utf-8" /> 
	<title>helloworld</title>
</head>
<body>
    <h2> <c:out value="${msg }" /></h2>    
    <hr />    
    <h2> ${msg }</h2>
</body>
</html>
