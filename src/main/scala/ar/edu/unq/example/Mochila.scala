package ar.edu.unq.example

import scala.collection.mutable.ListBuffer

/**
  * Created by user on 28/08/2016.
  */
abstract class Mochila {

  def capacidadLibre(): Int
  var objetosRecolectados = ListBuffer[ObjetoRecolectable]()

  def energiaDeObjetos():ListBuffer[Int]  ={
  objetosRecolectados.map { a => a.energia }
  }

  def proteccionAlGolpeDe(golpe: Int): Int = {
    golpe
  }

  def recibeGolpe(valor: Int):Unit={

   objetosRecolectados.foreach { a => a.recibeDanio(proteccionAlGolpeDe(valor))}
  }
  def actualizaCapacidadLibre(objetoRecolectable: ObjetoRecolectable)

  def recolectarObjeto(objetoRecolectable: ObjetoRecolectable) = {

    objetosRecolectados += objetoRecolectable
  }



  def guardarObjeto(objetoRecolectable: ObjetoRecolectable) {

    if (!estaLlena() && puedoGuardar(objetoRecolectable)) {

      recolectarObjeto(objetoRecolectable)
      actualizaCapacidadLibre(objetoRecolectable)
    }
    else
      println(s"No se puede Guardar el objeto de " + objetoRecolectable.obtenerVolumen() + " cc3 de capacidad " +
        "\nCapacidad Libre:" + capacidadLibre + "cc3")
  }

  def puedoGuardar(unObjetoRecolectable: ObjetoRecolectable): Boolean = {
    (0 <= capacidadLibre - unObjetoRecolectable.obtenerVolumen)&&
      (0 <= pesoDisponible)
  }

  def pesoDisponible :Int = 0


  def estaLlena() = {
    capacidadLibre == 0

  }
}