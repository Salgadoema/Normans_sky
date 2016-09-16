package ar.edu.unq.example

/**
  *
  */
trait RiflesLaser extends Personaje{

  var celdasDeEnergia: Int = 10

  def setCeldasDeEnergia (cantDeCeldas : Int) : Unit = celdasDeEnergia = cantDeCeldas


  def usarArma(celdasDisponibles : Int): Int = {
    if (celdasDisponibles >= 1) {
      val ret = celdasDeEnergia
      celdasDeEnergia = celdasDeEnergia - 1
      ret
    }

    else 0
  }

  def recargarLaser() : Unit = setCeldasDeEnergia(10)

  override def atacar(unPersonaje : Personaje) : Personaje =
   unPersonaje recibirDanhoDe(usarArma(celdasDeEnergia), this)


}
