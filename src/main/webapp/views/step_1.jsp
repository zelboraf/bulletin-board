<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%--<%@include file="../includes/header.jsp" %>--%>

<p data-step="1" class="active">
    Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
    wiedzieć komu najlepiej je przekazać.
</p>
</div>
</div>

<div class="form--steps-container">
    <div class="form--steps-counter">Krok <span>1</span>/5</div>

        <form action="/step1" method="get">
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                <c:forEach items="${items}" var="item">
                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="checkbox" name="checkboxes" value="${item.id}" />
                        <span class="checkbox"></span>
                        <span class="description">${item.name}</span>
                    </label>
                </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <input type="submit" class="btn next-step"/>
                </div>
            </div>
        </form>

<%--<%@include file="../includes/footer.jsp" %>--%>