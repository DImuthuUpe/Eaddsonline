<%-- 
    Document   : profile
    Created on : Jul 22, 2011, 10:40:24 AM
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
        <h1>This is profile page</h1>
        <s:if test="#session['email']!=null">
        <s:label value="Your Email address is "></s:label><%=session.getAttribute("email")%>
        <s:form action="EditUserAction" theme="simple">
            <table>
                <tr>
                    <td><s:label value="Full Name"/></td>
                    <td><s:textfield name="fullName" value="%{#session.user.fullName}"></s:textfield></td>
                    <td><s:checkbox label="Edit" value="false" name="ch1"/></td>
                </tr>
                
                <tr>
                    <td><s:label value="Password"/></td>
                    <td><s:password name="password" value="%{#session.user.password}"></s:password></td>
                    <td><s:checkbox label="Edit" value="false" name="ch2"/></td>
                </tr>

                <tr>
                    <td><s:label value="Address"/></td>
                    <td><s:textfield name="address" value="%{#session.user.address}"></s:textfield></td>
                    <td><s:checkbox label="Edit" value="false" name="ch3"/></td>
                </tr>

                <tr>
                    <td><s:label value="Mobile Number"/></td>
                    <td><s:textfield name="mobile" value="%{#session.user.mobile}"></s:textfield></td>
                    <td><s:checkbox label="Edit" value="false" name="ch4"/></td>
                </tr>

                <tr>
                    <td><s:label value="Land Line Number"/></td>
                    <td><s:textfield name="landLine" value="%{#session.user.landLine}"></s:textfield></td>
                    <td><s:checkbox label="Edit" value="false" name="ch5"/></td>
                </tr>

                <tr>
                    <td><s:label value="Skype name"/></td>
                    <td> <s:textfield name="skype" value="%{#session.user.skype}"></s:textfield></td>
                    <td><s:checkbox label="Edit" value="false" name="ch6"/></td>
                </tr>

                <tr>
                    <td><s:label value="website"/></td>
                    <td><s:textfield name="webSite" value="%{#session.user.webSite}" id="webSite"></s:textfield></td>
                    <td><s:checkbox label="Edit" value="false" name="ch4" onselect=""/></td>
                </tr>

            </table>            
            <s:submit value="Edit Your Profile"/>
        </s:form>
        <br/>
        <s:a href="ViewUserAdvertisements.action">Your advertisements</s:a>
        </s:if>
        <s:else>
            <s:label value="You have not logged on"></s:label>
        </s:else>
    </body>
</html>
