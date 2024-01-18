package net.javaguides.amd.mapper;

import net.javaguides.amd.dto.ActionDto;
import net.javaguides.amd.entity.Action;

public class ActionMapper {
    public static ActionDto mapToActionDto(Action action) {
        return new ActionDto(
                action.getId(),
                action.getAction(),
                action.getAssignDate(),
                action.getCompletionDate(),
                action.getAssignedTo()
        );
    }

    public static Action mapToAction(ActionDto actionDto) {
        return new Action(
                actionDto.getId(),
                actionDto.getAction(),
                actionDto.getAssignDate(),
                actionDto.getCompletionDate(),
                actionDto.getAssignedTo()
        );
    }
}
