<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<html>
<head>
    <title>Display All Request Parameters</title>
</head>
<body>
<h4>List of Request Parameter Names and its Values</h4>
    <%
        Map<String, Object> modelMap = (Map<String, Object>) request.getAttribute("parameters");
        for(String key: modelMap.keySet()){
            out.print(key);
            out.print(" : ");
            out.print(modelMap.get(key));
            out.print("<br />");
            out.print("Nodo Raiz: "+modelMap.get("Lv0Nodo1"));
        }
    %>
</body>
</html>
<jsp:include page="footer.jsp" />