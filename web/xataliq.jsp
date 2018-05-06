<%@ page contentType="text/html; charset=UTF-8" session="true" %>
<html>
<body>
<h1>
Xataliq Koruldi:
</h1>
<HR>
<% out.print (session.getAttribute("XATALIQ").toString()); %>
<HR>
</body>
</html>