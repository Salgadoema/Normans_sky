package ar.edu.unq.example

/**
  *
  */
class EscudoSpec extends BaseSpec{

  "creo un escudo con proteccion 100 le pregnto su proteccion" should "100" in {

    val unEscudo = new Escudo(100)
    unEscudo.proteccion shouldBe 100
  }

  "creo un escudo con proteccion 300 le pregnto su proteccion" should "300" in {

    val unEscudo = new Escudo(300)
    unEscudo.proteccion shouldBe 300
  }


  "creo un escudo con proteccion 300 le pregnto su proteccion si recibe daño de 50" should "250" in {

    val unEscudo = new Escudo(300)
    unEscudo.proteccion shouldBe 300
    unEscudo.proteccionEscudoAlRecibirDanhoDe(50)
    unEscudo.proteccion shouldBe(250)
  }

  "creo un escudo con proteccion 300 le pregnto su proteccion si recibe daño de 350" should "0" in {

    val unEscudo = new Escudo(300)
    unEscudo.proteccion shouldBe 300
    unEscudo.proteccionEscudoAlRecibirDanhoDe(350)
    unEscudo.proteccion shouldBe(0)
  }
  "creo un escudo Recargable con proteccion 300 le pregnto su proteccion al caminar20km" should "500" in {

    val unEscudo = new Escudo(300) with Recargable
    unEscudo.proteccion shouldBe 300
    unEscudo.recargar(20)
    unEscudo.proteccion shouldBe(500)
  }

  "escudo Recargable con proteccion 100 atacan con 50 la energia proteccion restante al caminar 1Km" should "60" in {

   val unEscudo = new Escudo(100) with Recargable
   unEscudo.proteccionEscudoAlRecibirDanhoDe(50)
   unEscudo.recargar(1)
  unEscudo.proteccion shouldBe(60)

}

  "escudo Recargable y reflector con proteccion 100 atacan con 50 la energia proteccion restante al caminar 1Km" should "60" in {

    val unEscudo = new Escudo(100) with Recargable with ReflectorDeDanho
    val unaMochila = new MochilaConCapacidadGrande
    val otraMochila = new MochilaConCapacidadChica
    var defensor = new Personaje(150, otraMochila)
    var atacante = new Personaje(150, unaMochila)
    unEscudo.porcentajeDeReflexion(10)
    unEscudo.proteccionEscudoAlRecibirDanhoDe(50)

    atacante=unEscudo.reacciona(50, atacante, defensor)
    unEscudo.proteccion shouldBe(50)
    atacante.energia shouldBe 145
    defensor.energia shouldBe 150

  }
}
