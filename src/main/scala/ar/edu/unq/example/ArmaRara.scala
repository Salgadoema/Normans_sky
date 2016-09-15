package ar.edu.unq.example

/**
  * Created by damian on 15/09/16.
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
    unPersonaje recibirDanhoDe(usarArma(poderRaroDeAtaque), this)
  }

}
