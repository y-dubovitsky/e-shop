<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="order">
    <c:if test="${CURRENT_MESSAGE != null }">
        <div class="alert alert-success hidden-print" role="alert">${CURRENT_MESSAGE }</div>
    </c:if>
    <h4 class="text-center">Order # ${order.id }</h4>
    <hr />
    <ishop:product-table items="${order.items }" totalCost="${order.totalCost }" showActionColumn="false" />
    <div class="row hidden-print">
        <div class="col-md-4 col-md-offset-4 col-lg-2 col-lg-offset-5">
            <a href="/my-orders" class="btn btn-primary btn-block">Go to My orders</a>
        </div>
    </div>
</div>