<%-- 
    Document   : AdvertisementDetail
    Created on : Aug 19, 2011, 8:29:00 PM
    Author     : Dimuthu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<title>www.eAddsonline.com</title>
<link rel="shortcut icon" href="images/linklogo.jpg"/>
   <%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <%@page import="model.Advertisement" %>
        <H2>Advertisement Details</H2>
        <table>
            <tr>
                <td>Title :</td>
                <td><s:property value="advertisement.title"/></td>
            </tr>
            <tr>
                <td>Image :</td>
                <td><%
                    Advertisement add = (Advertisement)request.getAttribute("advertisement");
                out.print("<img width='150' height='150' src='images/advetisement/"+add.getAddId()+".jpg'>");%></td>
            </tr>
            <tr>
                <td>Description :</td>
                <td><s:property value="advertisement.description"/></td>
            </tr>
            <tr>
                <td>Published date :</td>
                <td><s:property value="advertisement.publishedDate"/></td>
            </tr>
        </table>
       

        <H2>User Details</H2>
        
        <table>
            <tr>
                <td>Email :</td>
                <td><s:property value="user.email"/></td>
            </tr>
            <tr>
                <td>Full Name:</td>
                <td><s:property value="user.fullName"/></td>
            </tr>
            <tr>
                <td>Mobile :</td>
                <td><s:property value="user.mobile"/></td>
            </tr>
            <tr>
                <td>Land Line :</td>
                <td><s:property value="user.landLine"/></td>
            </tr>
            <tr>
                <td>Skype :</td>
                <td><s:property value="user.skype"/></td>
            </tr>
            <tr>
                <td>Address :</td>
                <td><s:property value="user.address"/></td>
            </tr>
            <tr>
                <td>Web Site :</td>
                <td> <s:property value="user.webSite"/></td>
            </tr>
        </table>
        
    </body>
</html>
