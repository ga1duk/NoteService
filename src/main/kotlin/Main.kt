fun main() {

    val note1 = Note(title = "Do or die1", text = "Some interesting text1")
    val note2 = Note(title = "Do or die2", text = "Some interesting text2")
    val note3 = Note(title = "Do or die3", text = "Some interesting text3")

    val noteService = NoteService()

    noteService.add(note1)
    noteService.add(note2)
    println("Добавление заметок:")
    for (note in noteService.notes) {
        println(note)
    }

    noteService.delete(1)
    println("\nУдаление заметки:")
    for (note in noteService.notes) {
        println(note)
    }

    noteService.add(note3)
    println("\nДобавление заметки:")
    for (note in noteService.notes) {
        println(note)
    }

    noteService.edit(3, "For whom the bell tolls", "Another interesting text")
    println("\nРедактирование заметки по id")
    for (note in noteService.notes) {
        println(note)
    }

    println("\nВывод списка заметок")
    println(noteService.getAllNotes())

    println("\nПолучение заметки по id")
    println(noteService.getById(2))
}