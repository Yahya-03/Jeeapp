
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor Login Page</title>
    <%@include file="comp/allcss.jsp" %>
    <style type="text/css">
        .paint-card{
            box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
        }
    </style>
</head>
<body>
  <%@ include file="comp/navbar.jsp"%>

<div class="container p-5">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-4 text-center">Doctor Login</p>

                  <form action="doctorLogin" method="post">
                      <div class="mb-3">
                           <label class="form-label">Email address</label>
                          <input required name="email" type="email" class="form-control">
                      </div>
                       <div class="mb-3">
                           <label class="form-label">Password</label>
                           <input required name="password" type="password" class="form-control">
                       </div>
                      <button type="submit" class="btn bg-success text-white col-md-12">Login</button>
                  </form>
                </div>
            </div>
        </div>
    </div>
</div>




</body>
</html>
