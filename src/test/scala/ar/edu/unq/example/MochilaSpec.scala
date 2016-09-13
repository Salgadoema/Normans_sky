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
    val objetoRecolectable = new ObjetoRecolectable(1000,"Roca",10)
    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe(40000)

    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.capacidadLibre shouldBe (39000)

  }


  "una mochila chica despues de guardar varios objetos queda llena Su capacidad Libre" should "su capacidad 0 cc3" in{

    val unaMochila= new MochilaConCapacidadChica
    val objetoRecolectable = new ObjetoRecolectable(1000,"roca",10)
    val otroObjetoRecolectable = new ObjetoRecolectable(5000,"Planta",9)
    val objetoRecolectable2 = new ObjetoRecolectable(34000, "Termotanque",9)



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
    val objetoRecolectable = new ObjetoRecolectable(1000, "Roca",9)
    val otroObjetoRecolectable = new ObjetoRecolectable(5000, "Planta",9)
    val objetoRecolectable2 = new ObjetoRecolectable(34000, "Termotanque",9)

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
    val objetoRecolectable = new ObjetoRecolectable(1000,"roca",9)
    val otroObjetoRecolectable = new ObjetoRecolectable(5000, "Planta",87)
    val objetoRecolectable2 = new ObjetoRecolectable(32000, "Auto",87)
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

    val objetoRecolectable = new ObjetoRecolectable(1000, "roca",34) with NoCompactable
    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe(40000)

    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.capacidadLibre shouldBe (39000)

    unaMochila.estaLlena shouldBe (false)
  }

  "una mochila chica Con CompactacionPorVacio guarda un objeto Compactable de 1000 y al preguntarle la capacidad libre" should "39500" in{

    val unaMochila= new MochilaConCapacidadChica with CompactacionPorVacio
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca",45) with ObjetoCompactable
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
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca",67) with SemiCompactable
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
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca",56) with Organico
    objetoRecolectable.setearPorcentajeDeAgua(50)
    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe(40000)

    unaMochila.guardarObjeto(objetoRecolectable)
    objetoRecolectable.obtenerVolumen() shouldBe(500)

    unaMochila.capacidadLibre shouldBe (39500)
    unaMochila.estaLlena shouldBe (false)
  }


  "mochila rigida recibe daño de 100 absorve 50% con un objeto de 1000puntos le pregunto al objeto energia dsp del golpe" should "950" in{
    val unaMochila= new MochilaConCapacidadGrande with Deshidratadora with Rigida {

      override var porcDeProteccion: Int = 50
    }
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca",78) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.energiaDeObjetos() shouldBe (List(1000))
    unaMochila.recibeGolpe(100)
    unaMochila.energiaDeObjetos shouldBe(List(950))
//commit
  }


  "mochila SemiRigida recibe daño de 100 absorve 20 con un objeto de 1000puntos le pregunto al objeto energia dsp del golpe" should "980" in{
    val unaMochila= new MochilaConCapacidadGrande with Deshidratadora with SemiRigida {
      override var constDeAbsorbcion: Int = 20
    }
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca",88) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    unaMochila.guardarObjeto(objetoRecolectable)

    unaMochila.energiaDeObjetos() shouldBe (List(1000))
    unaMochila.recibeGolpe(100)
    unaMochila.energiaDeObjetos shouldBe List(920)

  }


  "una mochila chica Con CompactacionPorVacio guarda un objeto Compactable de 1000 y al preguntarle la capacidad libre en peso" should "820" in {

    val unaMochila = new MochilaConCapacidadChica with CompactacionPorVacio
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca", 45) with ObjetoCompactable
    val cuerpoCeleste = new CuerpoCeleste {
      override var gravedad: Int =4
    }
    objetoRecolectable.peso(cuerpoCeleste.gravedad)
    unaMochila.actualizarPeso(objetoRecolectable,cuerpoCeleste.gravedad)
    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe (40000)
    unaMochila.guardarObjeto(objetoRecolectable)
    unaMochila.capacidadLibre shouldBe (39500)

    unaMochila.estaLlena shouldBe (false)
    unaMochila.pesoLibre shouldBe (820)
    unaMochila.pesoMaximo shouldBe (1000)
  }

  "una mochila chica Con CompactacionPorVacio guarda un objeto SemiCompactable de 1000 con compactabilidad=100 y al preguntarle la capacidad libre en peso" should "732" in{

    val unaMochila= new MochilaConCapacidadChica with CompactacionPorVacio
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca",67) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    val cuerpoCeleste = new CuerpoCeleste {
      override var gravedad: Int =4
    }
    objetoRecolectable.peso(cuerpoCeleste.gravedad)
    unaMochila.actualizarPeso(objetoRecolectable,cuerpoCeleste.gravedad)
    unaMochila.capacidadMaxima shouldBe (40000)
    unaMochila.capacidadLibre shouldBe(40000)

    unaMochila.guardarObjeto(objetoRecolectable)
    objetoRecolectable.obtenerVolumen() shouldBe(900)

    unaMochila.capacidadLibre shouldBe (39100)
    unaMochila.estaLlena shouldBe (false)
    unaMochila.pesoLibre shouldBe (732)
    unaMochila.pesoMaximo shouldBe (1000)
  }

  "unaMochila propulsora con peso 268 y que se propulsa 10 segundos su consumo y altura " should "2680 y 5 respectivamente"in{

    val unaMochila= new MochilaConCapacidadChica with CompactacionPorVacio with Propulsora
    val objetoRecolectable = new ObjetoRecolectable(1000, "roca",67) with SemiCompactable
    objetoRecolectable.setValorDecompacatacion(100)
    val cuerpoCeleste = new CuerpoCeleste {
      override var gravedad: Int =4
    }

    unaMochila.actualizarPeso(objetoRecolectable,cuerpoCeleste.gravedad)

    unaMochila.propulsarXTiempo(10,unaMochila.pesoTotal)
    unaMochila.pesoTotal shouldBe(268)
   // unaMochila.pesoAcumulado(4) shouldBe(268)
    unaMochila.pesoLibre shouldBe (732)
    unaMochila.consumo shouldBe(2680)
    unaMochila.altura shouldBe(5)
  }
}

