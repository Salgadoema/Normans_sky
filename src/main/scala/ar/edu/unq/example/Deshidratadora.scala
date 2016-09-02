package ar.edu.unq.example

/**
  * Created by user on 01/09/2016.
  */
trait Deshidratadora extends Mochila{

  override def guardarObjeto(unObjeto: ObjetoRecolectable): Unit = {
    val objetoDeshidratado: ObjetoRecolectable =unObjeto
    objetoDeshidratado.deshidratarObjeto(unObjeto)
    super.guardarObjeto(objetoDeshidratado)
  }

}
