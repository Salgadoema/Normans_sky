package ar.edu.unq.example

/**
  * Created by damian on 16/09/16.
  */
class ModificadoresDePoderSpec extends BaseSpec{

  /**************************************************/
  /*                  DUPLICADORES                  */
  /**************************************************/

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

  /**************************************************/
  /*                 POTENCIADORES                  */
  /**************************************************/

  "unPersonaje con potenciador de 5" should "6" in {
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with Potenciador

    unPersonaje.setValorAgregadoDePotenciador(5)
    unPersonaje.getPoderDeAtaque shouldBe 6
  }

  "unPersonaje con ArmaDeFuego y Potenciador de 6" should "9" in {
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with ArmaDeFuego with Potenciador

    unPersonaje.setValorAgregadoDePotenciador(6)
    unPersonaje.getPoderDeAtaque shouldBe 9
  }

  "unPersonaje con ArmaRara de poder 5 y Potenciador de 3" should "8" in {
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with ArmaRara with Potenciador

    unPersonaje.setValorAgregadoDePotenciador(3)
    unPersonaje.poderRaroDeAtaque(5)
    unPersonaje.getPoderDeAtaque shouldBe 8
  }

  "unPersonaje con RifleLaser y potenciador de 4 ataca 3 veces" should "14, 13, 12, 11" in {
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with RiflesLaser with Potenciador
    var otro = new Personaje(1000, unaMochila)

    unPersonaje.setValorAgregadoDePotenciador(4)
    unPersonaje.getPoderDeAtaque shouldBe 14
    unPersonaje.atacar(otro)
    unPersonaje.getPoderDeAtaque shouldBe 13
    unPersonaje.atacar(otro)
    unPersonaje.getPoderDeAtaque shouldBe 12
    unPersonaje.atacar(otro)
    unPersonaje.getPoderDeAtaque shouldBe 11
  }

  /**************************************************/
  /*                  CANCELADORES                  */
  /**************************************************/

  "unPersonaje con cancelador" should "0" in {
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with Cancelador

    unPersonaje.getPoderDeAtaque shouldBe 0
  }

  "unPersonaje con ArmaDeFuego y Cancelador" should "0" in {
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with ArmaDeFuego with Cancelador

    unPersonaje.getPoderDeAtaque shouldBe 0
  }

  "unPersonaje con ArmaRara de poder 5 y Cancelador" should "0" in {
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with ArmaRara with Cancelador

    unPersonaje.poderRaroDeAtaque(5)
    unPersonaje.getPoderDeAtaque shouldBe 0
  }

  "unPersonaje con RifleLaser y Cancelador ataca 3 veces" should "10, 0, 0, 0" in {
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with RiflesLaser with Cancelador
    var otro = new Personaje(1000, unaMochila)

    unPersonaje.getPoderDeAtaque shouldBe 0
    unPersonaje.atacar(otro)
    unPersonaje.getPoderDeAtaque shouldBe 0
    unPersonaje.atacar(otro)
    unPersonaje.getPoderDeAtaque shouldBe 0
    unPersonaje.atacar(otro)
    unPersonaje.getPoderDeAtaque shouldBe 0
  }

  /**************************************************/
  /*         MODIFICADOR POR ESTADO FISICO          */
  /**************************************************/

  "unPersonaje con un RifleLaser que camina 20km y su poder de ataque es" should "6" in{
    var unaMochila  = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(10, unaMochila) with RiflesLaser with EstadoFisico

    unPersonaje.caminarKms(20)
    unPersonaje.getPoderDeAtaque shouldBe 6
  }

}
