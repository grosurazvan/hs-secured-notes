package hs.secured.notes.service.impl;

import hs.secured.notes.dto.NoteDto;
import hs.secured.notes.entity.Note;
import hs.secured.notes.mapper.NoteMapper;
import hs.secured.notes.repository.NoteRepository;
import hs.secured.notes.service.NoteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repository;
    private final NoteMapper mapper;

    @Override
    public NoteDto createNote(String username, String content) {
        Note note = new Note();
        note.setOwnerUsername(username);
        note.setContent(content);
        final Note noteCreated = repository.save(note);
        return mapper.entityToDto(noteCreated);
    }

    @Override
    public NoteDto updateNote(Long id, String content) {
        Note note = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Note not found!"));
        note.setContent(content);
        final Note noteUpdated = repository.save(note);
        return mapper.entityToDto(noteUpdated);
    }

    @Override
    public void deleteNote(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<NoteDto> getNotes(String username) {
        List<Note> notes = repository.findByOwnerUsername(username);
        return notes.stream().map(mapper::entityToDto).toList();
    }
}
