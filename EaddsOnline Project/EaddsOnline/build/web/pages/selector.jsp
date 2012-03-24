<%-- 
    Document   : selector
    Created on : Jul 22, 2011, 4:27:51 AM
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
        <script type="text/javascript" src="js/jquery/new/animated-menu.js"></script>
        <script type="text/javascript" src="js/jquery/jquery-1.2.6.js"></script>
        <script type="text/javascript" src="js/jquery/ui/ui.core.js"></script>
        <script type="text/javascript" src="js/jquery/ui/ui.tabs.js"></script>
        <script type="text/javascript" src="js/jquery/ui/jquery.blockUI.js"></script>
        <script type="text/javascript" src="js/jquery/ui/ui.accordion.js"></script>
        <script type="text/javascript" src="js/jquery/ui/jquery.roundabout.js"></script>
        <script type="text/javascript" src="js/jquery/new/jquery.roundabout-shapes.js"></script>
        <script type="text/javascript" src="js/jquery/new/jquery.easing.1.3.js"></script>
        <script type="text/javascript" src="js/jquery/new/jquery.slidenavigation.min.js"></script>
        
        <link href="css/animatedMenu.css" rel="stylesheet" type="text/css"/>
        <%--<script type="text/javascript">
            $(function(){
                var xPos = 0;
                var yPos = 0;
                var bottom = $("#mainTabs").offset().top+$("#mainTabs").height();
                $(document).mousemove(
                function(e){
                    if(e.pageY>bottom){
                        xPos=($(document).width()/2);
                    }else{
                        xPos=e.pageX;
                        yPos= e.pageY;
                    }
                }
            );
                var tabOpts ={selected:0,fx:{opacity:"toggle",duration:"slow"}};
                $("#mainTabs").roundabout({
                    shape: 'tearDrop',
                    duration: 500,
                    minOpacity: 0.5,
                    minScale: 0.5,
                    clickToFocus : false

                });
                setInterval(function() {
                    var ratio = xPos/($(document).width()/2);
                    if(xPos>($(document).width()/2)){
                        $('#mainTabs').roundabout_adjustBearing(Math.cos(-1*ratio*Math.PI/2));
                    }else{
                        $('#mainTabs').roundabout_adjustBearing(Math.cos(1*ratio*Math.PI/2));
                    }
                },
                20
            );

            });
        </script>
        <style>
            .roundabout-holder { padding: 0; height: 4em; width:30em; list-style: none }
            .roundabout-moveable-item {

                height: 7em;
                width: 7em;
                cursor: pointer;
                background-color: #fff;

            }
            .roundabout-in-focus { cursor: auto; }
        </style>--%>
        
        <script type="text/javascript">
            $(document).ready(function(){


                $("#li1").mouseover(function(){
                    $(this).stop().animate({height:'170px'},{queue:false, duration:600, easing: 'easeOutBounce'})
                });
                $("#li1").mouseout(function(){
                    $(this).stop().animate({height:'70px'},{queue:false, duration:600, easing: 'easeOutBounce'})
                });


                $("#li2").mouseover(function(){
                    $(this).stop().animate({height:'170px'},{queue:false, duration:600, easing: 'easeOutBounce'})
                });
                $("#li2").mouseout(function(){
                    $(this).stop().animate({height:'70px'},{queue:false, duration:600, easing: 'easeOutBounce'})
                });



                $("#li3").mouseover(function(){
                    $(this).stop().animate({height:'170px'},{queue:false, duration:600, easing: 'easeOutBounce'})
                });
                $("#li3").mouseout(function(){
                    $(this).stop().animate({height:'70px'},{queue:false, duration:600, easing: 'easeOutBounce'})
                });


                $("#li4").mouseover(function(){
                    $(this).stop().animate({height:'170px'},{queue:false, duration:600, easing: 'easeOutBounce'})
                });
                $("#li4").mouseout(function(){
                    $(this).stop().animate({height:'70px'},{queue:false, duration:600, easing: 'easeOutBounce'})
                });

                $("#li5").mouseover(function(){
                    $(this).stop().animate({height:'170px'},{queue:false, duration:600, easing: 'easeOutBounce'})
                });
                $("#li5").mouseout(function(){
                    $(this).stop().animate({height:'70px'},{queue:false, duration:600, easing: 'easeOutBounce'})
                });
                $("#li6").mouseover(function(){
                    $(this).stop().animate({height:'170px'},{queue:false, duration:600, easing: 'easeOutBounce'})
                });
                $("#li6").mouseout(function(){
                    $(this).stop().animate({height:'70px'},{queue:false, duration:600, easing: 'easeOutBounce'})
                });

            });

        </script>
    </head>
    <body>
        <div id="sel" style="position:relative;width: 100%;height: 100%;z-index:2" class="menu">
            <center>
                <%--<ul id="mainTabs">
                    <li><s:a href="homeLink.action"><span><img src="images/home.png" style="width:100%;height:100%;position: absolute;left: 0px;top: 0px"></span></s:a></li>
                    <li><s:a href="advertisementLink.action"><span><img src="images/banner_design (1).png" style="width:100%;height:100%;position: absolute;left: 0px;top: 0px"></span></s:a></li>
                    <li><s:a href="signupLink.action"><span><img src="images/signup.gif" style="width:100%;height:100%;position: absolute;left: 0px;top: 0px"></span></s:a></li>
                    <li><s:a href="businessDirectoryLink.action"><span><img src="images/businessdirectory.gif" style="width:100%;height:100%;position: absolute;left: 0px;top: 0px"></span></s:a></li>
                    <li><s:a href="feedbackLink.action"><span><img src="images/feedback-icon.png" style="width:100%;height:100%;position: absolute;left: 0px;top: 0px"></span></s:a></li>
                    <li><s:a href="profileLink.action"><span><img src="images/profile.jpg" style="width:100%;height:100%;position: absolute;left: 0px;top: 0px"></span></s:a></li>

                </ul>--%>

                <ul>
                    <li id="li1" class="green">
                        <p style="font-size:large"><s:a href="homeLink.action">Home</s:a></p>
                        <p class="subtext"><br><br><img src="images/home.png" style="width:80px"></p>
                    </li>
                    <li id="li2" class="yellow">
                        <p style="font-size:large"><s:a href="advertisementLink.action">Advertisement</s:a></p>
                        <p class="subtext"><br><br><img src="images/banner_design (1).png" style="width:80px"></p>
                    </li>
                    <li id="li3" class="red">
                        <p style="font-size:large"><s:a href="signupLink.action">Sign Up</s:a></p>
                        <p class="subtext"><br><br><img src="images/signup.png" style="width:80px"></p>
                    </li>
                    <li id="li4" class="blue">
                        <p style="font-size:large"><s:a href="businessDirectoryLink.action">Business Directory</s:a></p>
                        <p class="subtext"><br><img src="images/businessdirectory.png" style="width:80px"></p>
                    </li>
                    <li id="li5" class="purple">
                        <p style="font-size:large"><s:a href="profileLink.action">Profile</s:a></p>
                        <p class="subtext"><br><br><img src="images/profile.png" style="width:80px"></p>
                    </li>
                    <li id="li6" class="pink">
                        <p style="font-size:large"><s:a href="feedbackLink.action">Feedback</s:a></p>
                        <p class="subtext"><br><br><img src="images/feedback-icon.png" style="width:80px"></p>
                    </li>
                </ul>
            </center>

        </div>
    </body>
</html>
