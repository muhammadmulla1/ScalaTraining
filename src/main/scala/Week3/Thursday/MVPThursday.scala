package Week3.Thursday

object MVPThursday extends App {

  case class FinancialInfo(salary: Double, deposit: Double, purchasePrice: Double, creditScore: Int)

  object MortgageCalculator {
    def canGetMortgage(financialInfo: FinancialInfo): Either[String, Double] = {
      val mortgageLimit = financialInfo.salary * 4
      val requiredDeposit = financialInfo.purchasePrice * 0.10

      if (financialInfo.creditScore < 550) {
        Left("Credit score is too low to qualify for a mortgage.")
      } else if (financialInfo.deposit < requiredDeposit) {
        Left(s"Insufficient deposit. Required deposit is $requiredDeposit.")
      } else {
        Right(mortgageLimit)
      }
    }

    def canPurchaseFlat(financialInfo: FinancialInfo):Either[String, String] = {
      canGetMortgage(financialInfo) match {
        case Left(error) => Left(error)
        case Right(mortgageLimit) =>
          if (mortgageLimit + financialInfo.deposit >= financialInfo.purchasePrice) {
            Right("Samantha can purchase the flat at the asking price.")
          } else {
            Left("Samantha cannot purchase the flat at the asking price.")
          }
      }
    }
  }

    val samanthaInfo = FinancialInfo(salary = 45000, deposit = 20000, purchasePrice = 280000, creditScore = 577)

    val mortgageEligibility = MortgageCalculator.canGetMortgage(samanthaInfo)
    println(mortgageEligibility)

    val purchaseEligibility = MortgageCalculator.canPurchaseFlat(samanthaInfo)
    println(purchaseEligibility)
}


