package ar.edu.unq.example

/**
  * Created by user on 13/09/2016.
  */
trait ReflectorDeDanho extends Escudo {


  override def reacciona(danho: Int, atacante: Personaje):Personaje = {
    var unPersonaje = new Personaje(atacante.energia, atacante.miMochila)
    unPersonaje.recibirDanho(danho * elPorcentajeDeReflexion / 100)
    unPersonaje
  }

  var elPorcentajeDeReflexion: Int = 0

  override def porcentajeDeReflexion(porcentaje: Int): Int = {
    elPorcentajeDeReflexion = porcentaje
    elPorcentajeDeReflexion
  }

  override def proteccionEscudo(unDanho: Int): Int = {
    if (0 <= proteccion - unDanho) {
      proteccion = proteccion - unDanho
      proteccion
    }
    else {
      proteccion = 0
      0
    }


  }
}