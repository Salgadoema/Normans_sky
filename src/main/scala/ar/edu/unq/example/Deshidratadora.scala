package ar.edu.unq.example

/**
  *
  */
trait Deshidratadora extends Mochila{

  override def guardarObjeto(unObjeto: ObjetoRecolectable): Unit = {
    val objetoDeshidratado: ObjetoRecolectable =unObjeto
    objetoDeshidratado.deshidratarObjeto(unObjeto)
    super.guardarObjeto(objetoDeshidratado)
  }

}
