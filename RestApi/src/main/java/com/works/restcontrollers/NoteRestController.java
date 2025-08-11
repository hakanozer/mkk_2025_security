package com.works.restcontrollers;

import com.works.entities.Note;
import com.works.entities.dto.NoteAddDto;
import com.works.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("note")
public class NoteRestController {

    private final NoteService noteService;

    @PostMapping("add")
    public Note addNote(@RequestBody NoteAddDto noteAddDto) {
        return noteService.addNote(noteAddDto);
    }

    @GetMapping("list")
    public List<Note> listNote() {
        return noteService.noteList();
    }
}
