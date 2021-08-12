data class Note(
    var id: Int = 0,
    var title: String,
    var text: String,
    val date: Int = 0,
    val comments: Int = 0,
    val viewUrl: String = "https://www.vk.com",
    val canComment: Boolean = true
)