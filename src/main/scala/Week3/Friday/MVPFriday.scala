package Week3.Friday

object MVPFriday extends App{

  case class Name(value: String)

  object Name {
    val pattern = ".*\\d.*".r // matches any string that contains at least one digit.
    // .*: Matches any character (except for line terminators) zero or more times.
    // \\d: Matches any digit (equivalent to [0-9]).
    // .r on a string converts it into a regular expression object of type scala.util.matching.Regex.

    def nameOrError(maybeName: String): Either[InvalidNameError, Name] =
      maybeName match {
        case pattern() => Left(InvalidNameError("Not a valid name"))
        case _ => Right(Name(maybeName))
      }
  }

  case class Postcode(value: String)

  object Postcode{
    def postcodeOrError(maybePostcode: String): Either[InvalidPostcodeError, Postcode] =
      maybePostcode match {
        case _ @ s"$_ $_" => Right(Postcode(maybePostcode)) //FORMATTING!
        case _ => Left(InvalidPostcodeError("Not a valid postcode"))
      }
  }

  case class Letter(name: Name, postCode: Postcode)

  object Letter {
    def letterOrError(maybeName: String, maybePostcode: String): Either[GenericPostageError, Letter] =
      for {
        name <- Name.nameOrError(maybeName)
        postCode <- Postcode.postcodeOrError(maybePostcode)
      } yield {
        Letter(name, postCode)
      }
  }

  trait GenericPostageError {
    def message: String
  }

  case class InvalidNameError(message: String) extends GenericPostageError

  case class InvalidPostcodeError(message: String) extends GenericPostageError

  private val letter: Right[Nothing, Letter] = Right(Letter(Name("Simon Singh"), Postcode("AB12 CD3")))

  private val invalidLetter: Left[InvalidNameError, Nothing] = Left(InvalidNameError("Not a name!!!"))
  private val letterWithANumberInName: Either[GenericPostageError, Letter] =
    Letter.letterOrError(maybeName = "Muhammad Mulla123", maybePostcode = "AB12 CD3")

  private val letterWithAnInvalidPostcode: Either[GenericPostageError, Letter] =
    Letter.letterOrError(maybeName = "Muhammad Mulla", maybePostcode = "AB12CD3")

  private val letterAllInvalid: Either[GenericPostageError, Letter] =
    Letter.letterOrError(maybeName = "Muhammad Mulla123", maybePostcode = "AB12CD3")
}
