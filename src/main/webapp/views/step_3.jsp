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
        <div class="form--steps-counter">Krok <span>3</span>/5</div>
        <form action="/step3" method="post">

            <div data-step="3" class="active">
                <h3>Lokalizacja:</h3>

                <div class="form-group form-group--dropdown">
                    <select name="city">
                        <option value=""/>
                        <c:forEach items="${cities}" var="city">
                            <option value="${city}">${city}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-section">
                    <h4>Komu chcesz pomóc?</h4>
                    <div class="form-section--checkboxes">
                        <c:forEach items="${organisationTypes}" var="organisationType">
                            <div class="form-group form-group--checkbox">
                                <label>
                                    <input type="checkbox" name="types" value="${organisationType.id}"/>
                                    <span class="checkbox">${organisationType.name}</span>
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

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <input type="submit" class="btn next-step" value="Dalej"/>
                </div>
            </div>
        </form>
    </div>
</section>

<%@include file="../includes/footer.jsp" %>