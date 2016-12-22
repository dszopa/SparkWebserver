package entity

class KPost {

    var id: String? = null
    var title: String? = null
    var nameOfPoster: String? = null
    var text: String? = null

    override fun toString(): String {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", nameOfPoster='" + nameOfPoster + '\'' +
                ", text='" + text + '\'' +
                '}'
    }
}
