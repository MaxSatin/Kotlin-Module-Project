class Display {
    companion object {
        lateinit var archiveByIndex: Archive
        fun mainDisplay() {
            while (true) {
                println(
                    "Выберите дальнейшие действия:\n" +
                            "0. Создать еще один Архив\n" +
                            "1. Выбрать созданный Архив из списка\n" +
                            "2. Выход"
                )
                while (true) {
                    when (ArchiveManip.readInputString()) {
                        "0" -> { ArchiveManip.createArchive(); break }
                        "1" -> { ArchiveManip.getMainArchiveList(); archiveListDisplay(); break }
                        "2" -> return
                        else -> println("Вы вводите неверную команду")
                    }
                }
            }
        }
        fun archiveListDisplay() {

            while (true) {
                println(
                    "Выберите дальнейшие действия:\n" +
                            "0. Просмотреть заметки Архива под номером: (?) \n" +
                            "1. Вернуться в предыдущее меню\n" +
                            "2. Выход"
                )
                while (true)
                    when (ArchiveManip.readInputString()) {
                        "0" -> { archiveByIndex = ArchiveManip.getArchiveByIndex()
                            archiveByIndex.printNotes()
                            archiveDisplay(); break }
                        "1" -> {mainDisplay(); break }
                        "2" -> return
                        else -> println("Вы вводите неверную команду")
                    }
            }
        }

        fun archiveDisplay() {
            while (true) {
                println(
                    "Выберите дальнейшие действия:\n" +
                            "0. Просмотреть список заметок \n" +
                            "1. Создать заметку \n" +
                            "2. Удалить заметку\n" +
                            "3. Редактировать заметку" +
                            "4. Вернуться в предыдущее меню\n" +
                            "5. Выход"
                )
                while (true)
                    when (ArchiveManip.readInputString()) {
                        "0" -> {archiveByIndex.printNotes()}
                        "1" -> {archiveByIndex.createNote()}
                        "2" -> {archiveByIndex.deleteNote(ArchiveManip.readInputInt())}
                        "3" -> {archiveByIndex.renameNote()}
                        "4" -> {archiveListDisplay()}
                        "5" -> return
                        else -> println("Вы вводите неверную команду")
                    }
            }
        }
    }
}