<%-- 
    Document   : menu
    Created on : Jul 22, 2011, 4:34:28 AM
    Author     : Dim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            ul {
                float:left;
                width:100%;
                padding:0;
                margin:0;
                list-style:none;
            }

            ul li {
                background-image:url(../images/navi.gif);
                background-repeat: no-repeat;
                font-size:10px;
                padding:5px 0 5px 10px;	
                border-bottom:1px dotted #000;
            }
            li:hover{
                background-image:url(../images/bg.jpg);
            }

            a {
                color:#FFF;
                text-decoration:none;
                display:block;
            }

            a:hover {
                color:#666;
                text-decoration:none;
            }
        </style>

    </head>

    <body>
        <%@page import="model.Category" %>
        <%@page import="java.util.List" %>
        <ul id="category" >
            <%List<Category> list =(List<Category>)session.getAttribute("category");
            int val=0;    %>
            <%for(Category cat:list)out.print("<li><a href='AdvertisementList.action?id="+(++val)+"'>"+cat.getTitle()+"</a></li>");%>

        </ul>
    </body>
</html>
