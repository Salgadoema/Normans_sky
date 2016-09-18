package ar.edu.unq.example

import ar.edu.unq.example.armas.{ArmaDeFuego, RiflesLaser}
import ar.edu.unq.example.mochilas.MochilaConCapacidadChica
import ar.edu.unq.example.personaje.Personaje

class CombateAMuerteSpec extends BaseSpec {

  "unPersonaje mata a otro con un ArmaDeFuego" should "otro muerto" in{
    var unaMochila = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with ArmaDeFuego
    var otro = new Personaje(5, unaMochila)

    unPersonaje atacar(otro)
    otro.getEnergia shouldBe 2
    unPersonaje atacar(otro)
    otro.getEnergia shouldBe 0 //muerto
  }

  "unPersonaje con RifleLaser mata a otro con un ArmaDeFuego" should "otro muerto" in{
    var unaMochila = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(30, unaMochila) with RiflesLaser
    var otro = new Personaje(25, unaMochila) with ArmaDeFuego

    unPersonaje combatirAMuerte(unPersonaje, otro)
    unPersonaje.getEnergia shouldBe 24
    otro.getEnergia shouldBe 0
  }

  "unPersonaje mata a otro con un ArmaDeFuego" should "sequeda sin balas" in{
    var unaMochila = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(140, unaMochila) with ArmaDeFuego
    var otro = new Personaje(140, unaMochila)

    unPersonaje combatirAMuerte(unPersonaje, otro)
    otro.getEnergia shouldBe 122
     //ninguno muerto
  }

}
