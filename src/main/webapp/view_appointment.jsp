<%@ page import="model.User" %>
<%@ page import="dao.AppointmentDAO" %>
<%@ page import="db.DbConn" %>
<%@ page import="dao.DoctorDao" %>
<%@ page import="model.Appointment" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Doctor" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
  <%@include file="comp/allcss.jsp"%>
  <style type="text/css">
    .paint-card {
      box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
    }

    .backImg {
      background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
      url("img/hoss1.jpg");
      height: 20vh;
      width: 100%;
      background-size: cover;
      background-repeat: no-repeat;
    }
  </style>
</head>
<body>
<c:if test="${empty userObj }">
  <c:redirect url="user_login.jsp"></c:redirect>
</c:if>
<%@include file="comp/navbar.jsp"%>

<div class="container-fulid backImg p-5">
  <p class="text-center fs-2 text-white"></p>
</div>
<div class="container p-3">
  <div class="row">
    <div class="col-md-9">
      <div class="card paint-card">
        <div class="card-body">
          <p class="fs-4 fw-bold text-center text-success">Appointment
            List</p>
          <table class="table">
            <thead>
            <tr>
              <th scope="col">Full Name</th>
              <th scope="col">Gender</th>
              <th scope="col">Age</th>
              <th scope="col">Appoint Date</th>
              <th scope="col">Diseases</th>
              <th scope="col">Doctor Name</th>
              <th scope="col">Status</th>

            </tr>
            </thead>
            <tbody>
            <%
              User user = (User) session.getAttribute("userObj");
              AppointmentDAO dao = new AppointmentDAO(DbConn.getConn());
              DoctorDao dao2 = new DoctorDao(DbConn.getConn());
              List<Appointment> list = dao.getAllAppointmentByLoginUser(user.getId());
              for (Appointment ap : list) {
                Doctor d = dao2.getDoctorById(ap.getDoctorId());
            %>
            <tr>
              <th><%=ap.getFullName()%></th>
              <td><%=ap.getGender()%></td>
              <td><%=ap.getAge()%></td>
              <td><%=ap.getAppoinDate()%></td>
              <td><%=ap.getDiseases()%></td>
              <td><%=d.getFullName()%></td>
              <td>
                <%
                  if ("Pending".equals(ap.getStatus())) {
                %> <a href="#" class="btn btn-sm btn-warning">Pending</a> <%
              } else {
              %> <%=ap.getStatus()%> <%
                }
              %>
              </td>
            </tr>
            <%
              }
            %>



            </tbody>
          </table>

        </div>
      </div>
    </div>

    <div class="col-md-3 p-3">
      <img alt="" src="img/d4y.jpg">
    </div>
  </div>
</div>


</body>
</html>