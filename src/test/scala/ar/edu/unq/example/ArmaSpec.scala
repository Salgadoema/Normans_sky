package ar.edu.unq.example

/**
  * Created by user on 14/09/2016.
  */
class ArmaSpec extends BaseSpec{

"un Personaje con ArmaDeFuego ataca a otroPersonaje de energia 10" should "7" in{

    var unaMochila   = new MochilaConCapacidadChica
    var otraMochila  = new MochilaConCapacidadChica
    var unPersonaje  = new Personaje(50, unaMochila) with ArmaDeFuego
    //ArmaDeFuego inicializa con 6 balas
    var otroPersonaje = new Personaje(10, otraMochila)

    unPersonaje atacar otroPersonaje

    otroPersonaje.energia shouldBe 7
    unPersonaje.cantDeBalas shouldBe 5
  }

  "Idem Anterior pero unPersonaje ataca 7 veces otroPersonaje tiene energia 30" should "12" in{

    var unaMochila   = new MochilaConCapacidadChica
    var otraMochila  = new MochilaConCapacidadChica
    var unPersonaje  = new Personaje(50, unaMochila) with ArmaDeFuego
    var otroPersonaje = new Personaje(30, otraMochila)

    unPersonaje atacar otroPersonaje
    otroPersonaje.energia shouldBe 27
    unPersonaje.cantDeBalas shouldBe 5

    unPersonaje atacar otroPersonaje
    otroPersonaje.energia shouldBe 24
    unPersonaje.cantDeBalas shouldBe 4

    unPersonaje atacar otroPersonaje
    otroPersonaje.energia shouldBe 21
    unPersonaje.cantDeBalas shouldBe 3

    unPersonaje atacar otroPersonaje
    otroPersonaje.energia shouldBe 18
    unPersonaje.cantDeBalas shouldBe 2

    unPersonaje atacar otroPersonaje
    otroPersonaje.energia shouldBe 15
    unPersonaje.cantDeBalas shouldBe 1

    unPersonaje atacar otroPersonaje
    otroPersonaje.energia shouldBe 12
    unPersonaje.cantDeBalas shouldBe 0

    unPersonaje atacar otroPersonaje
    otroPersonaje.energia shouldBe 12
    unPersonaje.cantDeBalas shouldBe 0

  }

  "unPersonaje con RifleLaser ataca 5 veces a otroPersonaje de energia 50, energia de otroPersonaje" should "35" in {

    var unaMochila   = new MochilaConCapacidadChica
    var otraMochila  = new MochilaConCapacidadChica
    var unPersonaje  = new Personaje(50, unaMochila) with RiflesLaser
    var otroPersonaje = new Personaje(50, otraMochila)

    unPersonaje atacar otroPersonaje
    otroPersonaje.energia shouldBe 40
    unPersonaje.celdasDeEnergia shouldBe 9

    unPersonaje atacar otroPersonaje
    otroPersonaje.energia shouldBe 31
    unPersonaje.celdasDeEnergia shouldBe 8

    unPersonaje atacar otroPersonaje
    otroPersonaje.energia shouldBe 23
    unPersonaje.celdasDeEnergia shouldBe 7

    unPersonaje atacar otroPersonaje
    otroPersonaje.energia shouldBe 16
    unPersonaje.celdasDeEnergia shouldBe 6

    unPersonaje atacar otroPersonaje
    otroPersonaje.energia shouldBe 10
    unPersonaje.celdasDeEnergia shouldBe 5

  }

  "unPersonaje que tiene 100 de energia equipado con ArmaRara de 50 de poderRaro ataca a otroPersonaje con 75 de enrgia" should "25" in {


    var unaMochila   = new MochilaConCapacidadChica
    var otraMochila  = new MochilaConCapacidadChica
    var unPersonaje  = new Personaje(100, unaMochila) with ArmaRara
    var otroPersonaje = new Personaje(75, otraMochila)

    unPersonaje.poderRaroDeAtaque(50)
    unPersonaje.atacar(otroPersonaje)
    otroPersonaje.energia shouldBe 25
    unPersonaje.energia shouldBe 50
  }

  "unPersonaje que tiene 100 de energia equipado con ArmaRara de 150 de poderRaro ataca a otroPersonaje con 75 de energia" should "75" in {


    var unaMochila   = new MochilaConCapacidadChica
    var otraMochila  = new MochilaConCapacidadChica
    var unPersonaje  = new Personaje(100, unaMochila) with ArmaRara
    var otroPersonaje = new Personaje(75, otraMochila)

    unPersonaje.poderRaroDeAtaque(150)
    unPersonaje.atacar(otroPersonaje)
    otroPersonaje.energia shouldBe 75
    unPersonaje.energia shouldBe 100
    //El ataque no se realiza porque no le acanza la energia para efectuar el ataque
  }
}
