<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h3>Exception Page</h3>
 <p>
  status:<br/><%=response.getStatus()%>
  </p>
  <p>
  Exception Message:<br/>${exception.message}
  </p>
  <p>
  Exception type:<br/>${exception['class'].name}
  </p>
</body>
</html>