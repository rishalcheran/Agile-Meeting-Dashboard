package net.javaguides.amd.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.amd.dto.ActionDto;
import net.javaguides.amd.entity.Action;
import net.javaguides.amd.exception.MeetingNotFoundException;
import net.javaguides.amd.mapper.ActionMapper;
import net.javaguides.amd.repository.ActionRepository;
import net.javaguides.amd.service.ActionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ActionServiceImpl implements ActionService {

    private final ActionRepository actionRepository;

    @Override
    public ActionDto createAction(ActionDto actionDto) {
        Action action = ActionMapper.mapToAction(actionDto);
        Action savedAction = actionRepository.save(action);
        return ActionMapper.mapToActionDto(savedAction);
    }

    @Override
    public ActionDto getActionById(Long actionId) {
        Action action = actionRepository.findById(actionId)
                .orElseThrow(() ->
                        new MeetingNotFoundException("Action does not exist with the given id: " + actionId));
        return ActionMapper.mapToActionDto(action);
    }

    @Override
    public List<ActionDto> getAllActions() {
        List<Action> actions = actionRepository.findAll();
        return actions.stream().map(ActionMapper::mapToActionDto)
                .collect(Collectors.toList());
    }

    @Override
    public ActionDto updateAction(Long actionId, ActionDto updatedAction) {
        Action action = actionRepository.findById(actionId).orElseThrow(
                () -> new MeetingNotFoundException("Action does not exist with given id: " + actionId)
        );

        // Update action fields as needed
        action.setAction(updatedAction.getAction());
        action.setAssignDate(updatedAction.getAssignDate());
        action.setCompletionDate(updatedAction.getCompletionDate());
        action.setAssignedTo(updatedAction.getAssignedTo());

        Action updatedActionObj = actionRepository.save(action);
        return ActionMapper.mapToActionDto(updatedActionObj);
    }

    @Override
    public void deleteAction(Long actionId) {
        Action action = actionRepository.findById(actionId).orElseThrow(
                () -> new MeetingNotFoundException("Action does not exist with given id: " + actionId)
        );
        actionRepository.deleteById(actionId);
    }
}