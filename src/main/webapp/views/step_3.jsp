<!-- STEP 3 -->
<div data-step="3">
    <h3>Lokalizacja:</h3>

    <div class="form-group form-group--dropdown">
        <select name="localization">
            <option value="0">- wybierz -</option>
            <option value="warsaw">Warszawa</option>
            <option value="wroclaw">Wrocław</option>
            <option value="poznan">Poznań</option>
            <option value="gdansk">Gdańsk</option>
        </select>
    </div>

    <div class="form-section">
        <h4>Komu chcesz pomóc?</h4>
        <div class="form-section--checkboxes">
            <div class="form-group form-group--checkbox">
                <label>
                    <input type="checkbox" name="help[]" value="children" />
                    <span class="checkbox">dzieciom</span>
                </label>
            </div>

            <div class="form-group form-group--checkbox">
                <label>
                    <input type="checkbox" name="help[]" value="mothers" />
                    <span class="checkbox">samotnym matkom</span>
                </label>
            </div>

            <div class="form-group form-group--checkbox">
                <label>
                    <input type="checkbox" name="help[]" value="homeless" />
                    <span class="checkbox">bezdomnym</span>
                </label>
            </div>

            <div class="form-group form-group--checkbox">
                <label>
                    <input type="checkbox" name="help[]" value="disabled" />
                    <span class="checkbox">niepełnosprawnym</span>
                </label>
            </div>

            <div class="form-group form-group--checkbox">
                <label>
                    <input type="checkbox" name="help[]" value="old" />
                    <span class="checkbox">osobom starszym</span>
                </label>
            </div>
        </div>
    </div>

    <div class="form-section">
        <h4>Wpisz nazwę konkretnej organizacji (opcjonalnie)</h4>
        <div class="form-group">
            <textarea rows="4" name="organization_search"></textarea>
        </div>
    </div>

    <div class="form-group form-group--buttons">
        <button type="button" class="btn prev-step">Wstecz</button>
        <button type="button" class="btn next-step">Szukaj</button>
    </div>
</div>