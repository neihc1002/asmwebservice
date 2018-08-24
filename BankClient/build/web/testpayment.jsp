<%-- 
    Document   : testpayment
    Created on : Aug 24, 2018, 2:25:16 PM
    Author     : DuongTK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Testpayment</title>
    </head>
    <body>
        <h2>Test payment service</h2>
        <form action="testpayment" method="post">
            
             <table>
                <tr>
                    <td>Mã đối tác</td>
                    <td><input type="text" name="madoitac" required/></td>
                </tr>
                <tr>
                    <td>Mật khẩu đối tác</td>
                    <td><input required type="password" name="matkhaudoitac"/></td>
                </tr>
                <tr>
                    <td>Mã khánh hàng</td>
                    <td> <input required name="makhachhang" type="text"/></td>
                </tr>
                <tr>
                    <td> Số tài khoản khách hàng</td>
                    <td><input required type="text" name="taikhoankhachhang"/></td>
                </tr>
                <tr>
                    <td>Mã PIN</td>
                    <td> <input type="password" name="pin"/></td>
                </tr>
                  <tr>
                    <td>Mã đơn hàng</td>
                    <td><input type="text" name="madonhang"/></td>
                </tr>
                  <tr>
                    <td>Số tiền thanh toán</td>
                    <td> <input value="1000" name="amount" type="number" min="1000" required/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Thanh toán"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
