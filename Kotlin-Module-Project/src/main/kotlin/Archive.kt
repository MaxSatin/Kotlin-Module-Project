class Archive (
    val name : String,
    var notes: MutableList<Note>
) {
    var innerArchive : MutableList<Archive>? = null

    fun createNote () {
        println("Введите заголовок заметки: ")
        var noteName = ArchiveManip.readInput().trim().toLowerCase().capitalize()

        println("Введите текст заметки: ")
        var noteContents = ArchiveManip.readInput().trim()
        notes.add(Note(noteName, noteContents))
    }
    fun printArchive () {
        if (innerArchive?.isEmpty() == true) {
            println("Архив не содержит вложенных архивов")
        } else {
            for (i in 0..this.innerArchive!!.size)
                println ("$i - Архив '${this.innerArchive?.get(i)}'")
        }
    }

    fun printNotes() {
        if (this.notes.isEmpty()) {
            println("Архив не содержит заметок")
        } else {
            for (i in 0..this.notes.size)
                println ("$i - Архив '${this.notes.get(i)}'")
        }
    }

    fun deleteNote (noteIndex : Int) {
        this.notes.removeAt(noteIndex)
        println("Теперь список заметок выглядит так:")
        for (i in 0..this.notes.size)
            println ("$i - Архив '${this.notes.get(i)}'")
    }

    fun addArchive () {
        println("Введите название Архива: ")
        var archiveName = ArchiveManip.readInput().trim().toLowerCase().capitalize()

        innerArchive?.add(Archive(archiveName, mutableListOf()))
    }
}