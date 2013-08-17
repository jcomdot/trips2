<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Map<String, String[]> map = request.getParameterMap();
Object[] keys = map.keySet().toArray();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>현재시각2</title>
</head>
<body>
현재시각은 <%=new java.util.Date() %>입니다.
<c:if test = "${ 5 < 3 }">
<p> 5는 3보다 크다.</p>
</c:if>
<p>Map Size = <%=map.size() %></p>
<table border="1">
	<tr><td>Map element</td><td>Par name</td><td>Par value(s)</td></tr>
<%
for (int k=0; k<keys.length; k++) {
	String pars[] = request.getParameterValues((String)keys[k]);
%>
	<tr><td><%=k %></td><td>'<%=keys[k] %>'</td><td>
<%
	for (int j=0; j<pars.length; j++) {
		if (j > 0) {
%>
,
<%
		}
%>
'<%=pars[j] %>'
<%
	}
%>
	</td></tr>
<%
}
%>
</table>
<br />
Context Path: <%=request.getContextPath() %><br />
Content Type: <%=response.getContentType() %><br />
Header Names: <%=response.getHeaderNames() %><br />
Response Status: <%=response.getStatus() %><br />
Locale: <%=response.getLocale() %><br />
Session ID: <%=session.getId() %><br />
Session Last Accessed Time: <%=new Date(session.getLastAccessedTime()) %><br />
Application Ver.: <%=application.getMajorVersion() + "." + application.getMinorVersion() %><br />
Application Effective Ver.: <%=application.getEffectiveMajorVersion() + "." + application.getEffectiveMinorVersion() %><br />
Server info.: <%=application.getServerInfo() %><br />
Servlet Context name.: <%=application.getServletContextName() %><br />
Servlet name.: <%=config.getServletName() %><br />
Page.: <%=page.toString() %><br />
Hello : <% out.write("abcdおはよう~"); %><br />
<% out.print(config.getServletContext().getAttribute("mypet")); %>
</body>
</html>