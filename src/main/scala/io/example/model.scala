package io.example

import com.linktargeting.elasticsearch.api.Document
import com.linktargeting.elasticsearch.api.translation.ESDocument
import io.circe.generic.semiauto._

import scala.language.postfixOps

object model {
  case class Person(id: Int, first: String, last: String)

  implicit val personEnc = deriveEncoder[Person]
  implicit val personDec = deriveDecoder[Person]

  implicit val personDocument = new ESDocument[Person] {
    def document(a: Person) = Document(a.id.toString, Map(
      "id" → a.id,
      "first" → a.first,
      "last" → a.last
    ))
  }


}
