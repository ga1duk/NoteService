class NoteService {

    val notes = mutableListOf<Note>()

    fun add(note: Note) {
//        Если список пустой, присвоить заметке id = 1, если список не пустой,
//        присвоить заметке id на 1 больше, чем id у последней заметки в списке
        if (notes.isEmpty()) {
            note.id = 1
        } else {
            note.id = notes.last().id + 1
        }
        notes.add(note)
    }

    fun createComment() {

    }

    fun delete(id: Int) {
        for (note in notes) {
            if (id == note.id) {
                notes.remove(note)
            }
        }
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