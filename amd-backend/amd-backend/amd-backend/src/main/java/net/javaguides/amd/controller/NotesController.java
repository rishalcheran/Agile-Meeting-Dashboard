package net.javaguides.amd.controller;
import lombok.AllArgsConstructor;
import net.javaguides.amd.dto.NotesItemDto;
import net.javaguides.amd.service.impl.NotesItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/notes")
public class NotesController {

    private NotesItemService notesItemService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<NotesItemDto> createNotesItem(@RequestBody NotesItemDto notesItemDto) {
        NotesItemDto savedNotesItem = notesItemService.createNotesItem(notesItemDto);
        return new ResponseEntity<>(savedNotesItem, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("{id}")
    public ResponseEntity<NotesItemDto> getNotesItemById(@PathVariable("id") Long notesItemId) {
        NotesItemDto notesItemDto = notesItemService.getNotesItemById(notesItemId);
        return ResponseEntity.ok(notesItemDto);
    }
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<NotesItemDto>> getAllNotesItems() {
        List<NotesItemDto> notesItems = notesItemService.getAllNotesItems();
        return ResponseEntity.ok(notesItems);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("{id}")
    public ResponseEntity<NotesItemDto> updateNotesItem(@PathVariable("id") Long notesItemId,
                                                        @RequestBody NotesItemDto updatedNotesItem) {
        NotesItemDto notesItemDto = notesItemService.updateNotesItem(notesItemId, updatedNotesItem);
        return ResponseEntity.ok(notesItemDto);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNotesItem(@PathVariable("id") Long notesItemId) {
        notesItemService.deleteNotesItem(notesItemId);
        return ResponseEntity.ok("Notes item deleted successfully!");
    }
}

