class Archive (
    val name : String,
    var notes: MutableList<Note>
) {
    var innerArchive: MutableList<Archive>? = null

    fun createNote() {
        println("Введите заголовок заметки: ")
        var noteName = ArchiveManip.readInputString().trim().toLowerCase().capitalize()

        println("Введите текст заметки: ")
        var noteContents = ArchiveManip.readInputString()
        notes.add(Note(noteName, noteContents))
        println("Заметка: $noteName успешно добавлена")
    }

    fun printInnerArchive() {
        if (innerArchive?.isEmpty() == true) {
            println("Архив не содержит вложенных архивов")
        } else {
            for (i in 0..this.innerArchive!!.size)
                println("$i - Архив '${this.innerArchive?.get(i)}'")
        }
    }

    fun printNotes() {
        if (this.notes.isEmpty()) {
            println("Архив не содержит заметок")
        } else {
            for (i in 0 until this.notes.size)
                println("$i - ${this.notes.get(i).name}")
        }
    }

    fun deleteNote(index: Int) {
        this.notes.removeAt(index)
        println("Теперь список заметок выглядит так:")
        for (i in 0..this.notes.size)
            println("$i - Архив '${this.notes.get(i)}'")
    }

    fun getNote(index: Int) {
        this.notes.get(ArchiveManip.readInputInt())
    }

    fun addArchive() {
        println("Введите название Архива: ")
        var archiveName = ArchiveManip.readInputString().trim().toLowerCase().capitalize()

        innerArchive?.add(Archive(archiveName, mutableListOf()))
    }

    fun renameNote() {
        println("Выберите номер заметки, которую хотите изменить")
        this.printNotes()
        var noteNumber = ArchiveManip.readInputInt()
        println(
            "Текущая заметка:" +
                    "Название: ${this.notes.get(noteNumber).name} " +
                    "Содержание: ${this.notes.get(noteNumber).contents}" +
                    "Что вы ходите сделать?" +
                    "1 - Переименовать название;" +
                    "2 - Переименовать содержание;" +
                    "3 - Выйти из редактирования"
        )
        while (true)
            when (ArchiveManip.readInputString()) {
                "1" -> { this.notes.get(noteNumber).name = ArchiveManip.readInputString()}
                "2" -> {this.notes.get(noteNumber).contents = ArchiveManip.readInputString() }
                "3" -> return
                else -> println("Вы вводите неверную команду")
            }
    }

        override fun toString(): String {
            return "$name"
        }
}
