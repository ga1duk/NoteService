class NoteService {

    val notes = mutableListOf<Note>()

    fun add(note: Note): Note {
        note.id = notes.size + 1
        notes.add(note)
        return notes.last()
    }

    fun createComment() {

    }

    fun delete() {

    }

    fun deleteComment() {

    }

    fun edit() {

    }

    fun editComment() {

    }

    fun getAllNotes() {

    }

    fun getById() {

    }

    fun getComments() {

    }

    fun restoreComment() {

    }
}