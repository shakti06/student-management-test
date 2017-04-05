<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Student Management Page</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/resources/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="/resources/admin/css/student.css">
	
</head>
<body>
	<div class="container-fluid">
		<h1 class="text-center">Student Management System</h1>
		<a href="#"><span class="label label-default">Student Management</span></a>
		<a href="#"><span class="label label-default">User Management</span></a>
		<hr>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
				<!-- Trigger the modal with a button -->
				<a href="#" data-toggle="modal" data-target="#myModal"><span class="label label-primary"><i class="fa fa-user" aria-hidden="true"></i> New Student</span></a><br>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Image</th>
							<th>Name</th>
							<th>Gender</th>
							<th>Date of birth</th>
							<th>Place of birth</th>
							<th>Phone</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div id="PAGINATION"></div>		
			</div>
		</div>
		
	  <!-- Student Form Modal -->
	  <div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog modal-lg">
	      <div class="modal-content">
	        <div class="modal-header">
	          	<button type="button" class="close" data-dismiss="modal">&times;</button>
	          	<h4 class="modal-title">Add Student</h4>
	        </div>
	        <form id="formStudent">
		        <div class="modal-body">
		        	<div class="form-group">
		        		<img id="imageView" class="img img-thumbnail" src="/resources/admin/images/user.png">
		        		<input type="file" id="photo">
		        	</div>
		        	<div class="form-group">
				      	<label for="firstname">First Name:</label>
				      	<input type="text" class="form-control" id="firstname" name="firstname" placeholder="Enter first name">
				    </div>
				    <div class="form-group">
				      	<label for="lastname">Last Name:</label>
				      	<input type="text" class="form-control" id="lastname" name="lastname" placeholder="Enter last name">
				    </div>
				    <div class="form-group">
				      	<label for="lastname">Gender</label>
				      	<select class="form-control" id="gender" name="gender">
				      		<option value="male">Male</option>
				      		<option value="female">Female</option>
				      	</select>
				    </div>
				    <div class="form-group">
				      	<label for="pob">Place of birth:</label>
				      	<select class="form-control" id="pob" name="pob">
				      		<option value="pp">Phnom Penh</option>
				      		<option value="kd">Kandal</option>
				      		<option value="kp">Kompot</option>
				      		<option value="sr">Siem Reap</option>
				      	</select>
				    </div>
				    <div class="form-group">
				      	<label for="date">Date of birth:</label>
				      	<input type="date" class="form-control" id="dob" name="dob" placeholder="Enter date of birth">
				    </div>
				    <div class="form-group">
				      	<label for="phone">Phone Number:</label>
				      	<input type="text" class="form-control" id="phone" name="phone" placeholder="Enter phone number">
				    </div>
		        </div>
		        <div class="modal-footer">
		          	<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
		          	<input type="submit" class="btn btn-primary" value="Save">
		        </div>
	        </form>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script src="/resources/js/jquery.min.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/jquery.bootpag.min.js"></script>
	<script src="/resources/admin/js/student.js"></script>
</body>
</html>