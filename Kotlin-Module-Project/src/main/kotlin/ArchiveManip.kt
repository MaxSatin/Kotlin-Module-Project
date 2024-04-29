import java.util.Scanner


class ArchiveManip {

    companion object {
        var noFirstArchive = true
        var archives = mutableListOf<Archive>()
        var input = Scanner(System.`in`)

        fun createArchive() {
            println("Введите название Архива")
            var name = readInputString()
            while (name.isEmpty()) {
                println("Вы не можете создать Архив без имени. Введите любое название")
                name = readInputString().toLowerCase().capitalize()
            }
            this.noFirstArchive = false
            println("Вы успешно создали Архив '$name!'")
            archives.add(Archive(name, mutableListOf()))
        }

        fun readInputString(): String {
            return input.next().trim()
        }

        fun readInputInt() : Int {
            return input.nextInt()
        }

        fun getMainArchiveList() {
            for (i in 0 until archives.size)
                println("$i - Архив '${archives.get(i).toString()}'")
        }

        fun getArchiveByIndex () : Archive {
            while (!input.hasNextInt()) {
                println("Введите, пожалуйста, номер Архива")
                input.next()
            }
            val index = input.nextInt()
            while (archives.getOrNull(index) == null) {
                while (!input.hasNextInt()) {
                    println("Введите, пожалуйста, номер Архива")
                    input.next()
                }
            }
            return archives.get(index)
        }

        fun start() {
            if (noFirstArchive == true) {
                println("Введите команду:\n 0. Создать Архив\n 1. Выход")
                while (true)
                    when (readInputString()) {
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
