package ar.edu.unq.example

/**
  * Created by user on 12/09/2016.
  */
trait Propulsora extends Mochila {
  var consumo: Int = _
  var altura : Int=_

  def propulsarXTiempo(tiempo:Int, peso: Int): Unit ={
    consumoPorPropulsion(tiempo,peso)
    posicionEnEjeZ(tiempo)
  }

  def consumoPorPropulsion(tiempo:Int, peso: Int): Int ={
    consumo = tiempo *peso
    return consumo
  }

  def posicionEnEjeZ(tiempo: Int) : Int = {
    altura=tiempo /2
    return altura
  }
}
