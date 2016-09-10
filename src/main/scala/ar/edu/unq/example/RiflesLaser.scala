package ar.edu.unq.example

/**
  * Created by damian on 09/09/16.
  */
class RiflesLaser extends Arma{

  var celdasDeEnergia : Int = 10

  def setCeldasDeEnergia (i : Int) : Unit = {
    celdasDeEnergia = i
  }

  def RifleLaser(i : Int) : Unit ={
    danho = i
  }

  def usarArma(celdasDisponibles : Int): Int = {
    if (celdasDisponibles >= 1) {
      val ret = celdasDeEnergia
      celdasDeEnergia = celdasDeEnergia - 1
      ret
    }

    else 0
  }

  override var danho: Int = celdasDeEnergia

  def recargarLaser() : Unit = setCeldasDeEnergia(10)

}
