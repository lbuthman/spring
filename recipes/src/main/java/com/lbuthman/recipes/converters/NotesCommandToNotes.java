package com.lbuthman.recipes.converters;

import com.lbuthman.recipes.commands.NotesCommand;
import com.lbuthman.recipes.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Override
    public Notes convert(NotesCommand notesCommand) {

        if (notesCommand != null) {
            Notes notes = new Notes();
            notes.setId(notesCommand.getId());
            notes.setRecipeNotes(notesCommand.getRecipeNotes());
            return notes;
        }
        return null;
    }
}
