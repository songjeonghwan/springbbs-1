<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="http://www.naver.com/index.html" var="url"></c:import>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL import 실습</title>
</head>
<body>
    <h3>JSTL import 실습</h3>
    <br>
    내용출력
    <hr>
    
    <textarea rows="50" cols="600">
        ${url }<br>
    </textarea>

</body>
</html>