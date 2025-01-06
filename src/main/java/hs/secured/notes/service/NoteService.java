package hs.secured.notes.service;

import hs.secured.notes.dto.NoteDto;

import java.util.List;

public interface NoteService {

    NoteDto createNote(String username, String content);

    NoteDto updateNote(Long id, String content);

    void deleteNote(Long id);

    List<NoteDto> getNotes(String username);
}
