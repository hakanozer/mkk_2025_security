package com.works.entities.dto;

import com.works.entities.Note;
import jakarta.validation.constraints.*;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Note}
 */
@Value
public class NoteAddDto implements Serializable {
    @NotNull
    @Size(min = 2, max = 100)
    @NotEmpty
    String title;
    @NotNull
    @Min(1)
    @Max(30)
    Integer days;
}