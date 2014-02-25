<jsp:directive.page import="java.nio.file.*"/> 
<jsp:include page="header.jsp" />
<ul>
<%
if(request.getAttribute("parenturl") != null){	
	%><li><a href="<%= request.getAttribute("parenturl").toString() %>">.. (parent dir)</a></li><%
}
%>
<%
	for(Path item : (DirectoryStream<Path>) request.getAttribute("items")){
		String url = item.getFileName().toString();
		%>
		<li><a href="<%= url %>"><%= url %></a></li>
		<%
	}
%>
</ul>
<jsp:include page="footer.jsp" />