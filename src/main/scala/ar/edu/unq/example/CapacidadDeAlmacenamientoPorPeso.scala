package ar.edu.unq.example

/**
  *
  */
trait CapacidadDeAlmacenamientoPorPeso extends Mochila{

  val pesoMaximo: Int = 1000
  var pesoLibre: Int = pesoMaximo

  def actualizarPeso(unObjetoRecolectable : ObjetoRecolectable, g : Int) : Unit = {
    pesoLibre = pesoLibre - unObjetoRecolectable.peso(g)
  }


}
