package net.javaguides.amd.mapper;

import net.javaguides.amd.dto.NotesItemDto;
import net.javaguides.amd.entity.Notes;

public class NotesMapper {

    public static NotesItemDto mapToNotesItemDto(Notes notes) {
        return new NotesItemDto(
                notes.getId(),
                notes.getTitle(),
                notes.getNotes(),
                notes.getDate(),
                notes.getTime(),
                notes.getUser()
        );
    }

    public static Notes mapToNotes(NotesItemDto notesItemDto) {
        return new Notes(
                notesItemDto.getId(),
                notesItemDto.getTitle(),
                notesItemDto.getNotes(),
                notesItemDto.getDate(),
                notesItemDto.getTime(),
                notesItemDto.getUser()
        );
    }

    public static Notes mapToNotes(NotesItemDto notesItemDto, Long generatedId) {
        // this method if you want to set a generated ID (e.g., when creating a new Notes entity)
        return new Notes(
                generatedId,
                notesItemDto.getTitle(),
                notesItemDto.getNotes(),
                notesItemDto.getDate(),
                notesItemDto.getTime(),
                notesItemDto.getUser()
        );
    }
}
