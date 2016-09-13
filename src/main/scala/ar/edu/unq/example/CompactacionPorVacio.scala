package ar.edu.unq.example

/**
  * Created by user on 30/08/2016.
  */
trait CompactacionPorVacio extends Mochila{

  override def guardarObjeto(unObjeto: ObjetoRecolectable): Unit = {
    val objetoCompactado: ObjetoRecolectable =unObjeto
    objetoCompactado.compactarObjeto(unObjeto)
    super.guardarObjeto(objetoCompactado)
  }
}
