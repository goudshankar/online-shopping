<div class="container">
	
	<!--create a row  -->
	<div class="row">
	
	<!--create a column to display side bar  -->
	<div class="col-md-3">
	
	<%@include file="./shared/sidebar.jsp"%>
	</div>
	<!--create another column to display the actual products  -->
	<div class="col-md-9">
		<%-- <!--added breadcrumb component(it is a readymade bootstrap class)   -->
		<div classs="row">
			<div class="col-lg-12">
			<c:if test="${userClickAllProducts==true}">
				<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a>
				<li class="active">All Products</li>
				</ol>
			</c:if>
			<c:if test="${userClickCategoryProducts==true}">
				<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a>
				<li class="active">Category</li>
				<li class="active">${category.name}</li>
				
				</ol>
			</c:if>
			</div>
	 --%>	
		</div>
	
	
	
	
	</div>
	
	
	
	
	
	
	</div>








</div>