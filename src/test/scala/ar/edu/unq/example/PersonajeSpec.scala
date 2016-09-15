package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class PersonajeSpec extends BaseSpec {

  "creo un Personaje Nuevo con Energia" should "saber su energia" in {
    val unaMochila = new  MochilaConCapacidadChica
    val unPersonaje = new Personaje(150, unaMochila)

    unPersonaje.energia shouldBe 150
  }

  "al personaje se le asigna una mochila chica y cuando le pregunto por la capacidad de la mochila" should "40000cc3" in {


    val unaMochila = new MochilaConCapacidadChica
    val unPersonaje = new Personaje(150, unaMochila )

    unPersonaje.capacidadLibre shouldBe 40000


  }

  " personaje con mochila Mediana  le pregunto por la capacidad de la mochila" should "60000cc3" in {


    val unaMochila = new MochilaConCapacidadMediana
    val unPersonaje = new Personaje(150, unaMochila )
    unPersonaje.capacidadLibre shouldBe 60000


  }

  " personaje con mochila Grande le pregunto por la capacidad de la mochila" should "90000cc3" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila )
    unPersonaje.capacidadLibre shouldBe 90000


  }

    "personaje con mochila chica carga objeto de 1000 y cuando le pregunto por la capacidad de la mochila" should "39000cc3" in {


      val unaMochila = new MochilaConCapacidadChica
      val unPersonaje = new Personaje(150, unaMochila )
      val objetoRecolectable = new ObjetoRecolectable(1000,"pidra", 20)
      unPersonaje.recolectarObjeto(objetoRecolectable)
      unPersonaje.capacidadLibre shouldBe 39000


    }

    " personaje con mochila Mediana carga objeto de 1000  le pregunto por la capacidad de la mochila" should "59000cc3" in {


      val unaMochila = new MochilaConCapacidadMediana
      val unPersonaje = new Personaje(150, unaMochila )
      val objetoRecolectable = new ObjetoRecolectable(1000,"pidra", 20)
      unPersonaje.recolectarObjeto(objetoRecolectable)
      unPersonaje.capacidadLibre shouldBe 59000


    }

    " personaje con mochila Grande carga objeto de 1000 le pregunto por la capacidad de la mochila" should "89000cc3" in {


      val unaMochila = new MochilaConCapacidadGrande
        val unPersonaje = new Personaje(150, unaMochila )
      val objetoRecolectable = new ObjetoRecolectable(1000,"pidra", 20)
      unPersonaje.recolectarObjeto(objetoRecolectable)
        unPersonaje.capacidadLibre shouldBe 89000


      }





  " personaje Traje Liviano pregunto por la capacidad Oxigeno Final" should "1280" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unTrajeLiviano = new TrajeLiviano
    unPersonaje.agregarTraje(unTrajeLiviano)
    unPersonaje.caminarKms(100)
    unPersonaje.capacidadOxigenoFinal() shouldBe 1280
  }

  " personaje Traje Liviano pregunto por la capacidad Oxigeno Final" should "1480" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unTrajeLiviano = new TrajeLiviano
    unPersonaje.agregarTraje(unTrajeLiviano)
    unPersonaje.caminarKms(1)
    unPersonaje.capacidadOxigenoFinal() shouldBe 1480
  }

  " personaje Traje Pesado pregunto por la capacidad Oxigeno Final" should "3858" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unTrajePesado = new TrajePesado
    unPersonaje.agregarTraje(unTrajePesado)
    unPersonaje.caminarKms(50)
    unPersonaje.capacidadOxigenoFinal() shouldBe 3858
  }

  " personaje Traje Pesado pregunto por la capacidad Oxigeno Final" should "3704" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unTrajePesado = new TrajePesado
    unPersonaje.agregarTraje(unTrajePesado)
    unPersonaje.caminarKms(120)
    unPersonaje.capacidadOxigenoFinal() shouldBe 3704
  }

  " personaje Con escudo con proteccion 100 atacan con 50 la energia proteccion restante " should "150" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unEscudo = new Escudo(100)
    unPersonaje.agregarEscudo(unEscudo)
    unPersonaje.recibirDanho(50)
    unPersonaje.energia shouldBe 150

  }

  " personaje Con escudo con proteccion 100 atacan con 150 la energia proteccion restante " should "50" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(100, unaMochila)
    val unEscudo = new Escudo(100)
    unPersonaje.agregarEscudo(unEscudo)
    unPersonaje.recibirDanho(200)
    unPersonaje.energia shouldBe 0

  }

  " personaje Con escudo Recargable con proteccion 100 atacan con 50 la energia proteccion restante al caminar 10Km" should "150" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unEscudo = new Escudo(100) with Recargable
    unPersonaje.agregarEscudo(unEscudo)
    unPersonaje.recibirDanho(50)
    unPersonaje.caminarKms(10)
    unPersonaje.energia shouldBe 150

  }

  " personaje Con escudo Recargable con proteccion 100 atacan con 50 la energia proteccion restante al caminar 1Km" should "150" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unEscudo = new Escudo(100) with Recargable
    unPersonaje.agregarEscudo(unEscudo)
    unPersonaje.recibirDanho(50)
    unPersonaje.caminarKms(1)
    unPersonaje.nivelDeProteccion shouldBe 60

  }


  " personaje Con escudo Recargable y Reflector de daño con proteccion 100 atacan con 50 la energia proteccion " should "50" in {

    val unaMochila = new MochilaConCapacidadGrande
    val otraMochila = new MochilaConCapacidadChica
    val unPersonaje = new Personaje(150, unaMochila)
    var otroPersonaje = new Personaje(150, otraMochila)
    val unEscudo = new Escudo(100) with Recargable with ReflectorDeDanho
    val otroEscudo = new Escudo(100)

    unEscudo.porcentajeDeReflexion(10)
    unPersonaje.agregarEscudo(unEscudo)
    otroPersonaje.agregarEscudo(otroEscudo)

    otroPersonaje= unPersonaje.recibirDanhoDe(50, otroPersonaje)
    unPersonaje.energia shouldBe 150
    otroPersonaje.energia shouldBe 145
  }

  " personaje Con escudo Recargable y absorcion de daño con proteccion 100 atacan con 50 la energia proteccion " should "6" in {

    var unaMochila = new MochilaConCapacidadGrande
    var otraMochila = new MochilaConCapacidadChica
    var unPersonaje = new Personaje(150, unaMochila)
    var otroPersonaje = new Personaje(150, otraMochila)
    var unEscudo = new Escudo(100) with Recargable with AbsorcionDeDanho
    var otroEscudo = new Escudo(100)

    unEscudo.setFactDeAbsorcion(10)
    unPersonaje.agregarEscudo(unEscudo)
    otroPersonaje.agregarEscudo(otroEscudo)

    unPersonaje= unPersonaje.recibirDanhoDe(50, otroPersonaje)
    unPersonaje.poderDeAtaque shouldBe 6
    unPersonaje.energia shouldBe 150

  }




/*
    " personaje Traje Pesado Mochila propulsora con peso 268 y que se propulsa 10 segundos su consumo y altura " should "2680 y 5 respectivamente"in {


      var unaMochila = new MochilaConCapacidadGrande with Propulsora
      unaMochila.propulsarXTiempo(10)
      var unPersonaje = new Personaje(150, unaMochila)
      unPersonaje.miMochila.propulsarXTiempo(10)
      val objetoRecolectable = new ObjetoRecolectable(1000, "roca",67) with SemiCompactable
      objetoRecolectable.setValorDecompacatacion(100)
      val cuerpoCeleste = new CuerpoCeleste {
        override var gravedad: Int =4
      }

      unaMochila.actualizarPeso(objetoRecolectable,4)
      unPersonaje.setCuerpoCeleste(cuerpoCeleste)
      unPersonaje.recolectarObjeto(objetoRecolectable)
      unPersonaje. miMochila.propulsarXTiempo(10)

      unPersonaje.miMochila.consumoPorPropulsion(10) shouldBe (2680)
      unPersonaje.miMochila.posicionEnEjeZ(10) shouldBe(5)

    }
*/
}
