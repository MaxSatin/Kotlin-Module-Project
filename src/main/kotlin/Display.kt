class Display {
    companion object {
        lateinit var archiveByIndex: Archive

        fun entryDisplay () {
            if (ArchiveManipulator.noFirstArchive == true) {
                println("Введите команду:\n 0. Создать Архив\n 1. Назад")
                while (true)
                    when (ArchiveManipulator.readInputString()) {
                        "0" -> {ArchiveManipulator.createArchive();
                            break
                        }
                        "1" -> return
                        else -> println("Вы вводите неверную команду")
                    }
            } else
                mainDisplay()
        }

        fun mainDisplay() {
            while (true) {
                println(
                    "\nВыберите дальнейшие действия:\n" +
                            "0. Создать еще один Архив\n" +
                            "1. Выбрать созданный Архив из списка\n" +
                            "2. Выход"
                )
                while (true) {
                    when (ArchiveManipulator.readInputString()) {
                        "0" -> { ArchiveManipulator.createArchive();
                            break
                        }
                        "1" -> { ArchiveManipulator.getMainArchiveList(); archiveListDisplay();
                            break
                        }
                        "2" -> return
                        else -> println("Вы вводите неверную команду")
                    }
                }
            }
        }
        fun archiveListDisplay() {

            while (true) {
                println(
                    "\nВыберите дальнейшие действия:\n" +
                            "0. Просмотреть заметки Архива и создать новые \n" +
                            "1. Список Архивов\n" +
                            "2. Назад"
                )
                while (true)
                    when (ArchiveManipulator.readInputString()) {
                        "0" -> {println("Введите номер Архива:");
                            archiveByIndex = ArchiveManipulator.getArchiveByIndex()
                            archiveByIndex.printNotes()
                            archiveDisplay();
                            break
                        }
                        "1" -> ArchiveManipulator.getMainArchiveList()
                        "2" -> return
                        else -> println("Вы вводите неверную команду")
                    }
            }
        }

        fun archiveDisplay() {
            while (true) {
                println(
                    "\nВыберите дальнейшие действия:\n" +
                            "0. Список заметок\t1. Выбрать заметку\n" +
                            "2. Создать заметку\t3. Удалить заметку\n" +
                            "4. Редактировать  \t5. Выход\n")
                while (true)
                    when (ArchiveManipulator.readInputString()) {
                        "0" -> {archiveByIndex.printNotes();
                            break}
                        "1" -> {archiveByIndex.getNote();
                            break}
                        "2" -> {archiveByIndex.createNote();
                            break}
                        "3" -> {archiveByIndex.deleteNote();
                            break}
                        "4" -> {archiveByIndex.renameNote();
                            break}
                        "5" -> return
                        else -> println("Вы вводите неверную команду")
                    }
            }
        }
    }
}