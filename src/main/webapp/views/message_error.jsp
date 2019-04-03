<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../includes/header.jsp" %>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Wiadomość</h3>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>5</span>/5</div>
        <div data-step="7" class="active">
            <h2>
                Wystąpił błąd w wysyłaniu wiadomości. Uzupełnij wszystkie dane formularza.
            </h2>
        </div>
    </div>
</section>

<%@include file="../includes/footer.jsp" %>