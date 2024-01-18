
package net.javaguides.amd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActionDto {
    private Long id;
    private String action;
    private String assignDate;
    private String completionDate;
    private String assignedTo;
}