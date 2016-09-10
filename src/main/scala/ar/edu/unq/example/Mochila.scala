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

  def puedoGuardar(unObjetoRecolectable: ObjetoRecolectable): Boolean
  //Este metodo esta como abstracto y en las 3 subclases hace lo mismo
  //Estoy repitiendo código a lo pavote, pero me descajeta lo del peso a futuro
  //hay q resolverlo con los traits y no me está saliendo


  def estaLlena() : Boolean= {
    capacidadLibre == 0 ||
    pesoMochila == 0
  }

  def pesoMochila : Int = 1
  //Esto tmb está mal, hay que resolverlo con los traits pero no me estaría
  // funcionando como quisiera
}