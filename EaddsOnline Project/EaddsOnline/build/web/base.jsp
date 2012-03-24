<%--
    Document   : home
    Created on : Jul 22, 2011, 4:17:47 AM
    Author     : Dim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>www.eAddsonline.com</title>
        <link rel="stylesheet" type="text/css" href="js/jquery/themes/flora/flora.tabs.css" />
        <link href="css/div_styles.css" rel="stylesheet" type="text/css" />
        <link href="css/accordian.css" rel="stylesheet" type="text/css" />
        <link href="css/slide_show.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>

        <div class="Container" align="center" >
            

            <div class="MiddleContainer" align="left" >
                <div class="footer" align="left">

                    <a href="http://www.facebook.com/pages/E-Addsonline/245338728833303" target="_blank"><img src="images/facebook_logo.jpg" align="left"  style="left:2%;position: absolute;top: 5px"/></a>
                   
                </div>


                <div class="Header">
                    <tiles:insertAttribute name="header"/>
                </div>

                <div class="TitleBar" align="center">
                    <tiles:insertAttribute name="selector"/>
                </div>

                <div class="LeftPanel" id="leftPanel">
                    <tiles:insertAttribute name="menu"/>
                </div>
                <div class="MiddlePanel">
                    <tiles:insertAttribute name="body"/>
                </div>

                <div class="RightPanel">
                    <tiles:insertAttribute name="chat"/>
                </div>


            </div>
        </div>

    </body>
</html>
