package com.web.e_note.service;

import com.web.e_note.entity.Notes;

import java.util.List;

public interface NoteService {

    Notes saveNotes(Notes notes);

    List<Notes> getAllNotes();

    Notes getNoteById(int id);
}
