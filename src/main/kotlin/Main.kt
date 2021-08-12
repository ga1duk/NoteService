fun main() {

    val note1 = Note(title = "Do or die", text = "Some interesting text")
    val note2 = Note(title = "Do or die2", text = "Some interesting text2")

    val noteService = NoteService()

    noteService.add(note1)
    noteService.add(note2)

    val iterator = noteService.notes.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }
}