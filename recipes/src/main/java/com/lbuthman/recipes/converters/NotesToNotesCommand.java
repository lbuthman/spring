package com.lbuthman.recipes.converters;

import com.lbuthman.recipes.commands.NotesCommand;
import com.lbuthman.recipes.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Override
    public NotesCommand convert(Notes notes) {
        if (notes != null) {

            NotesCommand notesCommand = new NotesCommand();
            notesCommand.setId(notes.getId());
            notesCommand.setRecipeNotes(notes.getRecipeNotes());
            return notesCommand;
        }
        return null;
    }
}
