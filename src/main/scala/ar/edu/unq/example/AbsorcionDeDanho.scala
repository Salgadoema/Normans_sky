package ar.edu.unq.example

/**
  * Created by damian on 09/09/16.
  */
trait AbsorcionDeDanho extends Escudo{

  var factorDeAbsorcion : Int = 0

  def setFactDeAbsorcion (valor : Int) : Unit = {
    factorDeAbsorcion = valor
  }

   override def reacciona(danho: Int, atacante: Personaje, defensor: Personaje):Personaje = {
    var unPersonaje = new Personaje(defensor.energia,defensor.miMochila)
    unPersonaje.poderDeAtaque = unPersonaje.poderDeAtaque + factorDeAbsorcion * danho/100
    unPersonaje
  }

}
