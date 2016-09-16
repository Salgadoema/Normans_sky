package ar.edu.unq.example

/**
  *
  */
trait ArmaDeFuego extends Personaje{

  var cantDeBalas: Int = 6
  poderDeAtaque = 3

  def recargarBalas (unasCuantasBalas : Int) : Unit = {
    cantDeBalas = unasCuantasBalas
  }

  def usarArma(): Int = {
    if (cantDeBalas >= 1) {
      cantDeBalas = cantDeBalas - 1
      poderDeAtaque
    }
    else 0
  }

  override def atacar(unPersonaje : Personaje) : Personaje = {
    unPersonaje recibirDanhoDe(getPoderDeAtaque, this)
  }

  override def getPoderDeAtaque: Int = usarArma()
}
