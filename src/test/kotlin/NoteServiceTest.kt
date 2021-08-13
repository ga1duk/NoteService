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
}