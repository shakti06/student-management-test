var Student = {};

$(document).ready(function(){
	
	var $PAGINATION = $('#PAGINATION');
	
	var imageUrl = '';
	
	var filter = {
		page: 1,
		limit: 5
	};
	
	$('#formStudent').submit(function(event){
		event.preventDefault(); //prevent page reload
		console.log($(this).serialize());
		
		var jsonStudent = {};
		
		/*var formData = $(this).serialize();
		var studentFields = formData.split('&');
		studentFields.forEach(function(studentField){
			var field = studentField.split('=');
			jsonStudent[field[0]] = field[1];
		});*/

		jsonStudent['photo'] = imageUrl;
		jsonStudent['pob'] = $('#pob').val();
		jsonStudent['dob'] = $('#dob').val();
		jsonStudent['phone'] = $('#phone').val();
		jsonStudent['gender'] = $('#gender').val();
		jsonStudent['lastname'] = $('#lastname').val();
		jsonStudent['firstname'] = $('#firstname').val();

		console.log(jsonStudent);
		
		jsonStudent = JSON.stringify(jsonStudent);
		
		//Save Student
		Student.save(jsonStudent);
	});
	
	$('#photo').on("change", function(){
		console.log($(this)); //inspect element to see detail of its structure
		
		var photo = $(this)[0].files[0];
		var formData = new FormData();
		formData.append("photo", photo);
		formData.append("folder", "photo");
		console.log(formData);
		
		//Upload photo
		Student.uploadPhoto(formData);
	});
	
	Student.findAll = function(){
		$.ajax({
			url: '/api/student?limit=' + filter.limit + '&page=' + filter.page,
			method: 'GET',
			success: function(response){
				console.log(response);
				Student.render(response.STUDENTS);
				Student.loadPagination(response);
			},
			error: function(response){
				console.log(response);
			}
		});
	};
	
	Student.render = function(students){
		if(students == null)
			return;
		
		var tr = ``;
		students.forEach(function(student){
			console.log(student);
			tr += `<tr>
						<td>${student.id}</td>
						<td><img src="${student.photo}"></td>
						<td>${student.firstname}</td>
						<td>${student.gender}</td>
						<td>${student.dob}</td>
						<td>${student.pob}</td>
						<td>${student.phone}</td>
						<td>
							<button id="${student.id}" data-toggle="modal" data-target="#myModal" onClick="editStudent(this)" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
							<button id="${student.id}" onClick="removeStudent(this)" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></button>
						</td>
				  </tr>`;
		});
		$('tbody').html(tr);
	};
	
	Student.renderEdit = function(student){
		$('#imageView').attr('src', student.photo);
		$('#pob').val(student.pob);
		$('#phone').val(student.phone);
		$('#gender').val(student.gender);
		$('#lastname').val(student.lastname);
		$('#firstname').val(student.firstname);
		
		var d = new Date(student.dob);		
		console.log(d.getDate() + "/" + d.getMonth() + "/" + d.getYear());
		$('#dob').val(d.getDate() + "/" + d.getMonth() + d.getYear());
	};
	
	Student.edit = function(id){
		$.ajax({
			url: '/api/student/' + id,
			method: 'GET',
			success: function(response){
				console.log(response);
				
				Student.renderEdit(response.STUDENT);
			},
			error: function(response){
				console.log(response);
			}
		});
	};
	
	Student.remove = function(id){
		$.ajax({
			url: '/api/student/' + id,
			method: 'DELETE',
			success: function(response){
				if(response.STATUS)
					Student.findAll();
				else
					console.log(response.MESSAGE);
			},
			error: function(response){	
				console.log(response);
			}
		});
	};
	
	//TODO: 
	Student.save = function(student){
		$.ajax({
			url: '/api/student',
			method: 'POST',
			data: student,
			contentType: 'application/json',
			success: function(response){
				console.log(response);
				Student.findAll();
				
				//close modal
				closeModal();
			},
			error: function(response){
				console.log(response);
				
				//close modal
				closeModal();
			}
		});
	};
	
	Student.uploadPhoto = function(formData){
		$.ajax({
			url: '/api/upload/photo',
			method: 'POST',
			data: formData,
			cache: false,
            contentType: false,
            processData: false,
			success: function(imagePath){
				console.log(imagePath);
				$('img#imageView').attr('src', imagePath);
				imageUrl = imagePath;
			},
			error: function(response){
				console.log(response);
			}
		});
	};
	
	//TODO: Load Pagination
	Student.loadPagination = function(response){
		$PAGINATION.bootpag({
	        total: response.PAGING.totalPages,
	        page: response.PAGING.page,
	        leaps: true,
	        firstLastUse: true,
	        first: '←',
	        last: '→',
	        next: 'Next',
	        prev: 'Prev',
	        maxVisible: 5
	    });
	};
	
	//TODO: Add listener to page click
	$PAGINATION.on("page", function(event, pageNumber){
		filter.page = pageNumber;
		Student.findAll();
	});
	
	Student.findAll();
});


function editStudent(self){
	Student.edit(self.id);
};

function removeStudent(self){
	Student.remove(self.id);
}

function closeModal(){
	//Close popup modal
	$('#myModal').modal('hide');
	$('div.modal-backdrop').remove();
}