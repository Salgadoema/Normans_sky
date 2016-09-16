package ar.edu.unq.example

/**
  *
  */
trait CompactacionPorVacio extends Mochila{

  override def guardarObjeto(unObjeto: ObjetoRecolectable): Unit = {
    val objetoCompactado: ObjetoRecolectable =unObjeto
    objetoCompactado.compactarObjeto(unObjeto)
    super.guardarObjeto(objetoCompactado)
  }
}
