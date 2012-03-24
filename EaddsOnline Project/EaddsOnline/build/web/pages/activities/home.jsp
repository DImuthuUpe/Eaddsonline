<%-- 
    Document   : home
    Created on : Jul 22, 2011, 10:40:02 AM
    Author     : Dim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="shortcut icon" href="images/linklogo.jpg"/>
    </head>
    <script type="text/javascript">
       
        $(document).ready(function() {


            slideShow(4000);

        });

        function slideShow(speed) {



            $('ul.slideshow').append('<li id="slideshow-caption" class="caption"><div class="slideshow-caption-container"><h3></h3><p></p></div></li>');


            $('ul.slideshow li').css({opacity: 0.0});


            $('ul.slideshow li:first').css({opacity: 1.0});


            $('#slideshow-caption h3').html($('ul.slideshow a:first').find('img').attr('title'));
            $('#slideshow-caption p').html($('ul.slideshow a:first').find('img').attr('alt'));


            $('#slideshow-caption').css({opacity: 0.7, bottom:0});


            var timer = setInterval('gallery()',speed);


            $('ul.slideshow').hover(
            function () {
                clearInterval(timer);
            },
            function () {
                timer = setInterval('gallery()',speed);
            }
        );

        }

        function gallery() {



            var current = ($('ul.slideshow li.show')?  $('ul.slideshow li.show') : $('#ul.slideshow li:first'));


            var next = ((current.next().length) ? ((current.next().attr('id') == 'slideshow-caption')? $('ul.slideshow li:first') :current.next()) : $('ul.slideshow li:first'));


            var title = next.find('img').attr('title');
            var desc = next.find('img').attr('alt');


            next.css({opacity: 0.0}).addClass('show').animate({opacity: 1.0}, 1000);


            $('#slideshow-caption').slideToggle(400, function () {
                $('#slideshow-caption h3').html(title);
                $('#slideshow-caption p').html(desc);
                $('#slideshow-caption').slideToggle(500);
            });

           
            current.animate({opacity: 0.0}, 2000).removeClass('show');

        }
    </script>
    <body>
        <div class="MiddlePanel1" style="z-index:1">
            <ul class="slideshow">
                <li class="show"><a href="#"><img src="images/automobiles.png" width="535" height="330" title="Automobiles" alt="Brandnew or Recondition one as u wish to buy"/></a></li>
                <li><a href="#"><img src="images/Computer.png" width="540" height="330" title="Computers" alt="Go through new technology "/></a></li>
                <li><a href="#"><img src="images/hotels.png" width="540" height="330" title="Hotels" alt="Short Description"/></a></li>
                <li><a href="#"><img src="images/Hospital.png" width="540" height="330" title="Hospitals" alt="Short Description"/></a></li>
                <li><a href="#"><img src="images/House.png" width="540" height="330" title="Houses" alt="Short Description"/></a></li>
                <li><a href="#"><img src="images/mobile4nes.png" width="540" height="330" title="Mobile Phones" alt="Short Description"/></a></li>
                <li><a href="#"><img src="images/jobs.png" width="540" height="330" title="jobs" alt="Short Description"/></a></li>
                <li><a href="#"><img src="images/Wedding.png" width="540" height="330" title="Marriage Proposals" alt="Short Description"/></a></li>
                <li><a href="#"><img src="images/pets.png" width="540" height="330" title="Pets" alt="Short Description"/></a></li>
            </ul>
            
        </div>




    </body>


</html>
