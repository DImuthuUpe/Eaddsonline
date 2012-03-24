<%-- 
    Document   : chat
    Created on : Jul 22, 2011, 4:47:47 AM
    Author     : Dim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="js/jquery/themes/flora/flora.tabs.css" />
        <link href="css/div_styles.css" rel="stylesheet" type="text/css" />
        <link href="css/accordian.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/jquery/jquery-1.2.6.js"></script>
        <script type="text/javascript" src="js/jquery/ui/ui.core.js"></script>
        <script type="text/javascript" src="js/jquery/ui/ui.tabs.js"></script>
        <script type="text/javascript" src="js/jquery/ui/jquery.blockUI.js"></script>
        <script type="text/javascript" src="js/jquery/ui/ui.accordion.js"></script>
        <script type="text/javascript" src="js/jquery/ui/jquery.roundabout.js"></script>
        <script type="text/javascript" src="js/jquery/new/jquery.roundabout-shapes.js"></script>
        <script type="text/javascript" src="js/jquery/new/jquery.easing.1.3.js"></script>
        <script type="text/javascript" src="js/jquery/new/jquery.slidenavigation.min.js"></script>
        <script type="text/javascript">
            $(function(){
                var tabOpts ={selected:0,fx:{opacity:"toggle",duration:"slow"}};
                $("#chatTabs").tabs(tabOpts);
                $("#pri").accordion(
                {
                    alwaysOpen: false,
                    active:false,
                    navigation: true
                }
            );
            });
            var prevValue="";
            function readPublicChat(){
                $.getJSON("ReadPublicChat.action" ,function(json) {
                    var value="";
                    for (i in json.publicChat) {
                        value=value+json.publicChat[i][0]+" : "+json.publicChat[i][1]+"\n";
                    }
                    document.getElementById("chatBox").innerHTML=value;
                    var value="";
                    usr = getSession();

                    for (i in json.privateChatList) {

                        if(usr.email!=json.privateChatList[i].email)
                            value=value+"<div> <a href='#'>"+json.privateChatList[i].fullName+"</a><div class='chatBox'><textarea rows=8 cols=15 id='area"+json.privateChatList[i].userId+"'></textarea><input type='text' id='txt"+json.privateChatList[i].userId+"'/><input type='button' value='Chat' onclick='addPrivateChat("+json.privateChatList[i].userId+")'></div></div>";
                    }
                    if(prevValue!=value){
                        document.getElementById("pri").innerHTML=value;
                        prevValue=value;

                    }
                }
            );
            }
            function getPrivateChat(){
                $.getJSON("GetPrivateChat.action" ,function(json) {
                    $.each(json, function(key, value) {
                        //alert(key + ': ' + value);
                        res="";
                        for(i in value){
                            res+=value[i][0]+" : "+value[i][1]+"\n";
                        }
                        if(document.getElementById("area"+key)!=null)
                        document.getElementById("area"+key).innerHTML=res;
                    });

                });
            }


            function addPrivateChat(userId){
                var cht = $("#txt"+userId).val();
                $.getJSON("AddPrivateChat.action",{chat:cht , targetId:userId},function(json) {
                    var res="";                    
                    for(i in json.cht){
                        res+= json.cht[i][0]+" : "+json.cht[i][1]+"\n";
                    }
                    document.getElementById("area"+userId).innerHTML=res;

                });
            }

            function sendPublicChat() {
                var cht = $("#chatTxt").val();
                $.getJSON("AddOublicChat.action" ,{chat:cht},function(json) {
                    var value="";
                    for (i in json.publicChat) {
                        //alert("okkkkkkdsd "+json.publicChat[i]);
                        value=value+json.publicChat[i][0]+" : "+json.publicChat[i][1]+"\n"
                    }
                    document.getElementById("chatBox").innerHTML=value;
                }
            );
            }
            var tid = setInterval(loop, 2000);
            function loop() {
                readPublicChat();
                getPrivateChat();
            }
            function abortTimer() { // to be called when you want to stop the timer
                clearInterval(tid);
            }
            function getSession(){

                $.getJSON("GetAjaxSession.action" ,function(json) {

                    usr= json.user;

                }
            );

                return usr;
            }


        </script>
    </head>
    <body onload="loop()">
        <center>Chat Room</center><br>
        <div style="position: absolute;z-index:1">
            <ul id="chatTabs">
                <li><a href="#prii"><span>Private</span></a></li>
                <li><a href="#pub"><span>Public</span></a></li>
            </ul>
            <div id ="prii">
                <br><br>
                <div id="pri" class="pri">
                </div>
            </div>
            <div id="pub">
                <textarea id="chatBox" style="max-height:300px;position:anabsolute" cols="16" rows="150">

                </textarea>
                <form action="">
                    <input type="text" id="chatTxt"/>
                    <input type="button" onclick="sendPublicChat()" value="Chat"/>
                </form>

            </div>
        </div>
    </body>
</html>
