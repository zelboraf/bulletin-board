<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../includes/header.jsp" %>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="3">
                Jeśli wiesz komu chcesz pomóc, możesz wpisać nazwę tej organizacji w
                wyszukiwarce. Możesz też filtrować organizacje po ich lokalizacji
                bądź celu ich pomocy.
            </p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>4</span>/5</div>
        <form action="/step4" method="post">
            <!-- STEP 4 -->
            <div data-step="4" class="active">
                <h3>Wybierz organizację, której chcesz pomóc:</h3>

                <c:forEach items="${sessionScope.organisations}" var="organisation">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="radio" name="organisationId" value="${organisation.id}"/>
                            <span class="checkbox radio"></span><span class="description"><div
                                class="title">${organisation.name}</div>
                          <div class="subtitle">${organisation.description}
                              ${organisation.city}, ${organisation.street}
                          </div>
                        </span>
                        </label>
                    </div>
                </c:forEach>

                <p class="error-message">
                    ${sessionScope.errorMessage}
                </p>

                <div class="form-group form-group--buttons">
                    <input type="submit" class="btn prev-step" name="prev" value="Wstecz"/>
                    <c:if test="${not empty sessionScope.organisations}">
                        <input type="submit" class="btn next-step" name="next" value="Dalej"/>
                    </c:if>
                </div>
            </div>
        </form>
    </div>
</section>


<%@include file="../includes/footer.jsp" %>