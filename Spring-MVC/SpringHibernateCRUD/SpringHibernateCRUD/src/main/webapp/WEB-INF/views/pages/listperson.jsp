<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
    <head>
        <title>Test</title>
    </head>
    <body>
        <div>
            <c:choose>
                <c:when test="${fn:length(personlist)>0}">
                    <table id="records">
                        <thead>
                            <tr>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Age</th>
                                <th>Salary</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>


                            <c:forEach items="${personlist}" var="p">
                                <tr>
                                    <td><c:out value="${p.fname}"></c:out></td>
                                    <td><c:out value="${p.lname}"></c:out></td>
                                    <td><c:out value="${p.age}"></c:out></td>
                                    <td><c:out value="${p.salary}"></c:out></td>
                                    <td><a href="<c:url value="/edit/${p.id}"/>"><img src="<c:url value='/resources/images/b_edit.png'/>"/></a></td>
                                    <td><a href="<c:url value="/delete/${p.id}"/>"><img src="<c:url value='/resources/images/b_drop.png'/>"/></a></td>
                                    </tr>
                            </c:forEach>
                        </thead>
                    </table>
                </c:when>
                <c:otherwise>
                    <label> No Record To Display</label>
                </c:otherwise>
            </c:choose>
        </div>


    </body>
</html>