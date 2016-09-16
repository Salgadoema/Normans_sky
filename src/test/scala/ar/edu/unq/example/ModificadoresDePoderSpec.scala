package ar.edu.unq.example

/**
  * Created by damian on 16/09/16.
  */
class ModificadoresDePoderSpec extends BaseSpec{

  "unPersonaje con duplicador de ataque" should "2" in {
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with Duplicador

    unPersonaje.getPoderDeAtaque shouldBe 2
  }

  "unPersonaje con ArmaDeFuego y duplicador" should "6" in {
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with ArmaDeFuego with Duplicador

    unPersonaje.getPoderDeAtaque shouldBe 6
  }

  "unPersonaje con ArmaRara de poder 5 y duplicador" should "10" in {
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with ArmaRara with Duplicador

    unPersonaje.poderRaroDeAtaque(5)
    unPersonaje.getPoderDeAtaque shouldBe 10
  }

  "unPersonaje con RifleLaser y duplicador ataca 3 veces" should "20, 18, 16, 14" in {
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with RiflesLaser with Duplicador
    var otro = new Personaje(1000, unaMochila)

    unPersonaje.getPoderDeAtaque shouldBe 20
    unPersonaje.atacar(otro)
    unPersonaje.getPoderDeAtaque shouldBe 18
    unPersonaje.atacar(otro)
    unPersonaje.getPoderDeAtaque shouldBe 16
    unPersonaje.atacar(otro)
    unPersonaje.getPoderDeAtaque shouldBe 14
  }
}
