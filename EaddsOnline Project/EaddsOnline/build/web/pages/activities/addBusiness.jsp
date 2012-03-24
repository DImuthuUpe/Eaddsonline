<%-- 
    Document   : addBusiness
    Created on : Aug 19, 2011, 9:58:29 PM
    Author     : Dimuthu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
         <title>JSP Page</title>
    </head>
    <body>
        <center><h1>Add business</h1></center>
        
        <s:form action="AddBusinessAction" method="post" enctype="multipart/form-data">
            <s:textfield label="Business Name" name="businessName"/>
            <s:textfield label="Owner Name" name="ownerName"/>
            <s:select label="Business Type" name="businessType" list="businessTypes" listValue="title" listKey="typeId"/>
            <s:textarea label="Description" name="description"/>
            <s:file name="photo" label="Uplaod Image" />
            <s:textfield label="Adderss line 1" name="address1"/>
            <s:textfield label="Adderss line 2" name="address2"/>
            <s:textfield label="Adderss line 3" name="address3"/>
            <s:textfield label="Mobile Number" name="mobile"/>
            <s:textfield label="Land Line 1" name="land1"/>
            <s:textfield label="Land Line 2" name="land2"/>
            <s:textfield label="Fax" name="fax"/>
            <s:textfield label="Email" name="email"/>
            <s:textfield label="Web Site" name="site"/>
            <s:submit/>
        </s:form>
    </body>
</html>
