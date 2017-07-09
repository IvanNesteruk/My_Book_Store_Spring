package com.books.editors;

import com.books.entity.Genre;

import java.beans.PropertyEditorSupport;

/**
 * Created by User on 26.05.2017.
 */

public class GenreEditor extends PropertyEditorSupport{

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        Genre  genre = new Genre();
        genre.setId(Integer.parseInt(text));

        setValue(genre);
    }
}
