<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../includes/header.jsp" %>

<div class="form--steps-container">
    <div class="form--steps-counter">Krok <span>4</span>/5</div>
    <form action="/step4" method="post">
        <!-- STEP 4 -->
        <div data-step="4" class="active">
            <h3>Wybierz organizację, której chcesz pomóc:</h3>

            <c:forEach items="${organisations}" var="organisation">
                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="radio" name="selectedOrganisationId" value="${organisation.id}"/>
                        <span class="checkbox radio"></span><span class="description"><div class="title">${organisation.name}”</div>
                          <div class="subtitle">${organisation.description}
                              ${organisation.city}, ${organisation.street}
                          </div>
                        </span>
                    </label>
                </div>
            </c:forEach>

            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <input type="submit" class="btn next-step" value="Dalej"/>
            </div>
        </div>
    </form>

<%@include file="../includes/footer.jsp" %>