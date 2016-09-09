package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class MochilaSpec extends BaseSpec{

"una mochila Chica" should "su capacidad 40000 cc3" in{


  val unaMochila= new MochilaConCapacidadChica

  unaMochila.capacidadMaxima shouldBe (40000)
  unaMochila.capacidadLibre shouldBe(40000)

}

  "una mochila Mediana" should "su capacidad 60000 cc3" in{

    val unaMochila= new MochilaConCapacidadMediana

    unaMochila.capacidadMaxima shouldBe (60000)
  }

  "una mochila Grande" should "su capacidad 90000 cc3" in{

    val unaMochila= new MochilaConCapacidadGrande

    unaMochila.capacidadMaxima shouldBe (90000)
  }

  "una mochila chica despues de guardar objeto de 1000 su capacidadlibre" should " 39000 cc3" in{

    val unaMochila= new MochilaConCapacidadChica
    val objetoRecolectable = new ObjetoRecolectable(1000,"Roca")
    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe(40000)

    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.capacidadLibre shouldBe (39000)

  }


  "una mochila chica despues de guardar varios objetos queda llena Su capacidad Libre" should "su capacidad 0 cc3" in{

    val unaMochila= new MochilaConCapacidadChica
    val objetoRecolectable = new ObjetoRecolectable(1000,"roca")
    val otroObjetoRecolectable = new ObjetoRecolectable(5000,"Planta")
    val objetoRecolectable2 = new ObjetoRecolectable(34000, "Termotanque")



    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe(40000)

    unaMochila.guardarObjeto(objetoRecolectable)
    unaMochila.guardarObjeto(otroObjetoRecolectable)
    unaMochila.guardarObjeto(objetoRecolectable2)

    unaMochila.capacidadLibre shouldBe (0)
    unaMochila.estaLlena shouldBe (true)
  }

  "una mochila chica llena no recibe mas objetos" should "Indica mochila llena" in{

    val unaMochila= new MochilaConCapacidadChica
    val objetoRecolectable = new ObjetoRecolectable(1000, "Roca")
    val otroObjetoRecolectable = new ObjetoRecolectable(5000, "Planta")
    val objetoRecolectable2 = new ObjetoRecolectable(34000, "Termotanque")

    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe(40000)

    unaMochila.guardarObjeto(objetoRecolectable)
    unaMochila.guardarObjeto(otroObjetoRecolectable)
    unaMochila.guardarObjeto(objetoRecolectable2)

    unaMochila.capacidadLibre shouldBe (0)
    unaMochila.estaLlena shouldBe (true)
  }

  "una mochila chica no llena no puede recibe objetos mas grandes que su capacidad libre" should "Indica mochila llena" in{

    val unaMochila= new MochilaConCapacidadChica
    val objetoRecolectable = new ObjetoRecolectable(1000,"roca")
    val otroObjetoRecolectable = new ObjetoRecolectable(5000, "Planta")
    val objetoRecolectable2 = new ObjetoRecolectable(32000, "Auto")
    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe(40000)

    unaMochila.guardarObjeto(objetoRecolectable)
    unaMochila.guardarObjeto(otroObjetoRecolectable)
    unaMochila.guardarObjeto(objetoRecolectable2)

    unaMochila.capacidadLibre shouldBe (2000)
    unaMochila.estaLlena shouldBe (false)

    unaMochila.guardarObjeto(otroObjetoRecolectable)
  }

  /********COMPACTACION*********************/

  "una mochila chica Con CompactacionPorVacio guarda un objeto no Compactable de 1000 y al preguntarle la capacidad libre" should "39000" in{

    val unaMochila= new MochilaConCapacidadChica with CompactacionPorVacio

    val objetoRecolectable = new ObjetoRecolectable(1000, "roca", ) with NoCompactable
    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe(40000)

    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.capacidadLibre shouldBe (39000)

    unaMochila.estaLlena shouldBe (false)
  }

  "una mochila chica Con CompactacionPorVacio guarda un objeto Compactable de 1000 y al preguntarle la capacidad libre" should "39500" in{

    val unaMochila= new MochilaConCapacidadChica with CompactacionPorVacio
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca", ) with ObjetoCompactable
    val otraMochila = new MochilaConCapacidadChica
    otraMochila.guardarObjeto(objetoRecolectable)

    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe(40000)

    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.capacidadLibre shouldBe (39500)
    otraMochila.capacidadLibre shouldBe (39000)
    unaMochila.estaLlena shouldBe (false)
  }


  "una mochila chica Con CompactacionPorVacio guarda un objeto SemiCompactable de 1000 con compactabilidad=100 y al preguntarle la capacidad libre" should "39500" in{

    val unaMochila= new MochilaConCapacidadChica with CompactacionPorVacio
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca", ) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe(40000)

    unaMochila.guardarObjeto(objetoRecolectable)
    objetoRecolectable.obtenerVolumen() shouldBe(900)

    unaMochila.capacidadLibre shouldBe (39100)
    unaMochila.estaLlena shouldBe (false)
  }

  "una mochila chica Deshidratadora guarda un objeto Organico con porc de agua de 40 al deshidratarlo y preguntarle la capacidad libre" should "39500" in{

    val unaMochila= new MochilaConCapacidadChica with Deshidratadora
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca", ) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe(40000)

    unaMochila.guardarObjeto(objetoRecolectable)
    objetoRecolectable.obtenerVolumen() shouldBe(900)

    unaMochila.capacidadLibre shouldBe (39100)
    unaMochila.estaLlena shouldBe (false)
  }


  "mochila rigida recibe daño de 100 absorve 50% con un objeto de 1000puntos le pregunto al objeto energia dsp del golpe" should "950" in{
    val unaMochila= new MochilaConCapacidadGrande with Deshidratadora with Rigida {
      override var porcDeProteccion: Int = 50
    }
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca", ) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.energiaDeObjetos() shouldBe (List(1000))
    unaMochila.porcentajeDeProteccionDedanio(50)
    unaMochila.recibeGolpe(100)
    unaMochila.energiaDeObjetos shouldBe(List(950))

  }

  "mochila SemiRigida recibe daño de 100 absorve 20 con un objeto de 1000puntos le pregunto al objeto energia dsp del golpe" should "980" in{
    val unaMochila= new MochilaConCapacidadGrande with Deshidratadora with SemiRigida {
      override var constDeAbsorbcion: Int = 20
    }
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca") with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.energiaDeObjetos() shouldBe (List(1000))
    unaMochila.recibeGolpe(100)
    unaMochila.energiaDeObjetos shouldBe List(920)

  }




    unaMochila.energiaDeObjetos() shouldBe (List(1000))
    unaMochila.recibeGolpe(100)
    unaMochila.energiaDeObjetos shouldBe List(920)

  }

}
