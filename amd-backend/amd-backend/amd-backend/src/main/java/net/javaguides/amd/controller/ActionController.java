package net.javaguides.amd.controller;

import lombok.AllArgsConstructor;
import net.javaguides.amd.dto.ActionDto;
import net.javaguides.amd.service.ActionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/actions")
public class ActionController {

    private final ActionService actionService;
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<ActionDto> createAction(@RequestBody ActionDto actionDto) {
        ActionDto savedAction = actionService.createAction(actionDto);
        return new ResponseEntity<>(savedAction, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("{id}")
    public ResponseEntity<ActionDto> getActionById(@PathVariable("id") Long actionId) {
        ActionDto actionDto = actionService.getActionById(actionId);
        return ResponseEntity.ok(actionDto);
    }
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<ActionDto>> getAllActions() {
        List<ActionDto> actions = actionService.getAllActions();
        return ResponseEntity.ok(actions);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("{id}")
    public ResponseEntity<ActionDto> updateAction(@PathVariable("id") Long actionId,
                                                  @RequestBody ActionDto updatedAction) {
        ActionDto actionDto = actionService.updateAction(actionId, updatedAction);
        return ResponseEntity.ok(actionDto);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAction(@PathVariable("id") Long actionId) {
        actionService.deleteAction(actionId);
        return ResponseEntity.ok("Action deleted successfully!");
    }
}
