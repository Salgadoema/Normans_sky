package ar.edu.unq.example.armas

import ar.edu.unq.example.personaje.Personaje

/**
  *
  */
trait ArmaRara extends Personaje{

  var poderRaroDeAtaque : Int = 0

  def poderRaroDeAtaque(valor : Int): Unit ={
    poderRaroDeAtaque = valor
  }

  def usarArma(poderRaro : Int): Int = {
    if (energia >= poderRaro) {
      val ret = poderRaro
      energia = energia - poderRaro
      ret
    }

    else 0
  }

  override def atacar(unPersonaje : Personaje) : Personaje = {
    unPersonaje recibirDanhoDe(getPoderDeAtaque, this)
  }

  override def getPoderDeAtaque: Int = usarArma(poderRaroDeAtaque)

}
