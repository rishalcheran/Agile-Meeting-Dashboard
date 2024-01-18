
package net.javaguides.amd.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import net.javaguides.amd.dto.NotesItemDto;
import net.javaguides.amd.entity.Action;
import net.javaguides.amd.entity.Notes;
import net.javaguides.amd.exception.MeetingNotFoundException;
import net.javaguides.amd.mapper.NotesMapper;
import net.javaguides.amd.repository.ActionRepository;
import net.javaguides.amd.repository.NotesRepository;
import net.javaguides.amd.service.ActionService;
import net.javaguides.amd.service.impl.NotesItemService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.Media;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotesItemServiceImpl implements NotesItemService {

    private final NotesRepository notesRepository;

    @Override
    public NotesItemDto createNotesItem(NotesItemDto notesItemDto) {
        String url = "http://localhost:8080/api/actions";
        RestTemplate restTemplate = new RestTemplate();



       String[] lines = notesItemDto.getNotes().split("\n");
        for (String line: lines) {
            System.out.println(line);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map req_payload = new HashMap<String, String>();
            req_payload.put("action", line);
            req_payload.put("assignDate", "11/12/2023");
            req_payload.put("completionDate", "16/01/24");
            req_payload.put("assignedTo", "rishal");

            HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            System.out.println(response);
        }
        Notes notes = NotesMapper.mapToNotes(notesItemDto);
        Notes savedNotes = notesRepository.save(notes);
        return NotesMapper.mapToNotesItemDto(savedNotes);
    }

    @Override
    public NotesItemDto getNotesItemById(Long notesItemId) {
        Notes notes = notesRepository.findById(notesItemId)
                .orElseThrow(() ->
                        new MeetingNotFoundException("Notes item does not exist with the given id: " + notesItemId));
        return NotesMapper.mapToNotesItemDto(notes);
    }

    @Override
    public List<NotesItemDto> getAllNotesItems() {
        List<Notes> notesList = notesRepository.findAll();
        return notesList.stream().map(NotesMapper::mapToNotesItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public NotesItemDto updateNotesItem(Long notesItemId, NotesItemDto updatedNotesItem) {
        Notes notes = notesRepository.findById(notesItemId).orElseThrow(
                () -> new MeetingNotFoundException("Notes item does not exist with given id: " + notesItemId)
        );

        // Update notes item fields as needed
        notes.setTitle(updatedNotesItem.getTitle());
        notes.setNotes(updatedNotesItem.getNotes());
        notes.setDate(updatedNotesItem.getDate());
        notes.setTime(updatedNotesItem.getTime());
        notes.setUser(updatedNotesItem.getUser());

        Notes updatedNotesItemObj = notesRepository.save(notes);
        return NotesMapper.mapToNotesItemDto(updatedNotesItemObj);
    }

    @Override
    public void deleteNotesItem(Long notesItemId) {
        Notes notes = notesRepository.findById(notesItemId).orElseThrow(
                () -> new MeetingNotFoundException("Notes item does not exist with given id: " + notesItemId)
        );
        notesRepository.deleteById(notesItemId);
    }

    @Override
    public List<NotesItemDto> getNotesItemsByUser(String user) {
        return null;
    }

    @Override
    public List<NotesItemDto> getNotesItemsByTitle(String title) {
        return null;
    }
}
