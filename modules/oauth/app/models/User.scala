package models

import org.bson.types.ObjectId
import play.api.libs.json._

/**
 * @author kuzmentsov@gmail.com
 * @version 1.0
 */
case class User (
    val _id: Option[ObjectId],
    val name: String,
    val email: String,
    val password: String,
    val grantType: String
)

object UserFormat {
  implicit val userFormat = Json.format[User]

  implicit val objectIdFormat: Format[ObjectId] = new Format[ObjectId] {

    def reads(json: JsValue) = {
      json match {
        case jsString: JsString => {
          if ( ObjectId.isValid(jsString.value) ) JsSuccess(new ObjectId(jsString.value))
          else JsError("Invalid ObjectId")
        }
        case other => JsError("Can't parse json path as an ObjectId. Json content = " + other.toString())
      }
    }

    def writes(oId: ObjectId): JsValue = {
      JsString(oId.toString)
    }

  }
}
