package ar.edu.unq.example

class GolondrinaSpec extends BaseSpec {



  "unaGolodnrina" should "saber su energia" in{

    val pepita= new Golondrina(550)
    pepita.energia shouldBe 550

    pepita.volar(100)
    pepita.energia shouldBe(450)

    pepita.volar(100)
    pepita.energia shouldBe(350)

    pepita.viajesLargos shouldBe(List(100,100))
  }

  "Una golondrina" should "perder energia al volar" in {
    val pepita = new Golondrina(100)
    pepita.energia shouldBe  100

    pepita.volar(75)
    pepita.energia shouldBe 25
  }

  it should "saber sus viajes largos" in {
    val pepita = new Golondrina(100)
    pepita.volar(75)
    pepita.volar(50)

    pepita.viajesLargos should be (List(75))
  }
}