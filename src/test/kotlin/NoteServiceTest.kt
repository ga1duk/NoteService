import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun addNoteListIsEmpty() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val note = Note(
            title = "SomeTitle",
            text = "SomeText",
            comments = mutableListOf(comment)
        )
        service.add(note)

        val result = note.id

        assertEquals(1, result)
    }

    @Test
    fun addNoteListIsNotEmpty() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val noteFirst = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf(comment)
        )

        val noteSecond = Note(
            title = "SecondTitle",
            text = "SecondText",
            comments = mutableListOf(comment)
        )

        service.add(noteFirst)
        service.add(noteSecond)

        val result = noteSecond.id

        assertEquals(2, result)
    }

    @Test
    fun deleteNoteWithExistingId() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val note = Note(
            title = "SomeTitle",
            text = "SomeText",
            comments = mutableListOf(comment)
        )
        service.add(note)
        service.delete(1)

        val result = service.notes.size

        assertEquals(0, result)
    }

    @Test
    fun deleteNoteWithAbsentId() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val note = Note(
            title = "SomeTitle",
            text = "SomeText",
            comments = mutableListOf(comment)
        )
        service.add(note)
        service.delete(2)

        val result = service.notes.size

        assertEquals(1, result)
    }

    @Test
    fun editNoteWithExistingId() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val title = "AnotherTitle"
        val text = "AnotherText"
        val note = Note(
            title = "SomeTitle",
            text = "SomeText",
            comments = mutableListOf(comment)
        )

        service.add(note)
        service.edit(1, title, text)

        val resultTitle = note.title
        val resultText = note.text

        assertEquals(title, resultTitle)
        assertEquals(text, resultText)
    }

    @Test
    fun editNoteWithAbsentId() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val title = "AnotherTitle"
        val text = "AnotherText"
        val note = Note(
            title = "SomeTitle",
            text = "SomeText",
            comments = mutableListOf(comment)
        )

        service.add(note)
        service.edit(2, title, text)

        val resultTitle = note.title
        val resultText = note.text

        assertEquals("SomeTitle", resultTitle)
        assertEquals("SomeText", resultText)
    }

    @Test
    fun getAllNotesFromNotEmptyList() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val noteFirst = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf(comment)
        )

        val noteSecond = Note(
            title = "SecondTitle",
            text = "SecondText",
            comments = mutableListOf(comment)
        )

        val noteThird = Note(
            title = "ThirdTitle",
            text = "ThirdText",
            comments = mutableListOf(comment)
        )

        service.add(noteFirst)
        service.add(noteSecond)
        service.add(noteThird)

        val result = service.getAllNotes()?.size

        assertEquals(3, result)
    }

    @Test
    fun getAllNotesFromEmptyList() {
        val service = NoteService()

        val result = service.getAllNotes()

        assertEquals(null, result)
    }

    @Test
    fun getNoteByIdExisting() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val noteFirst = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf(comment)
        )

        val noteSecond = Note(
            title = "SecondTitle",
            text = "SecondText",
            comments = mutableListOf(comment)
        )

        service.add(noteFirst)
        service.add(noteSecond)

        val result = service.getById(2)

        assertEquals(2, result?.id)
    }

    @Test
    fun getNoteByIdAbsent() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val noteFirst = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf(comment)
        )

        val noteSecond = Note(
            title = "SecondTitle",
            text = "SecondText",
            comments = mutableListOf(comment)
        )

        service.add(noteFirst)
        service.add(noteSecond)

        val result = service.getById(3)

        assertEquals(null, result?.id)
    }

    @Test
    fun addCommentToExistingNoteIfCommentsListIsEmpty() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, comment)

        val result = note.comments.size

        assertEquals(1, result)
    }

    @Test
    fun addCommentToExistingNoteIfCommentsListIsNotEmpty() {
        val service = NoteService()
        val commentFirst = Comment(text = "FirstComment")
        val commentSecond = Comment(text = "SecondComment")
        val note = Note(
            title = "SomeTitle",
            text = "SomeText",
            comments = mutableListOf()
        )

        service.add(note)
        service.createComment(1, commentFirst)
        service.createComment(1, commentSecond)

        val result = commentSecond.id

        assertEquals(2, result)
    }

    @Test
    fun addCommentToAbsentNote() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(2312, comment)

        val result = note.comments.size

        assertEquals(0, result)
    }

    @Test
    fun deleteCommentFromExistingNote() {
        val service = NoteService()
        val commentFirst = Comment(text = "FirstComment")
        val commentSecond = Comment(text = "SecondComment")
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, commentFirst)
        service.createComment(1, commentSecond)
        service.deleteComment(1, 1)

        val result = commentFirst.isDeleted

        assertTrue(result)
    }

    @Test
    fun deleteCommentFromAbsentNote() {
        val service = NoteService()
        val commentFirst = Comment(text = "FirstComment")
        val commentSecond = Comment(text = "SecondComment")
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, commentFirst)
        service.createComment(1, commentSecond)
        service.deleteComment(2, 1)

        val result = note.comments.size

        assertEquals(2, result)
    }

    @Test
    fun deleteDeletedComment() {
        val service = NoteService()
        val commentFirst = Comment(text = "FirstComment", isDeleted = true)
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, commentFirst)
        service.deleteComment(1, 1)

        val resultFirst = note.comments.size
        val resultSecond = commentFirst.isDeleted

        assertEquals(1, resultFirst)
        assertEquals(true, resultSecond)
    }

    @Test
    fun restoreCommentFromExistingNote() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, comment)
        service.deleteComment(1, 1)
        service.restoreComment(1,1)

        val resultFirst = comment.isDeleted
        val resultSecond = note.comments.size

        assertFalse(resultFirst)
        assertEquals(1, resultSecond)
    }

    @Test
    fun restoreCommentFromAbsentNote() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, comment)
        service.deleteComment(1, 1)
        service.restoreComment(2,1)

        val resultFirst = comment.isDeleted
        val resultSecond = note.comments.size

        assertTrue(resultFirst)
        assertEquals(1, resultSecond)
    }

    @Test
    fun restoreCommentThatWasNotDeleted() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment", isDeleted = false)
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, comment)
        service.restoreComment(1,1)

        val resultFirst = comment.isDeleted
        val resultSecond = note.comments.size

        assertFalse(resultFirst)
        assertEquals(1, resultSecond)
    }

    @Test
    fun restoreUnexistingComment() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment", isDeleted = false)
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, comment)
        service.restoreComment(1,2)

        val result = note.comments.size

        assertEquals(1, result)
    }

    @Test
    fun getCommentsForExistingNote() {
        val service = NoteService()
        val commentFirst = Comment(text = "FirstComment")
        val commentSecond = Comment(text = "SecondComment")
        val commentThird = Comment(text = "ThirdComment")
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, commentFirst)
        service.createComment(1, commentSecond)
        service.createComment(1, commentThird)

        val result = service.getComments(1)?.size

        assertEquals(3, result)
    }

    @Test
    fun getCommentsForAbsentNote() {
        val service = NoteService()
        val commentFirst = Comment(text = "FirstComment")
        val commentSecond = Comment(text = "SecondComment")
        val commentThird = Comment(text = "ThirdComment")
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, commentFirst)
        service.createComment(1, commentSecond)
        service.createComment(1, commentThird)

        val result = service.getComments(2)?.size

        assertEquals(null, result)
    }

    @Test
    fun getOnlyNotDeletedCommentsForExistingNote() {
        val service = NoteService()
        val commentFirst = Comment(text = "FirstComment", isDeleted = true)
        val commentSecond = Comment(text = "SecondComment")
        val commentThird = Comment(text = "ThirdComment", isDeleted = true)
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, commentFirst)
        service.createComment(1, commentSecond)
        service.createComment(1, commentThird)

        val result = service.getComments(1)?.size

        assertEquals(1, result)
    }

    @Test
    fun editCommentForExistingNote() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, comment)
        service.editComment(1, 1, "NewText")

        val result = comment.text

        assertEquals("NewText", result)
    }

    @Test
    fun editCommentForAbsentNote() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment")
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, comment)
        service.editComment(2, 1, "NewText")

        val result = comment.text

        assertEquals("SomeComment", result)
    }

    @Test
    fun editDeletedComment() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment", isDeleted = true)
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, comment)
        service.editComment(1, 1, "NewText")

        val result = comment.text

        assertEquals("SomeComment", result)
    }

    @Test
    fun editUnexistingComment() {
        val service = NoteService()
        val comment = Comment(text = "SomeComment", isDeleted = false)
        val note = Note(
            title = "FirstTitle",
            text = "FirstText",
            comments = mutableListOf()
        )
        service.add(note)
        service.createComment(1, comment)
        service.editComment(1, 2, "NewText")

        val result = comment.text

        assertEquals("SomeComment", result)
    }
}