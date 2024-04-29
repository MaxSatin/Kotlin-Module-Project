class Display {
    companion object {
        fun mainDisplay() {
            while (true) {
                println(
                    "Выберите дальнейшие действия:\n" +
                            "0. Создать еще один Архив\n" +
                            "1. Показать список Архивов\n" +
                            "2. Выход"
                )
                while (true) {
                    when (ArchiveManip.readInput()) {
                        "0" -> {
                            ArchiveManip.createArchive(); break
                        }

                        "1" -> {
                            ArchiveManip.getMainArchiveList(); break
                        }

                        "2" -> return
                        else -> println("Вы вводите неверную команду")
                    }
                }
                while (true)
                    when (ArchiveManip.readInput()) {
                        "0" -> {
                            ArchiveManip.createArchive(); break
                        }

                        "1" -> {
                            ArchiveManip.getMainArchiveList(); break
                        }

                        "2" -> return
                        else -> println("Вы вводите неверную команду")
                    }


                fun archiveDisplay() {


                }
            }
        }
    }
}