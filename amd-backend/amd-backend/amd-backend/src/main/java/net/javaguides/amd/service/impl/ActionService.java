package net.javaguides.amd.service;

import net.javaguides.amd.dto.ActionDto;

import java.util.List;

public interface ActionService {
    ActionDto createAction(ActionDto actionDto);
    ActionDto getActionById(Long actionId);
    List<ActionDto> getAllActions();
    ActionDto updateAction(Long actionId, ActionDto updatedAction);
    void deleteAction(Long actionId);
    // Additional methods if needed
}
