package hs.secured.notes.controller;

import hs.secured.notes.dto.NoteDto;
import hs.secured.notes.service.NoteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class NoteController {

    private final NoteService service;

    @PostMapping("/notes")
    public NoteDto createNote(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
        final String username = userDetails.getUsername();

        log.info("Creating note for user: {}", username);

        return service.createNote(username, content);
    }

    @GetMapping("/notes")
    public List<NoteDto> getNotes(@AuthenticationPrincipal UserDetails userDetails) {
        final String username = userDetails.getUsername();

        log.info("Retrieving notes for user: {}", username);

        return service.getNotes(username);
    }

    @PutMapping("/notes/{id}")
    public NoteDto updateNote(@PathVariable Long id, @RequestBody String content) {
        log.info("Updating note: {}", id);

        return service.updateNote(id, content);
    }

    @DeleteMapping("/note/{id}")
    public void deleteNote(@PathVariable Long id) {
        log.info("Deleting note: {}", id);

        service.deleteNote(id);
    }
}
