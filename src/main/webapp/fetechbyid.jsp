<%@page import="java.util.Arrays"%>
<%@page import="dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data feteching by ID</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<a href="home.html"><button>Home</button></a><br>
<% Student student=(Student)request.getAttribute("student"); %>

<table border='1'>
<tr>
<th>Id</th>
<th>Name</th>
<th>Mobile</th>
<th>EmailID</th>
<th>Gender</th>
<th>DOB</th>
<th>Address</th>
<th>Languages</th>
<th>Country</th>
<th>delete</th>
<th>Edit</th>
</tr>
<tr>
<td><%=student.getId() %></td>
<td><%=student.getName() %></td>
<td><%=student.getMobile() %></td>
<td><%=student.getEmail()%></td>
<td><%=student.getGender()%></td>
<td><%=student.getDob() %></td>
<td><%=student.getAddress() %></td>
<td><%=Arrays.toString(student.getLanguage())%></td>
<td><%=student.getCountry() %></td>
<td><a href="delete?id=<%=student.getId() %>"><button>Delete</button></a></td>
<td><a href="Edit.jsp?id=<%=student.getId() %>"><button>Edit</button></a></td>
</tr>
</table>
</body>
</html>