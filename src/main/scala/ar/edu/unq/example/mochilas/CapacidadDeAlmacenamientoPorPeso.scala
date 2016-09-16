package ar.edu.unq.example.mochilas

import ar.edu.unq.example.objetosRecolectables.ObjetoRecolectable

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
