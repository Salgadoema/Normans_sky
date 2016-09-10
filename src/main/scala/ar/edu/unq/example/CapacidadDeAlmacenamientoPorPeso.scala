package ar.edu.unq.example

/**
  * Created by user on 30/08/2016.
  */
trait  CapacidadDeAlmacenamientoPorPeso extends Mochila{

  val pesoMaximo: Int = 1000
  var pesoLibre: Int = pesoMaximo
  var grav: Int = 10

  def actualizarPeso(unObjetoRecolectable : ObjetoRecolectable, g : Int) : Unit = {
    pesoLibre = pesoLibre - unObjetoRecolectable.peso(g)
  }
  override def puedoGuardar(unObjetoRecolectable: ObjetoRecolectable): Boolean = {
    0 <= capacidadLibre - unObjetoRecolectable.obtenerVolumen &&
    0 <= pesoLibre - unObjetoRecolectable.peso(grav)
    //esto esta mal xq la mochila no tendría que tener una gravedad "Interna"
  }

 override def estaLlena() ={
   capacidadLibre == 0 ||
     pesoLibre == 0
 }

  override def pesoMochila: Int = {
    pesoMaximo - pesoLibre
  }

}
