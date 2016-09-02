package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class MochilaConCapacidadMediana extends Mochila{

  val capacidadMaxima: Int=60000
  var capacidadLibre : Int= capacidadMaxima

  def actualizaCapacidadLibre(objetoRecolectable: ObjetoRecolectable) ={
    capacidadLibre = capacidadLibre - objetoRecolectable.obtenerVolumen()
  }

}
