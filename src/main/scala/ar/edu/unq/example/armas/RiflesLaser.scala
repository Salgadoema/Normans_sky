package ar.edu.unq.example.armas

import ar.edu.unq.example.personaje.Personaje

/**
  *
  */
trait RiflesLaser extends Personaje{

  var celdasDeEnergia: Int = 10

  def setCeldasDeEnergia (cantDeCeldas : Int) : Unit = celdasDeEnergia = cantDeCeldas


  def usarArma(celdasDisponibles : Int): Int = {
    if (celdasDisponibles >= 1) {
      celdasDeEnergia
    }

    else 0
  }

  def recargarLaser() : Unit = setCeldasDeEnergia(10)

  override def atacar(unPersonaje : Personaje) : Personaje = {
    val ret = unPersonaje recibirDanhoDe(getPoderDeAtaque, this)
    celdasDeEnergia = celdasDeEnergia -1
    ret
  }

  override def getPoderDeAtaque: Int = {
    usarArma(celdasDeEnergia)
  }
}
