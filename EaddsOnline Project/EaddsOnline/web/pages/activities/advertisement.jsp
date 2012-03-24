<%-- 
    Document   : advertisement
    Created on : Jul 22, 2011, 10:41:04 AM
    Author     : Dim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="shortcut icon" href="images/linklogo.jpg"/>
        <script type="text/javascript">
            function message(sel){
               var val=sel.options[sel.selectedIndex].value;
               if(val==0){
                   document.getElementById("guide").innerHTML="Pay for account number 2100043535 in Peoples Bank Galle Branch and sms zip number to 0719084638. We will immediately host your advertisement";
               }else{
                   document.getElementById("guide").innerHTML="Pay for account number 24 53454 646 in Bank of Ceylon Galle Branch and sms zip number to 0719084638. We will immediately host your advertisement";
               }
            }
        </script>
    </head>
    <body>
        <h1>Advertise here</h1>
        <s:if test="#session['email']!=null">
            <s:form action="AdvertisementAction" method="post" enctype="multipart/form-data">
            <s:textfield name="title" label="Title"></s:textfield>
            <s:textarea name="description" label="Description"></s:textarea>
            <s:select name="category" label="Catgory" list="#session['category']" listValue="title" listKey="categoryId"></s:select>
            <s:file name="image"label="Image"></s:file>
            <s:select name="priority"label="Select Package" list="#{'0':'Rs 50 per Week','1':'Rs 100 per Week','2':'Rs 150 per Week'}"></s:select>
            <s:textfield name="duration"label="Duration (Weeks)" value="1"></s:textfield>
            <s:select onchange="message(this)" id="method" name="method"label="Payment Method" list="#{'0':'Pepoles Bank','1':'Bank of Ceylon'}"></s:select>
            
            <s:submit value="Done"/>
        </s:form>
            <s:div id="guide">Pay for account number 2100043535 in Peoples Bank Galle Branch and sms zip number to 0719084638. We will immediately host your advertisement</s:div>
        </s:if>
        <s:else>
            <s:label value="You have not logged on"></s:label>
        </s:else>
    </body>
</html>
