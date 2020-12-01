<%@ page contentType="text/html;charset=utf-8" isErrorPage="true"%>
<html>
<body>
<h2>sorry, error!</h2>
错误码： <%=request.getAttribute("javax.servlet.error.status_code")%>
<br/>
信息： <%=request.getAttribute("javax.servlet.error.message")%>
<br/>
异常： <%=request.getAttribute("javax.servlet.error.exception_type")%>
</body>
</html>
