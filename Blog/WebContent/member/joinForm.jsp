<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Cos Blog</title>

  <!-- Bootstrap core CSS -->
  <!-- request.getContextPath() : context path가 바뀌어도 찾아준다. -->
  <link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath() %>/css/blog-home.css" rel="stylesheet">
  
  <!-- Bootstrap core JavaScript -->
  <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/bootstrap.bundle.min.js"></script>

</head>

<body>
	
	<!-- Nav Include -->
	<jsp:include page="../include/header.jsp" />
	<%=request.getContextPath()%>
  <!-- Page Content -->
  <div class="container">
    <div class="row">
      <!-- Blog Entries Column -->
      <div class="col-md-8">
				<div class="content-section">
					<form method="post" action="<%=request.getContextPath()%>/member?cmd=member_join">
						<fieldset class="form-group">
							뭐 임마
							<legend class="border-bottom md-4">Join</legend>
							<div class="form-group">
								<label class="form-control-label">ID</label>
								<input class="form-control form-control-lg" type="text" name="id" maxlength="20" required autofocus>
							</div>
							<div class="form-group">
								<label class="form-control-label">Password</label>
								<input class="form-control form-control-lg" type="password" name="password" maxlength="20" required>
							</div>
							<div class="form-group">
								<label class="form-control-label">Confirm Password</label>
								<input class="form-control form-control-lg" type="password" name="confirm" maxlength="20" required>
							</div>
							<div class="form-group">
								<label class="form-control-label">User Name</label>
								<input class="form-control form-control-lg" type="text" name="username" maxlength="20" required>
							</div>
							<div class="form-group">
								<label class="form-control-label">User Email</label>
								<input class="form-control form-control-lg" type="email" name="email" maxlength="20" required>
							</div>
							
							<div class="border-top pt-3">
								<small class="text-muted">Already Have An Account? <a href="<%=request.getContextPath() %>/member/loginForm.jsp">Login</a></small>
							</div>
							<div class="form-group pt-3 mb-0">
								<button class="btn btn-outline-info" type="submit">Sign Up</button>
							</div>
						</fieldset>
					</form>
				</div>
      </div>
      
      <!-- Sidebar Include -->
      <jsp:include page="../include/sidebar.jsp" />

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
    </div>
    <!-- /.container -->
  </footer>

</body>

</html>
