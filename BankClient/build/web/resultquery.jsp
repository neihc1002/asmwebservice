<%-- 
    Document   : resultquery
    Created on : Aug 24, 2018, 3:58:07 PM
    Author     : DuongTK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query result</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Tên giao dịch</td>
                <td>Số tiền giao dịch</td>
                <td>Phí giao dịch</td>
                <td>Ngày giao dịch</td>
            </tr>
                <c:forEach items="${datas}" var="d">
                    <tr>
                        <td><c:out value="${d.name}"></c:out></td>
                        <td><c:out value="${d.amount}"></c:out></td>
                        <td><c:out value="${d.fee}"></c:out></td> 
                        <td><c:out value="${d.transactionDate}"></c:out></td> 
                    </tr>
                </c:forEach>
        </table>
    </body>
</html>
