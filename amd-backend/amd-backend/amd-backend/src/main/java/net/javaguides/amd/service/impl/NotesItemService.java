package net.javaguides.amd.service.impl;

import net.javaguides.amd.dto.NotesItemDto;

import java.util.List;

public interface NotesItemService {
    NotesItemDto createNotesItem(NotesItemDto notesItemDto);
    NotesItemDto getNotesItemById(Long notesItemId);
    List<NotesItemDto> getAllNotesItems();
    NotesItemDto updateNotesItem(Long notesItemId, NotesItemDto updatedNotesItem);
    void deleteNotesItem(Long notesItemId);
    // Additional methods
    List<NotesItemDto> getNotesItemsByUser(String user);
    List<NotesItemDto> getNotesItemsByTitle(String title);

}
//crud operations