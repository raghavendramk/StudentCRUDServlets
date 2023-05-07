<%@page import="dto.Student"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        .div{
            width: 300px;
            background-color: blanchedalmond;
            margin-left: 450px;
            padding: 30px;
        }
        .label{
            border: 1px;
        }
    </style>
</head>
<body>
<% int id=Integer.parseInt(request.getParameter("id")); 
StudentDao dao=new StudentDao();
Student student=dao.find(id);
%>
<h1 style="text-align: center;">Edit your Details here</h1>
<div class="div">
<form action="update" method="post">
         <label class="label">ID:</label>
        <input type="text" placeholder="Enter your ID" name="id" value="<%=id %>" readonly="readonly"><br>
        <label class="label">Name:</label>
        <input type="text" placeholder="Enter your Name" name="name" value="<%=student.getName()%>"><br>
        <label>Mobile:</label>
        <input type="tel" placeholder="Enter your phone" pattern="{0-9}[10]" name="mobile" value="<%=student.getMobile() %>"><br>
        <label>Email ID:</label>
        <input type="email" placeholder="Enter your Email id" name="email" value="<%=student.getEmail()%>"><br>
        
        <label>Gender:</label>
        <%if(student.getGender().equals("male")){ %>
        <input type="radio" name="gender" value="male" checked="checked">Male
        <input type="radio" name="gender" value="female">Fe-male<br>
        <% } else{ %>
         <input type="radio" name="gender" value="male" >Male
        <input type="radio" name="gender" value="female" checked="checked">Fe-male<br>
        <%} %>
        
        
        <label>DOB:</label>
        <input type="date"  name="dob" value="<%=student.getDob() %>"><br>
        <label>Address:</label><br>
        <textarea rows="4" name="address" ><%=student.getAddress() %> </textarea><br>
        
        
        <label>Languages:</label>
        <% 
        boolean flag1=true;
        boolean flag2=true;
        boolean flag3=true;
        
        for(String s:student.getLanguage()){
        	if(flag1)
        	{
        		flag1=false;
        	
        	if(s.equals("kannada")){
        	%>
        	<input type="checkbox" name="language" value="kannada"  checked="checked">Kannada
        	
        	<%
        	
        }else{ %>
        
        <input type="checkbox" name="language" value="kannada" >Kannada
        <%} 
        
        	continue;
        	}%>
        	<% 
        if(flag2)
        {
        	flag2=false;
        
        if(s.equals("english")){%>
        <input type="checkbox" name="language" value="english" checked="checked">English
        <%
        
		}else{ %>
		<input type="checkbox" name="language" value="english" >English
		<%} 
        continue;
        }
        if(flag3){
        	flag3=false;
        
		 if(s.equals("hindi")){%>
        <input type="checkbox" name="language" value="hindi" checked="checked">Hindi
        <%
        }else{ %>
        <input type="checkbox" name="language" value="hindi" >Hindi
        <%} continue;
} %>
<%} %>
        <label>Country:</label><br>
        <select name="country">
            <option>India</option>
            <option>westIndis </option>
            <option>Shri lanka</option>
        </select><br><br>
        <!-- <input type="checkbox" id="skill1" name="skill1" value="java">
         <label for="vehicle1"> Java</label>
        <input type="checkbox" id="skill2" name="skill2" value="sql">
        <label for="vehicle2"> SQL</label>
        <input type="checkbox" id="skill3" name="skill3" value="Web">
        <label for="vehicle3"> Web</label><br> -->
        <button type="submit"> Submit</button>
        <button type="reset">Cancel</button>
        
        
        
    </form>
    <a href="home.html"><button>Home</button></a>
    </div>
</body>
</html>