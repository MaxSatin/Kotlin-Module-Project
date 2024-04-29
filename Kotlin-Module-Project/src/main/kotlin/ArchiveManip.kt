import java.util.Scanner


class ArchiveManip {

    companion object {
        var noFirstArchive = true
        val archives = mutableListOf<Archive>()

        fun createArchive() {
            println("Введите название Архива")
            var name = readInput()
            while (name.isEmpty()) {
                println("Вы не можете создать Архив без имени. Введите любое название")
                name = readInput().toLowerCase().capitalize()
            }
            this.noFirstArchive = false
            println("Вы успешно создали Архив '$name!'")
            archives.add(Archive(name, mutableListOf()))
        }

        fun readInput(): String {
            var input = Scanner(System.`in`).next().trim()
            return input
        }

        fun getMainArchiveList() {
            for (i in 0..archives.size)
                println("$i - Архив '${archives.get(i).toString()}'")
        }


        fun start() {
            if (noFirstArchive == true) {
                println("Введите команду:\n 0. Создать Архив\n 1. Выход")
                while (true)
                    when (readInput()) {
                        "0" -> {
                            createArchive(); break
                        }

                        "1" -> return
                        else -> println("Вы вводите неверную команду")
                    }
            } else
                Display.mainDisplay()

            Display.mainDisplay()
        }

    }
}
