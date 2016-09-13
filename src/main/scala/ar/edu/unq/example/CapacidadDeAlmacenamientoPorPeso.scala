package ar.edu.unq.example

/**
  * Created by user on 30/08/2016.
  */
trait CapacidadDeAlmacenamientoPorPeso extends Mochila{

  val pesoMaximo: Int = 1000
  var pesoLibre: Int = pesoMaximo

  def actualizarPeso(unObjetoRecolectable : ObjetoRecolectable, g : Int) : Unit = {
    pesoLibre = pesoLibre - unObjetoRecolectable.peso(g)
  }
 /* override def puedoGuardar(unObjetoRecolectable: ObjetoRecolectable): Boolean = {
    (0 <= capacidadLibre - unObjetoRecolectable.obtenerVolumen) &&
      (0 <= pesoLibre)
  }

 override def estaLlena() ={
   capacidadLibre == 0 ||
     pesoLibre == 0
 }*/

}
