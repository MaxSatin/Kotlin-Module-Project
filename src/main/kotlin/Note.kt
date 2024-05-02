data class Note (var name: String, var contents: String) {

    override fun toString(): String {
        return "\nНазвание: $name\nСодержание: $contents"
    }
}



