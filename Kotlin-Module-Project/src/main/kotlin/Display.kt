class Display {
    companion object {
        fun mainDisplay () {
            println(
                "Выберите дальнейшие действия:\n" +
                        "0. Создать еще один Архив\n" +
                        "1. Это уже созданный мной архив\n" +
                        "2. Выход"
            )
            while(true)
                when (ArchiveManip.readInput()) {
                    "0" -> { ArchiveManip.createArchive(); break}
                    "1" ->
                    "2" -> return
                    else -> println("Вы вводите неверную команду")
                }

            fun archiveDisplay () {


            }
}