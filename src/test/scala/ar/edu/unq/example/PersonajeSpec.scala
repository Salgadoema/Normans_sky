package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class PersonajeSpec extends BaseSpec {

  "creo un Personaje Nuevo con Energia" should "saber su energia" in {
    val unaMochila = new  MochilaConCapacidadChica
    val unPersonaje = new Personaje(150, unaMochila)

    unPersonaje.miEnergia shouldBe (150)
  }

  "al personaje se le asigna una mochila chica y cuando le pregunto por la capacidad de la mochila" should "40000cc3" in {


    val unaMochila = new MochilaConCapacidadChica
    val unPersonaje = new Personaje(150, unaMochila )

    unPersonaje.capacidadLibre shouldBe (40000)


  }

  " personaje con mochila Mediana  le pregunto por la capacidad de la mochila" should "60000cc3" in {


    val unaMochila = new MochilaConCapacidadMediana
    val unPersonaje = new Personaje(150, unaMochila )
    unPersonaje.capacidadLibre shouldBe (60000)


  }

  " personaje con mochila Grande le pregunto por la capacidad de la mochila" should "90000cc3" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila )
    unPersonaje.capacidadLibre shouldBe (90000)


  }

    "personaje con mochila chica carga objeto de 1000 y cuando le pregunto por la capacidad de la mochila" should "39000cc3" in {


      val unaMochila = new MochilaConCapacidadChica
      val unPersonaje = new Personaje(150, unaMochila )
      val objetoRecolectable = new ObjetoRecolectable(1000, "piedra", )
      unPersonaje.recolectarObjeto(objetoRecolectable)
      unPersonaje.capacidadLibre shouldBe (39000)


    }

    " personaje con mochila Mediana carga objeto de 1000  le pregunto por la capacidad de la mochila" should "59000cc3" in {


      val unaMochila = new MochilaConCapacidadMediana
      val unPersonaje = new Personaje(150, unaMochila )
      val objetoRecolectable = new ObjetoRecolectable(1000, "roca", )
      unPersonaje.recolectarObjeto(objetoRecolectable)
      unPersonaje.capacidadLibre shouldBe (59000)


    }

    " personaje con mochila Grande carga objeto de 1000 le pregunto por la capacidad de la mochila" should "89000cc3" in {


      val unaMochila = new MochilaConCapacidadGrande
        val unPersonaje = new Personaje(150, unaMochila )
      val objetoRecolectable = new ObjetoRecolectable(1000, "Martillo", )
      unPersonaje.recolectarObjeto(objetoRecolectable)
        unPersonaje.capacidadLibre shouldBe (89000)


      }



*/

  " personaje Traje Liviano pregunto por la capacidad Oxigeno Final" should "1490" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unTrajeLiviano = new TrajeLiviano
    unPersonaje.agregarTraje(unTrajeLiviano)
    unPersonaje.caminarKms(1000)
    unPersonaje.capacidadOxigenoFinal() shouldBe (1490)
  }

  " personaje Traje Liviano pregunto por la capacidad Oxigeno Final" should "1499.85" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unTrajeLiviano = new TrajeLiviano
    unPersonaje.agregarTraje(unTrajeLiviano)
    unPersonaje.caminarKms(1)
    unPersonaje.capacidadOxigenoFinal() shouldBe (1499.85)
  }

  " personaje Traje Pesado pregunto por la capacidad Oxigeno Final" should "4000" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unTrajePesado = new TrajePesado
    unPersonaje.agregarTraje(unTrajePesado)
    unPersonaje.caminarKms(50)
    unPersonaje.capacidadOxigenoFinal() shouldBe (4000)
  }

  " personaje Traje Pesado pregunto por la capacidad Oxigeno Final" should "3986" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unTrajePesado = new TrajePesado
    unPersonaje.agregarTraje(unTrajePesado)
    unPersonaje.caminarKms(120)
    unPersonaje.capacidadOxigenoFinal() shouldBe (3986)
  }

}
