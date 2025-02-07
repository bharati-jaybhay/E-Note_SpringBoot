package com.web.e_note.service;

import com.web.e_note.entity.Notes;
import com.web.e_note.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository  noteRepository;

    @Override
    public Notes saveNotes(Notes notes) {
        Notes savedNotes= noteRepository.save(notes);
        return savedNotes;
    }

    @Override
    public List<Notes> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Notes getNoteById(int id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteNoteById(int id) {
        noteRepository.deleteById(id);
    }
}
