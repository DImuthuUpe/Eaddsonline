<%-- 
    Document   : searchBusiness
    Created on : Aug 19, 2011, 9:57:55 PM
    Author     : Dimuthu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function seachCategory(){
                var dropdownIndex = document.getElementById('select').selectedIndex;
                var dropdownValue = document.getElementById('select')[dropdownIndex].text;
                alert("Hello JSCript " + dropdownValue);
            }
        </script>
    </head>
    <body>
        <h2>Search By</h2>
        <form action="SearchBusinessAction.action">
            <select id="select" name="selection">
                <option value=0>Name</option>
                <option value=1>Address</option>
                <option value=2>Owner</option>
                <option value=3>Business Type</option>
                <option value=4>Phone</option>
                <option value=5>Email</option>
            </select>
            <div id="searchDiv">
                <input type="text" name="searchKey" id="search"/>
            </div>
            <input type="submit" value="Search">
        </form>

    </body>
</html>
