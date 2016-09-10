package ar.edu.unq.example

/**
  * Created by damian on 09/09/16.
  */
class ArmaDeFuego extends Arma{

  var municionesDisponibles : Int= 3
  override var danho: Int = 3

  override def usarArma: Int = {
    if (municionesDisponibles >= 1){
      municionesDisponibles = municionesDisponibles -1
      super.usarArma
    }
    else 0
  }

}
