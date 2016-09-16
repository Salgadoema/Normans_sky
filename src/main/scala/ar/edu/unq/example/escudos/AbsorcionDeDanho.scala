package ar.edu.unq.example.escudos

import ar.edu.unq.example.personaje.Personaje

/**
  *
  */
trait AbsorcionDeDanho extends Escudo{

  var factorDeAbsorcion : Int = 0

  def setFactDeAbsorcion (valor : Int) : Unit = factorDeAbsorcion = valor


   override def reacciona(danho: Int, atacante: Personaje, defensor: Personaje):Personaje = {
    var unPersonaje = new Personaje(defensor.energia,defensor.miMochila)
    unPersonaje.poderDeAtaque = unPersonaje.poderDeAtaque + factorDeAbsorcion * danho/100
    unPersonaje
  }

}
