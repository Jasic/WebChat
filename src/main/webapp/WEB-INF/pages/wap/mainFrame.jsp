<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<html>
<head>
    <title>Page Title</title>
    <meta name="description"
          content="Swiper demos and examples">
    <meta name="viewport"
          content="width=device-width, initial-scale=1">
    <meta name="keywords"
          content="swiper, mobile slider, touch slider, ios slider, android slider, touch gallery, jquery slider, jquery mobile slider, web app slider, native app slider, free slider, swipe slider">
    <link href="/resource/css/common.css"
          rel="stylesheet"/>
    <script src="/resource/js/libs/jquery-1.9.1.min.js"></script>
    <script src="/resource/js/libs/jquery.mobile-1.3.2.min.js"></script>
    <script type="text/javascript"
            src="/resource/js/jquery.event.drag-1.5.min.js"></script>
    <script type="text/javascript"
            src="/resource/js/jquery.touchSlider.js"></script>
    <script type="text/javascript"
            src="/resource/js/mainFrameHeader.js"></script>
</head>

<body>
<!-- Start of first page -->
<div data-role="page"
     id="foo">

    <div data-role="header">
        <%@include file="mainFrameHeader.jsp" %>
    </div>
    <!-- /header -->

    <div data-role="content">
        <p>I'm first in the source order so I'm shown as the page.</p>

        <p>View internal page called <a href="#bar">bar</a></p>
    </div>
    <!-- /content -->

    <div data-role="footer">
        <h4>Page Footer</h4>
    </div>
    <!-- /footer -->
</div>
<!-- /page -->

<div>
    <p>${path}</p>

    <h1>${baPath}</h1>
</div>
</body>
</html>
