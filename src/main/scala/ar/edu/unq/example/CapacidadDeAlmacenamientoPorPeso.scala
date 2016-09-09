package ar.edu.unq.example

/**
  * Created by user on 30/08/2016.
  */
trait  CapacidadDeAlmacenamientoPorPeso extends Mochila{

  val pesoMaximo: Int = 10000
  var pesoLibre: Int = pesoMaximo

  def actualizarPeso(unObjetoRecolectable : ObjetoRecolectable, g : Int) : Unit = {
    pesoLibre = pesoLibre - unObjetoRecolectable.peso(g)
  }

  override def pesoDisponible: Int = pesoLibre

}
