<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hey ! petit test BDD !</h1>
	<f:form modelAttribute="clientDto" action="addClient" method="post" class="form-horizontal">
          <div class="form-group">
            <label class="col-lg-3 control-label">Nom:</label>
            <div class="col-lg-8">
            	<f:input path="nom" class="form-control"/>
            	<f:errors path="nom" cssClass="errors" ></f:errors>
            </div>
          </div>
         
          <div class="form-group">
            <label class="col-md-3 control-label"></label>
            <div class="col-md-8">
              <button class="btn btn-primary" >Valider</button>
            </div>
          </div>
        </f:form>

</body>
</html>
