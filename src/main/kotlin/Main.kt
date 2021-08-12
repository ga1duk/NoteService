fun main() {

    val note1 = Note(title = "Do or die", text = "Some interesting text")
    val note2 = Note(title = "Do or die2", text = "Some interesting text2")
    val note3 = Note(title = "Do or die3", text = "Some interesting text3")

    val noteService = NoteService()

    noteService.add(note1)
    noteService.add(note2)

    for (note in noteService.notes) {
        println(note)
    }

    noteService.delete(1)

    println()
    for (note in noteService.notes) {
        println(note)
    }

    noteService.add(note3)

    println()
    for (note in noteService.notes) {
        println(note)
    }
}