package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class MochilaConCapacidadGrande extends Mochila {

  val capacidadMaxima: Int=90000
  var capacidadLibre : Int= capacidadMaxima
  val pesoMaximo: Int = 1000
  var pesoLibre: Int = pesoMaximo
  var pesoTotal=pesoMaximo-pesoLibre

  def actualizaCapacidadLibre(objetoRecolectable: ObjetoRecolectable) ={
    capacidadLibre = capacidadLibre - objetoRecolectable.obtenerVolumen()
  }

  def actualizarPeso(unObjetoRecolectable : ObjetoRecolectable, g : Int) : Unit = {
    pesoLibre = pesoLibre - unObjetoRecolectable.peso(g)
  }
}
