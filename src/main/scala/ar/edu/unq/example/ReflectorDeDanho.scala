package ar.edu.unq.example

/**
  * Created by user on 13/09/2016.
  */
trait ReflectorDeDanho extends Escudo {

  var elPorcentajeDeReflexion: Int = 0

  override def reacciona(danho: Int, atacante: Personaje, defensor: Personaje):Personaje = {
    var unPersonaje = new Personaje(atacante.energia, atacante.miMochila)
    unPersonaje.recibirDanho(danho * elPorcentajeDeReflexion / 100)
    unPersonaje
  }

  override def porcentajeDeReflexion(porcentaje: Int): Int = {
    elPorcentajeDeReflexion = porcentaje
    elPorcentajeDeReflexion
  }

}