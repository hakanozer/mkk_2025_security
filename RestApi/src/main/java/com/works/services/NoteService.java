package com.works.services;

import com.works.entities.Note;
import com.works.entities.dto.NoteAddDto;
import com.works.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    final NoteRepository noteRepository;
    final ModelMapper modelMapper;

    public Note addNote(NoteAddDto noteAddDto) {
        Note noteEntity = modelMapper.map(noteAddDto, Note.class);
        noteRepository.save(noteEntity);
        return noteEntity;
    }

    public List<Note> noteList() {
        return noteRepository.findAll();
    }

}
