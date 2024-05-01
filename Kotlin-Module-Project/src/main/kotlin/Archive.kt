class Archive (
    val name : String,
    var notes: MutableList<Note>
) {
    var innerArchive: MutableList<Archive>? = null

    fun createNote() {
        println("Введите заголовок заметки: ")
        var noteName = ArchiveManip.readInputString().trim().toLowerCase().capitalize()
        while (noteName.isEmpty()) {
            println("Нельзя создать пустую заметку!")
            noteName = ArchiveManip.readInputString().trim().toLowerCase().capitalize()
        }
        println("Введите текст заметки: ")
        var noteContents = ArchiveManip.readInputString()
        while (noteContents.isEmpty()) {
            println("Нельзя создать пустую заметку!")
            noteContents = ArchiveManip.readInputString().trim().toLowerCase().capitalize()
        }
        this.notes.add(Note(noteName, noteContents))
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
            println("\nCписок заметок выглядит так:")
            for (i in 0 until this.notes.size)
                println("$i - ${this.notes.get(i).name}")
        }
    }

    fun deleteNote() {
        println("Заметку с каким номером нужно удалить?")
        var index = ArchiveManip.readInputInt()
        while (index < 0 || index >= this.notes.size) {
            println("Заметки с таким номером не существует!\n" +
                    "Введите номер заметки повторно или на '-1' для выхода")
            index = ArchiveManip.readInputInt()
            if (index == -1)
                return
        }
        println("Заметка ${this.notes.get(index).name} удалена\n")
        this.notes.removeAt(index)


        printNotes()
    }

    fun getNote() {
        if (checkIfIsEmpty()) {
            println("Архив пуст!")
            return
        }
        else {
            println("Введите номер заметки: ")
            var index = ArchiveManip.readInputInt()
            while (index < 0 || index >= this.notes.size) {
                println("Заметки с таким номером не существует!\n" +
                        "Введите номер заметки повторно или на '-1' для выхода")
                index = ArchiveManip.readInputInt()
                if (index == -1)
                    return
            }
            println("${this.notes.get(index).toString()}")
        }
    }

    private fun checkIfIsEmpty () : Boolean {
        return this.notes.isEmpty()
    }
    private fun checkAndCorrectIfEmpty (string : String) : String {
        var newString = ""
        if (string.isEmpty()) {
            println("Нельзя создать пустую заметку!")
            newString = ArchiveManip.readInputString().trim().toLowerCase().capitalize()
            while (newString.isEmpty()) {
                println("Нельзя создать пустую заметку!")
                newString = ArchiveManip.readInputString().trim().toLowerCase().capitalize()
            }
            return newString
        }
        return string
    }
    fun addArchive() {
        println("Введите название Архива: ")
        var archiveName = ArchiveManip.readInputString().trim().toLowerCase().capitalize()

        innerArchive?.add(Archive(archiveName, mutableListOf()))
    }

    fun renameNote() {
        println("\nВыберите номер заметки, которую хотите изменить")
        this.printNotes()
        var noteNumber = ArchiveManip.readInputInt()
        while (true) {
            println(
                "Текущая заметка:" +
                        "\nНазвание: ${this.notes.get(noteNumber).name} " +
                        "\nСодержание: ${this.notes.get(noteNumber).contents}" +
                        "\nЧто вы ходите сделать?" +
                        "\n1 - Переименовать название;" +
                        "\n2 - Переименовать содержание;" +
                        "\n3 - Выйти из редактирования"
            )
            while (true)
                when (ArchiveManip.readInputString()) {
                    "1" -> { println("Введите новое название заметки");
                        var newName = checkAndCorrectIfEmpty(ArchiveManip.readInputString());
                        this.notes.get(noteNumber).name = newName
                        println("Название переименовано.\n Введите следующую команду");
                    }
                    "2" -> {println("Введите новое содержание заметки")
                        var newContents = checkAndCorrectIfEmpty(ArchiveManip.readInputString())
                        this.notes.get(noteNumber).contents = newContents;
                        println("Содержание переименовано");
                    }
                    "3" -> return
                    else -> println("Вы вводите неверную команду")
                }
        }
    }

        override fun toString(): String {
            return "$name"
        }
}
