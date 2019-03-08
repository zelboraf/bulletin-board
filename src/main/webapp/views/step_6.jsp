<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../includes/header.jsp" %>

<div class="form--steps-container">
    <div class="form--steps-counter">Krok <span>5</span>/5</div>
    <form action="/step6" method="post">
        <!-- STEP 6 -->
        <div data-step="6" class="active">
            <h3>Podsumowanie Twojej darowizny</h3>

            <div class="summary">
                <div class="form-section">
                    <h4>Oddajesz:</h4>
                    <ul>
                        <li>
                            <span class="icon icon-bag"></span>
                            <span class="summary--text">
                                Liczba worków: ${sessionScope.order.numberOfBags}<br/>
                                Wybrane przedmioty:
                                    <c:forEach items="${items}" var="item">${item.name}&nbsp;</c:forEach>
                                <br/>

                            </span>
                        </li>

                        <li>
                            <span class="icon icon-hand"></span>
                            <span class="summary--text">
                                Dla: ${sessionScope.order.organisation.name}<br/>
                                Miasto: ${sessionScope.order.organisation.city}
                            </span>
                        </li>
                    </ul>
                </div>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru:</h4>
                        <ul>
                            <li>${sessionScope.order.name}</li>
                            <li>${sessionScope.order.street}</li>
                            <li>${sessionScope.order.city}</li>
                            <li>${sessionScope.order.postCode}</li>
                            <li>${sessionScope.order.phone}</li>
                        </ul>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru:</h4>
                        <ul>
                            <li>${sessionScope.order.pickupDate}</li>
                            <li>${sessionScope.order.pickupTime}</li>
                            <li>${sessionScope.order.notice}</li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <input type="submit" class="btn" value="Potwierdzam"/>
            </div>
        </div>
    </form>

<%@include file="../includes/footer.jsp" %>
