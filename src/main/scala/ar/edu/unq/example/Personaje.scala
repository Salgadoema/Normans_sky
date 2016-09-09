package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class Personaje(var energia : Int, unaMochila : Mochila  )  {


  def capacidadOxigenoFinal(): Double = miTraje.oxigenoDisponible


  var miTraje:Traje = new TrajeLiviano

  val miMochila = unaMochila

  def caminarKms(km: Int) = {
    miTraje.caminar(km)
  }


  def agregarTraje(unTraje: Traje) = miTraje=unTraje

  def recolectarObjeto(objetoRecolectable: ObjetoRecolectable) = {

    miMochila.guardarObjeto(objetoRecolectable)
  }

  def capacidadLibre = miMochila.capacidadLibre()


  def miEnergia = energia

  def atacar(unArma : Arma) : Int = {
    0
  }

  def recibirDanho(unDanho : Int) : Unit = {
    energia = energia - proteccionEscudo(unDanho)
  }

  def proteccionEscudo(unDanho : Int) : Int = 0
}
