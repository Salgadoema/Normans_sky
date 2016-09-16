package ar.edu.unq.example

/**
  *
  */
class MochilaConCapacidadChica extends Mochila {

  val pesoMaximo: Int = 1000
  val capacidadMaxima: Int = 40000
  var capacidadLibre: Int = capacidadMaxima
  var pesoLibre: Int = pesoMaximo
  var pesoTotal=pesoMaximo-pesoLibre


  def actualizaCapacidadLibre(objetoRecolectable: ObjetoRecolectable) =
    capacidadLibre = capacidadLibre - objetoRecolectable.obtenerVolumen()


  def actualizarPeso(unObjetoRecolectable : ObjetoRecolectable, g : Int) : Unit = {
    pesoLibre = pesoLibre - unObjetoRecolectable.peso(g)
    pesoTotal=pesoMaximo-pesoLibre
  }

}
