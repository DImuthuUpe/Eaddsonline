<%-- 
    Document   : advertisementList
    Created on : Aug 13, 2011, 1:36:26 PM
    Author     : INDIKA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<title>www.eAddsonline.com</title>
<link rel="shortcut icon" href="images/linklogo.jpg"/>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


    </head>
    <body>

        <s:iterator value="list" var="add">
            <div style='position:relative;width:95%;height:100px;background:gray;border:black double;font-size:medium'>
                <div align='right'><img src="images/advetisement/${add.addId}.jpg" width='91' height='98' /></div>
                <div style='position:absolute;top:0px;left:10px'><a href="AdvertisementDetailAction.action?id=${add.addId}">${add.title}</a></div>
                <div style='position:absolute;top:20px;left:10px'>${add.description}</div>
            </div>

        </s:iterator>


        <div style='position:relative;width:100%;height:20px;background:silver'>
            <%
        int val = (Integer) request.getAttribute("pager");
        out.print("<table> <tr>");
        for (int i = 0; i < val; i++) {
            out.print("<td width='20px'><A href='AdvertisementList.action?id=" + (Long) request.getAttribute("id") + "&selectedPage=" + i + "'>" + (i + 1) + " </A></td>");
        }
        out.print("</table> </tr>");
            %>
        </div>

    </body>
</html>
