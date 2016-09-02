package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class MochilaConCapacidadChica extends Mochila {

  val capacidadMaxima: Int=40000
   var capacidadLibre: Int =capacidadMaxima

  def actualizaCapacidadLibre(objetoRecolectable: ObjetoRecolectable) ={
    capacidadLibre = capacidadLibre - objetoRecolectable.obtenerVolumen()
  }


}
