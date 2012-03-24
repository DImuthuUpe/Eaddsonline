<%-- 
    Document   : signup
    Created on : Jul 22, 2011, 10:40:15 AM
    Author     : Dim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="shortcut icon" href="images/linklogo.jpg"/>
    </head>
    <body>
        <h1>This is sign up page</h1>
        <s:if test="#session['email']==null">
            <s:form action="SignUpAction">
                <s:textfield name="email" label="Email"></s:textfield>
                <s:textfield name="fullName" label="Full Name"></s:textfield>
                <s:password name="password" label="Password"></s:password>
                <s:password label="Confirm Password"></s:password>
                <s:textfield name="address" label="Address"></s:textfield>
                <s:textfield name="mobile" label="Mobile Number"></s:textfield>
                <s:textfield name="landLine" label="Land Line Number"></s:textfield>
                <s:textfield name="skype" label="Skype name"></s:textfield>
                <s:textfield name="webSite" label="website"></s:textfield>
                <s:submit value="Sign Up"/>
            </s:form>
        </s:if>
        <s:else>
            <s:label value="You have logged on"></s:label>
        </s:else>

    </body>
</html>
