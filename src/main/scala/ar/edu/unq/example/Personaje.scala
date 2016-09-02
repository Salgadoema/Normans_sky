package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class Personaje(energia: Int, unaMochila: Mochila  )  {
  def recolectarObjeto(objetoRecolectable: ObjetoRecolectable) = {

    miMochila.guardarObjeto(objetoRecolectable)
  }

  def capacidadLibre = miMochila.capacidadLibre

  val miMochila = unaMochila
  def miEnergia = energia




}
