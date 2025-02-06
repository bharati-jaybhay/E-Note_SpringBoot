package com.web.e_note.service;

import com.web.e_note.entity.Notes;
import jakarta.validation.Valid;

public interface NoteService {
    Notes saveNotes(@Valid Notes notes);
}
