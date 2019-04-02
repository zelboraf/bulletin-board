<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <div class="form--steps-counter">Krok <span>5</span>/5</div>
        <form:form action="/step5" method="post" modelAttribute="order">
            <!-- STEP 5 -->
            <div data-step="5" class="active">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label>
                                Nazwa / imię i nazwisko <form:input type="text" path="name" value="Jan Kowalski"/>
                            </label>
                            <form:errors path="name" cssClass="error-message"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Ulica <form:input type="text" path="street" value="Kozia 1"/>
                            </label>
                            <form:errors path="street" cssClass="error-message"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Miasto <form:input type="text" path="city" value="Gdańsk"/>
                            </label>
                            <form:errors path="city" cssClass="error-message"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy <form:input type="text" path="postCode" value="80-200"/>
                            </label>
                            <form:errors path="postCode" cssClass="error-message"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <form:input type="phone" path="phone" value="123 456 789"/>
                            </label>
                            <form:errors path="phone" cssClass="error-message"/>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label>
                                Data <form:input type="date" path="pickupDate" value="2019-05-01"/>
                            </label>
                            <form:errors path="pickupDate" cssClass="error-message"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Godzina <form:input type="time" path="pickupTime" value="12:34:00"/>
                            </label>
                            <form:errors path="pickupTime" cssClass="error-message"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea path="notice" rows="5"></form:textarea>
                            </label>
                            <form:errors path="notice" cssClass="error-message"/>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <input type="submit" class="btn prev-step" name="prev" value="Wstecz"/>
                    <input type="submit" class="btn next-step" name="next" value="Dalej"/>
                </div>
            </div>
        </form:form>
    </div>
</section>

<%@include file="../includes/footer.jsp" %>