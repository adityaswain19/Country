<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Citizen Enrollment Form</title>
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
</head>

<body>

<div class="container mt-5">

    <!-- Success Message -->
    <c:if test="${msg ne null}">
        <div id='alertId' class='alert alert-success'>
            <span class='font-weight-bold'>Message : </span> ${msg}
        </div>           
    </c:if>


    <!-- ======================== FORM START =============================== -->
    <div class="card">
        <div class="card-header h2 text-primary bg-secondary">Citizen Enrollment Form</div>
        <div class="card-body">

            <form id="citizenForm" action="./save-citizen" method="post" enctype="multipart/form-data">

                <input type="hidden" name="id" value="${citizen.id}">

                <div class="row">

                    <!-- Citizen ID -->
                    

                    <!-- Name -->
                    <div class="col-3 mb-3">
                        <label class="font-weight-bold">Name</label>
                        <input type="text" id="name" name="name" class="form-control" value="${citizen.name}">
                    </div>

                    <!-- Phone -->
                    <div class="col-3 mb-3">
                        <label class="font-weight-bold">Phone</label>
                        <input type="text" id="phone" name="phone" class="form-control" value="${citizen.phone}">
                    </div>

                    <!-- Email -->
                    <div class="col-3 mb-3">
                        <label class="font-weight-bold">Email</label>
                        <input type="email" name="email" class="form-control" value="${citizen.email}">
                    </div>

                    <!-- State -->
                    <div class="col-3 mb-3">
                        <label class="font-weight-bold">State</label>
                        <select id="state" name="state" class="form-control">
                            <option value="0">-select-</option>
                            <c:forEach items="${states}" var="s">
                                <option value="${s.id}"
                                    <c:if test="${s.id eq citizen.village.panchayat.block.state.id}">selected="selected"</c:if>>
                                    ${s.name}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <!-- Block -->
                    <div class="col-3 mb-3">
                        <label class="font-weight-bold">Block</label>
                        <select id="block" name="block" class="form-control">
                            <option value="0">-select-</option>
                            <c:if test="${blocks ne null}">
                                <c:forEach items="${blocks}" var="b">
                                    <option value="${b.id}"
                                        <c:if test="${b.id eq citizen.village.panchayat.block.id}">selected="selected"</c:if>>
                                        ${b.name}
                                    </option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </div>

                    <!-- Panchayat -->
                    <div class="col-3 mb-3">
                        <label class="font-weight-bold">Panchayat</label>
                        <select id="panchayat" name="panchayat" class="form-control">
                            <option value="0">-select-</option>
                            <c:if test="${panchayats ne null}">
                                <c:forEach items="${panchayats}" var="p">
                                    <option value="${p.id}"
                                        <c:if test="${p.id eq citizen.village.panchayat.id}">selected="selected"</c:if>>
                                        ${p.name}
                                    </option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </div>

                    <!-- Village -->
                    <div class="col-3 mb-3">
                        <label class="font-weight-bold">Village</label>
                        <select id="village" name="village" class="form-control">
                            <option value="0">-select-</option>
                            <c:if test="${villages ne null}">
                                <c:forEach items="${villages}" var="v">
                                    <option value="${v.id}"
                                        <c:if test="${v.id eq citizen.village.id}">selected="selected"</c:if>>
                                        ${v.name}
                                    </option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </div>

                    <!-- Gender -->
                    <div class="col-3 mb-3">
                        <label class="font-weight-bold">Gender</label>
                        <select name="gender" class="form-control">
                            <option value="0">-select-</option>
                            <option value="M"   <c:if test="${citizen.gender eq 'M'}">selected="selected"</c:if>>M</option>
                            <option value="F" <c:if test="${citizen.gender eq 'F'}">selected="selected"</c:if>>F</option>
                            <option value="O"  <c:if test="${citizen.gender eq 'O'}">selected="selected"</c:if>>O</option>
                        </select>
                    </div>

                </div>

                <div class="text-center mt-3">
                    <input type="submit" class="btn btn-success" value="Save">
                    <input type="reset" class="btn btn-warning" value="Reset">
                </div>

            </form>
        </div>
    </div>
    <!-- ======================== FORM END =============================== -->


    <!-- ===================== TABLE START =============================== -->
    <div class="h2 text-primary mt-4">Member List</div>

    <table class="table table-bordered table-striped mt-3">
        <thead>
            <tr>
                <th>Sl.#</th>
                <th>Citizen ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>State</th>
                <th>Block</th>
                <th>Panchayat</th>
                <th>Village</th>
                <th>Gender</th>
                <th>Action</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${citizens}" var="c" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td>${c.phone}</td>
                    <td>${c.email}</td>
                    <td>${c.village.panchayat.block.state.name}</td>
                    <td>${c.village.panchayat.block.name}</td>
                    <td>${c.village.panchayat.name}</td>
                    <td>${c.village.name}</td>
                    <td>${c.gender}</td>

                    <td>
                        <a href="./delete-citizen?cId=${c.id}" class="text-danger">Delete</a> |
                        <a href="./update-citizen?cId=${c.id}" class="text-primary">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
<!-- ===================== TABLE END =============================== -->


<!-- ================= AJAX SCRIPTS ================= -->

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>

<script>
document.addEventListener("DOMContentLoaded", function() {
    var al = document.querySelector("#alertId");
    if (al != null) {
        setTimeout(() => { al.remove(); }, 3000);
    }
});
</script>

<!-- STATE → BLOCK -->
<script>
$("#state").change(function(e){
	
	$.ajax({
		  url: "http://localhost:8098/ct/block-by-state-id",
		  type: "GET",
		  data: {
		      sId: $(this).val()		     
		  },
		  success: function(response) {
			  console.log(response)
			  
		      var block=$("#block");
		      $(block).find("option").remove();
		      $(block).append("<option value='0'>-select-</option>")
			  $(response).each(function(i,e){
		    	  $(block).append("<option value="+e.id+">"+e.name+"</option>");
		      });
		  },
		  error: function(xhr, status, error) {
		      console.error("Error submitting data: ", error);
		  }
		});
});
</script>

<script>
$("#block").change(function(e){
	
	$.ajax({
		  url: "http://localhost:8098/ct/panchayat-by-block-id",
		  type: "GET",
		  data: {
		      bId: $(this).val()		     
		  },
		  success: function(response) {
			  console.log(response)
			  
		      var panchayat=$("#panchayat");
		      $(panchayat).find("option").remove();
		      $(panchayat).append("<option value='0'>-select-</option>")
			  $(response).each(function(i,e){
		    	  $(panchayat).append("<option value="+e.id+">"+e.name+"</option>");
		      });
		  },
		  error: function(xhr, status, error) {
		      console.error("Error submitting data: ", error);
		  }
		});
});
</script>

<script>
$("#panchayat").change(function(e){
	
	$.ajax({
		  url: "http://localhost:8098/ct/village-by-panchayat-id",
		  type: "GET",
		  data: {
		      pId: $(this).val()		     
		  },
		  success: function(response) {
			  
		      var village=$("#village");
		      $(village).find("option").remove();
		      $(village).append("<option value='0'>-select-</option>")
			  $(response).each(function(i,e){
		    	  $(village).append("<option value="+e.id+">"+e.name+"</option>");
		      });
		  },
		  error: function(xhr, status, error) {
		      console.error("Error submitting data: ", error);
		  }
		});
});
</script>

</body>
</html>
