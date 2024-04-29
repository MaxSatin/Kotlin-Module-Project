class Display {
    companion object {
        lateinit var archiveByIndex: Archive
        fun mainDisplay() {
            while (true) {
                println(
                    "Выберите дальнейшие действия:\n" +
                            "0. Создать еще один Архив\n" +
                            "1. Показать список Архивов\n" +
                            "2. Выход"
                )
                while (true) {
                    when (ArchiveManip.readInputString()) {
                        "0" -> {
                            ArchiveManip.createArchive(); break
                        }

                        "1" -> {
                            ArchiveManip.getMainArchiveList();
                            Display.archiveListDisplay(); break
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
                    "Выберите дальнейшие действия:\n" +
                            "0. Просмотреть содержимое Архива под номером: (?) \n" +
                            "1. Вернуться в предыдущее меню\n" +
                            "2. Выход"
                )
                while (true)
                    when (ArchiveManip.readInputString()) {
                        "0" -> {
                            archiveByIndex = ArchiveManip.getArchiveByIndex()
                            archiveByIndex.printNotes();
                            Display.archiveDisplay(); break
                        }

                        "1" -> {
                            Display.mainDisplay(); break
                        }

                        "2" -> return
                        else -> println("Вы вводите неверную команду")
                    }

            }
        }

        fun archiveDisplay() {
            while (true) {
                println(
                    "Выберите дальнейшие действия:\n" +
                            "0. Создать заметку \n" +
                            "1. Удалить заметку\n" +
                            "2. Вернуться в предыдущее меню\n" +
                            "3. Выход"
                )
                while (true)
                    when (ArchiveManip.readInputString()) {
                        "0" -> {
                            archiveByIndex.createNote(); break
                        }

                        "1" -> {
                            archiveByIndex.deleteNote(ArchiveManip.readInputInt()); break
                        }

                        "2" -> Display.archiveListDisplay()
                        else -> println("Вы вводите неверную команду")
                    }
            }
        }
    }
}