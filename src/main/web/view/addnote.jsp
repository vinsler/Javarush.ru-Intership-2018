<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"
%>

<html>

    <style type="text/css">
        .tab {margin-left: 40%}
    </style>

    <head>
        <title> add note </title>
    </head>

    <body>

        <header>
            <h2 class="tab"> add note page </h2>
        </header>

        <button class="tab" onclick="location.href = '/viewnote' "> back </button>
        <br><br>

        <form action="/addnote" class="tab" method="post">
            <input type="text" name="name" value="${name}" size="20" maxlength="10"> name
            <br><br>
            <input type="text" name="description" value="${description}" size="20" maxlength="100"> description
            <br><br>
            <input type="checkbox" name="status" size="20" maxlength="32"> status
            <br><br>
            <input type="submit" value="submit"/> &nbsp;
            <br><br>

            <c:if test="${help != null}">
                <em style="color: red">
                    <c:out value="${help}"></c:out>
                </em>
            </c:if>
        </form>
    </body>

</html>
