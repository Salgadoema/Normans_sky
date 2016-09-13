package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class PersonajeSpec extends BaseSpec {
/*
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
      val objetoRecolectable = new ObjetoRecolectable(1000)
      unPersonaje.recolectarObjeto(objetoRecolectable)
      unPersonaje.capacidadLibre shouldBe (39000)


    }

    " personaje con mochila Mediana carga objeto de 1000  le pregunto por la capacidad de la mochila" should "59000cc3" in {


      val unaMochila = new MochilaConCapacidadMediana
      val unPersonaje = new Personaje(150, unaMochila )
      val objetoRecolectable = new ObjetoRecolectable(1000)
      unPersonaje.recolectarObjeto(objetoRecolectable)
      unPersonaje.capacidadLibre shouldBe (59000)


    }

    " personaje con mochila Grande carga objeto de 1000 le pregunto por la capacidad de la mochila" should "89000cc3" in {


      val unaMochila = new MochilaConCapacidadGrande
        val unPersonaje = new Personaje(150, unaMochila )
      val objetoRecolectable = new ObjetoRecolectable(1000)
      unPersonaje.recolectarObjeto(objetoRecolectable)
        unPersonaje.capacidadLibre shouldBe (89000)


      }





  " personaje Traje Liviano pregunto por la capacidad Oxigeno Final" should "1490" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unTrajeLiviano = new TrajeLiviano
    unPersonaje.agregarTraje(unTrajeLiviano)
    unPersonaje.caminarKms(1000)
    unPersonaje.capacidadOxigenoFinal() shouldBe (1490)
  }

  " personaje Traje Liviano pregunto por la capacidad Oxigeno Final" should "1500" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unTrajeLiviano = new TrajeLiviano
    unPersonaje.agregarTraje(unTrajeLiviano)
    unPersonaje.caminarKms(1)
    unPersonaje.capacidadOxigenoFinal() shouldBe (1500)
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

  " personaje Traje Pesado Mochila propulsora con peso 268 y que se propulsa 10 segundos su consumo y altura " should "2680 y 5 respectivamente"in {


    val unaMochila = new MochilaConCapacidadGrande with Propulsora
    val unPersonaje = new Personaje(150, unaMochila)
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca",67) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    val cuerpoCeleste = new CuerpoCeleste {
      override var gravedad: Int =4
    }

    unaMochila.actualizarPeso(objetoRecolectable,4)
    unPersonaje.setCuerpoCeleste(cuerpoCeleste)
    unPersonaje.recolectarObjeto(objetoRecolectable)
    //unPersonaje.propulsarXTiempo(unaMochila,10)

    unPersonaje.miConsumoPorPropulsion shouldBe (2680)
    unPersonaje.miAlturaPorPropulsion shouldBe(5)

  }

*/
  " personaje Con escudo con proteccion 100 atacan con 50 la energia proteccion restante " should "50" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unEscudo = new Escudo(100)
    unPersonaje.agregarEscudo(unEscudo)
    unPersonaje.recibirDanho(50)
    unPersonaje.nivelDeProteccion() shouldBe(50)

  }

  " personaje Con escudo con proteccion 100 atacan con 150 la energia proteccion restante " should "50" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unEscudo = new Escudo(100)
    unPersonaje.agregarEscudo(unEscudo)
    unPersonaje.recibirDanho(150)
    unPersonaje.nivelDeProteccion() shouldBe(0)

  }

  " personaje Con escudo Recargable con proteccion 100 atacan con 50 la energia proteccion restante al caminar 10Km" should "150" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unEscudo = new Escudo(100) with Recargable
    unPersonaje.agregarEscudo(unEscudo)
    unPersonaje.recibirDanho(50)
    unPersonaje.caminarKms(10)
    unPersonaje.nivelDeProteccion shouldBe(150)

  }

  " personaje Con escudo Recargable con proteccion 100 atacan con 50 la energia proteccion restante al caminar 1Km" should "150" in {


    val unaMochila = new MochilaConCapacidadGrande
    val unPersonaje = new Personaje(150, unaMochila)
    val unEscudo = new Escudo(100) with Recargable
    unPersonaje.agregarEscudo(unEscudo)
    unPersonaje.recibirDanho(50)
    unPersonaje.caminarKms(1)
    unPersonaje.nivelDeProteccion shouldBe(60)

  }


  " personaje Con escudo Recargable y Reflector de daño con proteccion 100 atacan con 50 lakk energia proteccion " should "50" in {

    val unaMochila = new MochilaConCapacidadGrande
    val otraMochila = new MochilaConCapacidadChica
    val unPersonaje = new Personaje(150, unaMochila)
    val otroPersonaje= new Personaje(150, otraMochila)
    val unEscudo = new Escudo(100) with Recargable with ReflectorDeDanho
    val otroEscudo = new Escudo(100)

    unPersonaje.agregarEscudo(unEscudo)
    otroPersonaje.agregarEscudo(otroEscudo)
    unPersonaje.porcentajeDeReflexion(5)
    unPersonaje.recibirDanho(50)
    otroPersonaje.recibirDanho(unPersonaje.reflejarDanho())


    unPersonaje.nivelDeProteccion shouldBe(50)
    otroPersonaje.nivelDeProteccion shouldBe (98)
  }


}
