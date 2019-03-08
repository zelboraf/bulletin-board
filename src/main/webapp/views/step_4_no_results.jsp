<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../includes/header.jsp" %>

<div class="form--steps-container">
    <div class="form--steps-counter">Krok <span>4</span>/5</div>
    <form action="/step2" method="post">
        <!-- STEP 4 -->
        <div data-step="4">
            <h3>Wybierz organizację, której chcesz pomóc:</h3>

            <div class="form-group form-group--checkbox">
                <label>
                    <span class="checkbox radio"></span>
                    <span class="description">
                  <div class="title">Brak wyników wyszukiwania</div>
                  <div class="subtitle"></div>
                </span>
                </label>
            </div>

            <div class="form-group form-group--buttons">
                <input type="submit" class="btn prev-step" value="Wstecz"/>
            </div>
        </div>
    </form>

<%@include file="../includes/footer.jsp" %>