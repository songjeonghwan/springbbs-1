<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page session="false" %>

<html>
<head>
    <meta charset="utf-8" /> 
	<title>login</title>
</head>
<body>  
    <form action="/spring/login" method="post" enctype="application/x-www-form-urlencoded">
        
        <label for="name">이름</label><input type="text" id="name" name="name" />
        <br />
        <label for="phone">폰  </label><input type="text" id="phone" name="phone" />
        <br />
        <input type="submit" value="전송" />
    
    </form>
</body>
</html>
