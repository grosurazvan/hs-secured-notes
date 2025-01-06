package hs.secured.notes.mapper;

import hs.secured.notes.dto.NoteDto;
import hs.secured.notes.entity.Note;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-06T18:30:06+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Arch Linux)"
)
@Component
public class NoteMapperImpl implements NoteMapper {

    @Override
    public NoteDto entityToDto(Note note) {
        if ( note == null ) {
            return null;
        }

        Long id = null;
        String content = null;
        String ownerUsername = null;

        NoteDto noteDto = new NoteDto( id, content, ownerUsername );

        return noteDto;
    }
}
