<%-- 
    Document   : header
    Created on : Jul 22, 2011, 4:22:34 AM
    Author     : Dim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/div_styles.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="Logo">
            <img src="images/mainlogo.jpg" align="left" width="120%" height="100%"  />
        </div>

        <%--<div class="SearchContainer">
            <form action="">
                <input name="txtSearch" type="text" id="txtSearch" value="[select catagory]" size="26"  />
                <input type="submit" value="" style="border-color:black;background-image: url(images/search.png);width: 30px;height: 30px"/>
            </form>
        </div>--%>
        <div class="SignInContainer" align="right" >

            <s:if test="#session['email']==null">
            <form action="LogInAction">
                <input type="textfield" value="Login Email" name="email" size="22" />
                <input type="password" name="password" size="18"/>
                <input type="submit" value="" Style="border-color:black;background-image: url(images/signin.png);width: 30px;height: 30px"/>
            </form>
            </s:if>
            <s:else>
                <form action="LogOffAction">
                    <input type="submit" value="Log Off">
                </form>
            </s:else>

            <s:fielderror />
        </div>
    </body>
</html>
