package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class MochilaConCapacidadMediana extends Mochila{

  val capacidadMaxima: Int=60000
  var capacidadLibre : Int= capacidadMaxima
  val pesoMaximo: Int = 1000
  var pesoLibre: Int = pesoMaximo
  var pesoTotal=pesoMaximo-pesoLibre

  def actualizaCapacidadLibre(objetoRecolectable: ObjetoRecolectable) ={
    capacidadLibre = capacidadLibre - objetoRecolectable.obtenerVolumen()
  }
  override def puedoGuardar(unObjetoRecolectable: ObjetoRecolectable): Boolean = {
    0 <= capacidadLibre - unObjetoRecolectable.obtenerVolumen
  }

  def actualizarPeso(unObjetoRecolectable : ObjetoRecolectable, g : Int) : Unit = {
    pesoLibre = pesoLibre - unObjetoRecolectable.peso(g)
  }

}
