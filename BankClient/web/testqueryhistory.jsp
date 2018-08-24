<%-- 
    Document   : queryhistory
    Created on : Aug 24, 2018, 3:26:41 PM
    Author     : DuongTK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test query service</title>
    </head>
    <body>
         <h2>Test query history service</h2>
        <form action="testquery" method="post">   
             <table>
                <tr>
                    <td> Số tài khoản</td>
                    <td><input required type="text" name="taikhoankhachhang"/></td>
                </tr>
                <tr>
                    <td>Mã PIN</td>
                    <td> <input required type="password" name="pin"/></td>
                </tr>
                <tr>
                    <td>Ngày bắt đầu</td>
                    <td> <input required type="date" name="startdate"/></td>
                </tr>
                <tr>
                    <td>Ngày cuối</td>
                    <td> <input required type="date" name="enddate"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Vấn tin"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
