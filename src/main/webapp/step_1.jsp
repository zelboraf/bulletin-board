<%@include file="header.jsp" %>
<form action="step_1" method="post">
    <div data-step="1" class="active">
        <h3>Zaznacz co chcesz oddać:</h3>

        <div class="form-group form-group--checkbox">
            <label>
                <input type="checkbox" name="products[]" value="clothes-to-use" />
                <span class="checkbox"></span>
                <span class="description">ubrania, które nadają się do ponownego użycia</span>
            </label>
        </div>

        <div class="form-group form-group--checkbox">
            <label>
                <input type="checkbox" name="products[]" value="clothes-useless" />
                <span class="checkbox"></span>
                <span class="description">ubrania, do wyrzucenia</span>
            </label>
        </div>

        <div class="form-group form-group--checkbox">
            <label>
                <input type="checkbox" name="products[]" value="toys"/>
                <span class="checkbox"></span>
                <span class="description">zabawki</span>
            </label>
        </div>

        <div class="form-group form-group--checkbox">
            <label>
                <input type="checkbox" name="products[]" value="books"/>
                <span class="checkbox"></span>
                <span class="description">książki</span>
            </label>
        </div>

        <div class="form-group form-group--checkbox">
            <label>
                <input type="checkbox" name="products[]" value="other"/>
                <span class="checkbox"></span>
                <span class="description">inne</span>
            </label>
        </div>

        <div class="form-group form-group--buttons">
            <button type="button" class="btn next-step">Dalej</button>
        </div>
    </div>
</form>
<%@include file="footer.jsp" %>