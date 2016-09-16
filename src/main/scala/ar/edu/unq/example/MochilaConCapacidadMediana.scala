package ar.edu.unq.example

/**
  *
  */
class MochilaConCapacidadMediana extends Mochila{

  val pesoMaximo: Int = 1000
  val capacidadMaxima: Int=60000
  var capacidadLibre : Int= capacidadMaxima
  var pesoLibre: Int = pesoMaximo
  var pesoTotal=pesoMaximo-pesoLibre

  def actualizaCapacidadLibre(objetoRecolectable: ObjetoRecolectable) =
    capacidadLibre = capacidadLibre - objetoRecolectable.obtenerVolumen()

  override def puedoGuardar(unObjetoRecolectable: ObjetoRecolectable): Boolean =
    0 <= capacidadLibre - unObjetoRecolectable.obtenerVolumen


  def actualizarPeso(unObjetoRecolectable : ObjetoRecolectable, g : Int) : Unit =
    pesoLibre = pesoLibre - unObjetoRecolectable.peso(g)


}
