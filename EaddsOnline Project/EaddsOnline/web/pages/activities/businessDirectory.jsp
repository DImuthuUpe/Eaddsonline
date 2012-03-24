<%-- 
    Document   : addressBook
    Created on : Jul 22, 2011, 10:40:39 AM
    Author     : Dim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="shortcut icon" href="images/linklogo.jpg"/>
        <link rel="stylesheet" type="text/css" href="js/jquery/themes/flora/flora.tabs.css" />
        <link href="css/div_styles.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/jquery/jquery-1.2.6.js"></script>
        <script type="text/javascript" src="js/jquery/ui/ui.core.js"></script>
        <script type="text/javascript" src="js/jquery/ui/ui.tabs.js"></script>
        <script type="text/javascript">
            $(function(){
                $("#businessTabs").tabs();
            }
        );
        </script>
    </head>
    <body>

        <h1>Business Directory</h1>
        <div style="position:relative;">
            <ul id="businessTabs">
                <li><a href="#search"><span>Search</span></a></li>
                <li><a href="#add"><span>Add</span></a></li>
            </ul>
            <div id="search" style="position:absolute;background:white;top:40px;width:100%;height:220px">
                <div style="position:absolute;background:silver;top:0px;width:100%;height:148px;left:0px;border-bottom-style:double;border-bottom-color:white">
                    <tiles:insertAttribute name="search"></tiles:insertAttribute>
                </div>
                <div style="position:absolute;background:silver;top:150px;width:100%;height:750px;left:0px">
                    <tiles:insertAttribute name="searchResult"></tiles:insertAttribute>
                </div>
            </div>
            <div id="add" style="position:absolute;background:silver;top:40px;width:100%;height:100%">
                <s:if test="#session['email']!=null">
                    <tiles:insertAttribute name="add"></tiles:insertAttribute>
                </s:if>
                <s:else>
                    <s:label value="You have not logged on"></s:label>
                </s:else>
            </div>
        </div>
    </body>
</html>
