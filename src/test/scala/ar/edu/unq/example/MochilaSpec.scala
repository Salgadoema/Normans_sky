package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class MochilaSpec extends BaseSpec{

"una mochila Chica" should "su capacidad 40000 cc3" in{


  val unaMochila= new MochilaConCapacidadChica

  unaMochila.capacidadMaxima shouldBe 40000
  unaMochila.capacidadLibre shouldBe 40000

}

  "una mochila Mediana" should "su capacidad 60000 cc3" in{

    val unaMochila= new MochilaConCapacidadMediana

    unaMochila.capacidadMaxima shouldBe 60000
  }

  "una mochila Grande" should "su capacidad 90000 cc3" in{

    val unaMochila= new MochilaConCapacidadGrande

    unaMochila.capacidadMaxima shouldBe 90000
  }

  "una mochila chica despues de guardar objeto de 1000 su capacidadlibre" should " 39000 cc3" in{

    val unaMochila= new MochilaConCapacidadChica
    val objetoRecolectable = new ObjetoRecolectable(1000,"Roca",0)
    unaMochila.capacidadMaxima shouldBe 40000
    unaMochila.capacidadLibre shouldBe 40000

    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.capacidadLibre shouldBe 39000

  }


  "una mochila chica despues de guardar varios objetos queda llena Su capacidad Libre" should "su capacidad 0 cc3" in{

    val unaMochila= new MochilaConCapacidadChica
    val objetoRecolectable = new ObjetoRecolectable(1000,"roca", 0)
    val otroObjetoRecolectable = new ObjetoRecolectable(5000,"Planta", 45)
    val objetoRecolectable2 = new ObjetoRecolectable(34000, "Termotanque", 5)



    unaMochila.capacidadMaxima shouldBe 40000
    unaMochila.capacidadLibre shouldBe 40000

    unaMochila.guardarObjeto(objetoRecolectable)
    unaMochila.guardarObjeto(otroObjetoRecolectable)
    unaMochila.guardarObjeto(objetoRecolectable2)

    unaMochila.capacidadLibre shouldBe 0
    unaMochila.estaLlena shouldBe true
  }

  "una mochila chica llena no recibe mas objetos" should "Indica mochila llena" in{

    val unaMochila= new MochilaConCapacidadChica
    val objetoRecolectable = new ObjetoRecolectable(1000, "Roca", 0)
    val otroObjetoRecolectable = new ObjetoRecolectable(5000, "Planta", 30)
    val objetoRecolectable2 = new ObjetoRecolectable(34000, "Termotanque", 5)

    unaMochila.capacidadMaxima shouldBe 40000
    unaMochila.capacidadLibre shouldBe 40000

    unaMochila.guardarObjeto(objetoRecolectable)
    unaMochila.guardarObjeto(otroObjetoRecolectable)
    unaMochila.guardarObjeto(objetoRecolectable2)

    unaMochila.capacidadLibre shouldBe 0
    unaMochila.estaLlena shouldBe true
  }

  "una mochila chica no llena no puede recibe objetos mas grandes que su capacidad libre" should "Indica mochila llena" in{

    val unaMochila= new MochilaConCapacidadChica
    val objetoRecolectable = new ObjetoRecolectable(1000,"roca", 10)
    val otroObjetoRecolectable = new ObjetoRecolectable(5000, "Planta", 10)
    val objetoRecolectable2 = new ObjetoRecolectable(32000, "Auto", 15)
    unaMochila.capacidadMaxima shouldBe 40000
    unaMochila.capacidadLibre shouldBe 40000

    unaMochila.guardarObjeto(objetoRecolectable)
    unaMochila.guardarObjeto(otroObjetoRecolectable)
    unaMochila.guardarObjeto(objetoRecolectable2)

    unaMochila.capacidadLibre shouldBe 2000
    unaMochila.estaLlena shouldBe false

    unaMochila.guardarObjeto(otroObjetoRecolectable)
  }

  /********COMPACTACION*********************/

  "una mochila chica Con CompactacionPorVacio guarda un objeto no Compactable de 1000 y al preguntarle la capacidad libre" should "39000" in{

    val unaMochila= new MochilaConCapacidadChica with CompactacionPorVacio

    val objetoRecolectable = new ObjetoRecolectable(1000, "roca", 0) with NoCompactable
    unaMochila.capacidadMaxima shouldBe 40000
    unaMochila.capacidadLibre shouldBe 40000

    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.capacidadLibre shouldBe 39000

    unaMochila.estaLlena shouldBe false
  }

  "una mochila chica Con CompactacionPorVacio guarda un objeto Compactable de 1000 y al preguntarle la capacidad libre" should "39500" in{

    val unaMochila= new MochilaConCapacidadChica with CompactacionPorVacio
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca", 0) with ObjetoCompactable
    val otraMochila = new MochilaConCapacidadChica
    otraMochila.guardarObjeto(objetoRecolectable)

    unaMochila.capacidadMaxima shouldBe 40000
    unaMochila.capacidadLibre shouldBe 40000

    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.capacidadLibre shouldBe 39500
    otraMochila.capacidadLibre shouldBe 39000
    unaMochila.estaLlena shouldBe false
  }


  "una mochila chica Con CompactacionPorVacio guarda un objeto SemiCompactable de 1000 con compactabilidad=100 y al preguntarle la capacidad libre" should "39500" in{

    val unaMochila= new MochilaConCapacidadChica with CompactacionPorVacio
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca", 0) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    unaMochila.capacidadMaxima shouldBe 40000
    unaMochila.capacidadLibre shouldBe 40000

    unaMochila.guardarObjeto(objetoRecolectable)
    objetoRecolectable.obtenerVolumen() shouldBe 900

    unaMochila.capacidadLibre shouldBe 39100
    unaMochila.estaLlena shouldBe false
  }

  "una mochila chica Deshidratadora guarda un objeto Organico con porc de agua de 40 al deshidratarlo y preguntarle la capacidad libre" should "39500" in{

    val unaMochila= new MochilaConCapacidadChica with Deshidratadora
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca", 0) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    unaMochila.capacidadMaxima shouldBe 40000
    unaMochila.capacidadLibre shouldBe 40000

    unaMochila.guardarObjeto(objetoRecolectable)
    objetoRecolectable.obtenerVolumen() shouldBe 900

    unaMochila.capacidadLibre shouldBe 39100
    unaMochila.estaLlena shouldBe false
  }


  /*****************************************/
  /**************DAÑO***********************/
  /*****************************************/


  "mochila rigida recibe daño de 100 absorve 50% con un objeto de 1000puntos le pregunto al objeto energia dsp del golpe" should "950" in{
    val unaMochila= new MochilaConCapacidadGrande with Deshidratadora with Rigida {
      override var porcDeProteccion: Int = 50
      }
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca",10) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.energiaDeObjetos() shouldBe List(1000)
    //unaMochila.porcentajeDeProteccionDedanio(50)
    unaMochila.recibeGolpe(100)
    unaMochila.energiaDeObjetos shouldBe List(950)

  }

  "mochila SemiRigida recibe daño de 100 absorve 20 con un objeto de 1000puntos le pregunto al objeto energia dsp del golpe" should "980" in{
    val unaMochila= new MochilaConCapacidadGrande with Deshidratadora with SemiRigida {
      override var constDeAbsorbcion: Int = 20
    }
    val objetoRecolectable = new ObjetoRecolectable(10, "roca", 0) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.energiaDeObjetos() shouldBe List(1000)
    unaMochila.recibeGolpe(100)
    unaMochila.energiaDeObjetos shouldBe List(920)

  }


  /*****************************************/
  /***********CAPACIDAD*X*PESO**************/
  /*****************************************/

"Mochila en CuerpoCeleste de gravedad 15 guarda objeto de masa 10" should "mochila con elemento" in{
  val unObjeto = new ObjetoRecolectable(10, "piedra", 10)
  val unaMochila = new MochilaConCapacidadChica with CapacidadDeAlmacenamientoPorPeso with CuerpoCeleste
      {override var gravedad: Int = 15}
  unaMochila guardarObjeto unObjeto
  unaMochila.objetosRecolectados shouldBe List(unObjeto)
  //Este test da ok, pero es una mentira x lo que anote en el test que sigue
  }




  "Mochila en CuerpoCeleste de gravedad 15 guarda objeto de masa 1000" should "capacidad" in{
    //Falta este test, peeeeeero ya se que rompe porque el objeto lo guarda igual.
    //Supongo que el problema está en la anidacion de los traits

}


}
