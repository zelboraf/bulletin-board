<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../includes/header.jsp" %>

<div class="form--steps-container">
    <div class="form--steps-counter">Krok <span>5</span>/5</div>
    <form action="/step5" method="post">
        <!-- STEP 5 -->
        <div data-step="5" class="active">
            <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

            <div class="form-section form-section--columns">
                <div class="form-section--column">
                    <h4>Adres odbioru</h4>
                    <div class="form-group form-group--inline">
                        <label> Nazwa / imię i nazwisko <input type="text" name="name" value="Jan Kowalski"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label> Ulica <input type="text" name="street" value="Kozia 1"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label> Miasto <input type="text" name="city" value="Gdańsk"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label>
                            Kod pocztowy <input type="text" name="postCode" value="80-200"/>
                        </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label>
                            Numer telefonu <input type="phone" name="phone" value="123 456 789"/>
                        </label>
                    </div>
                </div>

                <div class="form-section--column">
                    <h4>Termin odbioru</h4>
                    <div class="form-group form-group--inline">
                        <label> Data <input type="date" name="pickupDate" value="2019-04-01"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label> Godzina <input type="time" name="pickupTime" value="12:34:00"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label>
                            Uwagi dla kuriera
                            <textarea name="notice" rows="5"></textarea>
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <input type="submit" class="btn next-step" value="Dalej"/>
            </div>
        </div>
    </form>

<%@include file="../includes/footer.jsp" %>