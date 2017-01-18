<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>
    <h1>Hello world!</h1>    
    <p>  The time on the server is ${serverTime}. </p>
      

    <h2> HomeController </h2> 
    <a href="spring/helloworld" target="_blank">/spring/helloworld</a>
    <br />
    <a href="spring/sayHello" target="_blank">/spring/sayHello</a>
    <br />  
     
    <hr />
    <a href="spring/redirect" target="_blank">/spring/helloworld redirect 테스트</a>
    <br />
    <a href="spring/forward" target="_blank">/spring/helloworld forward 테스트</a>
    <br />
    <hr>
    
    <a href="spring/querystring?name=test&phone=1244" target="_blank">/spring/querystring?name=test&phone=1244</a>
    <br />
    <a href="spring/querypath/test" target="_blank">/spring/pathvalue/test</a>
    <br />
    <a href="spring/querypath/test/1244" target="_blank">/spring/pathvalue/test/1244</a>
    <br />
    <hr />
    
    <a href="spring/login" target="_blank">/spring/login</a>
    <br />


    <hr>
    
    <h2> PhoneController </h2> 
    <a href="/phone/writeone" target="_blank">/phone/writeone</a>
    <br />
    <a href="/phone/writelist" target="_blank">/phone/writelist</a> 
    <br />


    <hr>
    
    <h2> PersonController </h2>
    <a href="/person/" target="_blank">/person/ </a> 
    <br />  
    <br />

    <hr>
   
</body>
</html>
