<%-- 
    Document   : searchResultBusiness
    Created on : Aug 20, 2011, 7:37:59 AM
    Author     : Dimuthu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:iterator value="businessList" var="businessDir">
            <div style='position:relative;width:95%;height:100px;background:#FFFFFF;border:black double;'>
                <div align='right'><img src="images/business/${businessDir.businessId}.jpg" width='91' height='98' /></div>
                <div style='position:absolute;top:0px;left:10px'><a href="">${businessDir.businessName}</a></div>
                <div style='position:absolute;top:20px;left:10px'>Owner : ${businessDir.ownerName}</div>
            </div>
        </s:iterator>
    </body>
</html>
