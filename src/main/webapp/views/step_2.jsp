<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../includes/header.jsp" %>



<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="2" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>2</span>/5</div>

        <form action="/step2" method="post">
            <div data-step="2" class="active">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <input type="number" name="numberOfBags" value="${sessionScope.numberOfBags}" step="1" min="1"/>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <input type="submit" class="btn prev-step" name="prev" value="Wstecz"/>
                    <input type="submit" class="btn next-step" name="next" value="Dalej"/>
                </div>
            </div>
        </form>
    </div>
</section>

<%@include file="../includes/footer.jsp" %>
