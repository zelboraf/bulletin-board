<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../includes/header.jsp" %>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
        </div>
    </div>

    <div class="form--steps-container">

        <div class="form--steps-counter">Krok <span>1</span>/5</div>



        <form action="/step1" method="post">
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                <c:forEach items="${items}" var="item">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="checkbox" name="selectedItemIds" value="${item.id}"
                               <c:forEach items="${sessionScope.selectedItemIds}" var="id">
                                   <c:if test="${fn:contains(id, item.id)}">checked</c:if>
                               </c:forEach>
                            />
                            <span class="checkbox"></span>
                            <span class="description">${item.name}</span>
                        </label>
                    </div>
                </c:forEach>

                <p class="error-message">
                    ${sessionScope.errorMessage}
                </p>

                <div class="form-group form-group--buttons">
                    <input type="submit" class="btn next-step" value="Dalej"/>
                </div>
            </div>
        </form>

    </div>
</section>

<%@include file="../includes/footer.jsp" %>