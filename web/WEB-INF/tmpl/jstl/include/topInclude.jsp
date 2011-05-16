<%@page import="java.util.Locale" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	request.setAttribute("path", path);
%>
<c:choose>
	<c:when test="${localeString == 'zh_CN' }">
		<script type="text/javascript" src="${path}/js/i18n/message_zh_CN.js"></script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript" src="${path}/js/i18n/message_en.js"></script>
	</c:otherwise>
</c:choose>
	<script type="text/javascript" language="javascript">
		//javascript全局变量
		var path = "${path}";
	</script>