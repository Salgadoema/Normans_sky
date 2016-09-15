package ar.edu.unq.example

/**
  * Created by user on 30/08/2016.
  */
class ObjetoRecolectSpec extends BaseSpec {

  "un objeto recolectable su obtenerVolumen()" should "1000 cc3" in {

    val objetoRecolectable = new ObjetoRecolectable(1000, "roca",0)
    objetoRecolectable.obtenerVolumen() shouldBe 1000
  }

  "un objeto recolectable es compactable al preguntarle el tipo " should "compactable" in {

    val objetoRecolectable = new ObjetoRecolectable(1000, "Roca", 0) with ObjetoCompactable
    objetoRecolectable.volumenCompactado() shouldBe 500
    objetoRecolectable.tipo shouldBe "Compactable"
  }

  "un objeto recolectable que no es compactable al preguntarle el tipo " should "No compactable" in {

    val objetoRecolectable = new ObjetoRecolectable(1000, "roca", 0) with NoCompactable
    objetoRecolectable.obtenerVolumen() shouldBe 1000
    objetoRecolectable.tipo shouldBe "No Compactable"
  }

  "un objeto recolectable que es semi-compactable al preguntarle el tipo " should "semi-compactable" in {

    val objetoRecolectable = new ObjetoRecolectable(1000, "Roca", 0) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    objetoRecolectable.obtenerVolumen() shouldBe 900
    objetoRecolectable.tipo shouldBe "Semi-Compactable"
  }

  "un objeto recolectable que es Organico y tiene 30% de agua al deshidratarlo" should "70% volumen" in {

    val objetoRecolectable = new ObjetoRecolectable(1000, "alga", 60) with Organico
    objetoRecolectable.setearPorcentajeDeAgua(30)
    objetoRecolectable.volumenDeshidratado() shouldBe 700
  }

  "Objeto energia 1000 recibe danio de 50 energia dspues del danio " should "950"in{
    val objetoRecolectable = new ObjetoRecolectable(1000, "alga", 60) with Organico

    objetoRecolectable.recibeDanio(50)
    objetoRecolectable.energia shouldBe 950


  }

  "Objeto con masa 60 le pregunto su peso en la tierra" should "588.42"in{
    val objetoRecolectable = new ObjetoRecolectable(1000, "alga", 60) with Organico
    val cuerpoCeleste = new CuerpoCeleste {
      override var gravedad: Int = 10
    }
    objetoRecolectable.peso(cuerpoCeleste.gravedad) shouldBe(600)


  }

  "Objeto con masa 60 le pregunto su peso en Marte" should "588.42"in{
    val objetoRecolectable = new ObjetoRecolectable(1000, "alga", 60) with Organico
    val cuerpoCeleste = new CuerpoCeleste {
      override var gravedad: Int =4
    }
    objetoRecolectable.peso(cuerpoCeleste.gravedad) shouldBe(240)


  }
}
