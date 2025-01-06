package hs.secured.notes.mapper;

import hs.secured.notes.dto.NoteDto;
import hs.secured.notes.entity.Note;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface NoteMapper {

    NoteDto entityToDto(Note note);
}
