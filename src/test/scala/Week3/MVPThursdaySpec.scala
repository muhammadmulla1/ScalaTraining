package Week3

import Week3.Thursday.MVPThursday
import Week3.Thursday.MVPThursday._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MVPThursdaySpec extends AnyFlatSpec with Matchers {

  it should "determine if Samantha can get a mortgage" in {
    val financialInfo = FinancialInfo(45000, 2000, 280000, 577)
    val result = MVPThursday.MortgageCalculator.canGetMortgage(financialInfo)
    result should be (Left("Insufficient deposit. Required deposit is 28000.0."))
  }

  it should "determine if Samantha can purchase the flat" in {
    val financialInfo = FinancialInfo(45000, 20000, 280000, 577)
    val result = MVPThursday.MortgageCalculator.canPurchaseFlat(financialInfo)
    result should be (Left("Samantha cannot purchase the flat at the asking price."))
  }

  it should "reject mortgage application due to low credit score" in {
    val financialInfo = FinancialInfo(45000, 20000, 280000, 500)
    val result = MVPThursday.MortgageCalculator.canGetMortgage(financialInfo)
    result should be (Left("Credit score is too low to qualify for a mortgage."))
  }

  it should "reject mortgage application due to insufficient deposit" in {
    val financialInfo = FinancialInfo(45000, 10000, 280000, 577)
    val result = MVPThursday.MortgageCalculator.canGetMortgage(financialInfo)
    result should be (Left("Insufficient deposit. Required deposit is 28000.0."))
  }
}
