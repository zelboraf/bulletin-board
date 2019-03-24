<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <div class="form--steps-counter">Krok <span>3</span>/5</div>
        <form action="/step3" method="post">

            <div data-step="3" class="active">
                <h3>Lokalizacja:</h3>

                <div class="form-group form-group--dropdown">
                    <select name="selectedCity">
                        <option value=""/>
                        <c:forEach items="${cities}" var="city">
                            <option value="${city}"
                                    <c:if test="${sessionScope.selectedCity == city}">selected="selected"</c:if>
                            >${city}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-section">
                    <h4>Komu chcesz pomóc?</h4>
                    <div class="form-section--checkboxes">
                        <c:forEach items="${types}" var="type">
                            <div class="form-group form-group--checkbox">
                                <label>
                                    <input type="checkbox" name="selectedTypeIds" value="${type.id}"
                                        <c:forEach items="${sessionScope.selectedTypeIds}" var="id">
                                            <c:if test="${fn:contains(id, type.id)}">checked</c:if>
                                        </c:forEach>
                                    />
                                    <span class="checkbox">${type.name}</span>
                                </label>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <div class="form-section">
                    <h4>Wpisz nazwę konkretnej organizacji (opcjonalnie)</h4>
                    <div class="form-group">
                        <textarea rows="4" name="name"></textarea>
                    </div>
                </div>

                <p class="error-message">
                    ${sessionScope.errorMessage}
                </p>

                <div class="form-group form-group--buttons">
                    <input type="submit" class="btn prev-step" name="prev" value="Wstecz"/>
                    <input type="submit" class="btn next-step" name="next" value="Dalej"/>
                </div>
            </div>
        </form>
    </div>
</section>

<%@include file="../includes/footer.jsp" %>