package ar.edu.unq.example.mochilas

import ar.edu.unq.example.objetosRecolectables.ObjetoRecolectable

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
