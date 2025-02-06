package com.web.e_note.service;

import com.web.e_note.entity.Notes;
import com.web.e_note.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService{

    private NoteRepository  noteRepository;
    @Override
    public Notes saveNotes(Notes notes) {
        return noteRepository.save(notes);
    }
}
