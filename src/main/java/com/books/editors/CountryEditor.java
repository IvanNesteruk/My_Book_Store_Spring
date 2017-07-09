package com.books.editors;

import com.books.entity.Country;
import java.beans.PropertyEditorSupport;

/**
 * Created by User on 28.05.2017.
 */

public class CountryEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        Country country = new Country();
        country.setId(Integer.parseInt(text));

        setValue(country);
    }
}
