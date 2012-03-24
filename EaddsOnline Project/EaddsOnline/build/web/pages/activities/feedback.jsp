<%-- 
    Document   : feedback
    Created on : Jul 22, 2011, 10:41:14 AM
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
        <link rel="shortcut icon" href="images/linklogo.jpg"/>
    </head>
    <body>
        <h1>Send Your Feedback</h1>
        <s:if test="#session['email']!=null">
        <s:form action="FeedBackAction">
            <s:textarea name="description" label="Description"></s:textarea>
            <s:submit value="Send" ></s:submit>
        </s:form>
        </s:if>
        <s:else>
            <s:label value="You have not logged on"></s:label>
        </s:else>
        
    </body>
</html>
