package Ch18 {
  package Ex03 {
    object Title
    object Author

    class Document {
      private var useNextArgs: Any = null
      var title: String = ""
      var author: String = ""

      def set(obj: Title.type): this.type = {
        useNextArgs = obj
        this
      }
      def set(obj: Author.type): this.type = {
        useNextArgs = obj
        this
      }
      def to(arg: String): this.type = {
        if (useNextArgs == Title) {
          title = arg
        }
        else if (useNextArgs == Author) {
          author = arg
        }
        useNextArgs = null
        this
      }
    }

    object Main extends App {
      var book = new Document
      book set Title to "Book title" set Author to "Any Author"
    }
  }
}

