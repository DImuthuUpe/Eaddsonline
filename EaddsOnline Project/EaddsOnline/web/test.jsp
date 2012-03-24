<%-- 
    Document   : test
    Created on : Aug 13, 2011, 3:20:16 PM
    Author     : INDIKA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="java.io.*" %>
        <%
            File f = new File("D:/403.jpg");

            FileInputStream is = new FileInputStream(f);
            out.print(f.getPath());
           
        %>
    </body>
</html>
