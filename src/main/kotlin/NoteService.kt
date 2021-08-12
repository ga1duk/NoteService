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

    fun createComment(id: Int, comment: Comment) {
        for (note in notes) {
            if (id == note.id) {
//        Если список пустой, присвоить полю id значение 1, если список не пустой,
//        присвоить полю id значение на 1 больше, чем у поля id последнего комментария в списке
                if (note.comments.isEmpty()) {
                    comment.id = 1
                } else {
                    comment.id = note.comments.last().id + 1
                }
                note.comments.add(comment)
            }
        }
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

    fun edit(id: Int, title: String, text: String) {
        for (note in notes) {
            if (id == note.id) {
                note.title = title
                note.text = text
            }
        }
    }

    fun editComment(noteId: Int, commentId: Int, text: String) {
        for (note in notes) {
            if (noteId == note.id) {
                for (comment in note.comments) {
                    if (comment.id == commentId) {
                        comment.text = text
                    }
                }
            }
        }
    }

    fun getAllNotes(): List<Note>? {
        return notes.ifEmpty {
            null
        }
    }

    fun getById(id: Int): Note? {
        for (note in notes) {
            if (id == note.id) {
                return note
            }
        }
        return null
    }

    fun getComments() {

    }

    fun restoreComment() {

    }
}