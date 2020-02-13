<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="categories" required="true" type="java.util.Collection" %>

<div class="panel-heading">Category filter</div>
<div class="panel-body categories">
    <label><input type="checkbox" id="allCategories">All</label>
    <c:forEach var="category" items="${categories}">
    <div class="form-group">
        <div class="checkbox">
            <label><input type="checkbox" name="category" value="${category.id}" class="search-option">${category.name } (${category.productCount})</label>
        </div>
    </div>
    </c:forEach>
</div>