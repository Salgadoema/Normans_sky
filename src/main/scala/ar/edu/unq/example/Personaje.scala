package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class Personaje(var energia : Int, unaMochila : Mochila  )  {

  def setCuerpoCeleste(cuerpoCeleste: CuerpoCeleste ) =
    cuerpoCelesteDondeEstoy = cuerpoCeleste



  def propulsarXTiempo(unaMochilaPropulsora: Mochila with Propulsora, tiempo: Int): Unit = {
    unaMochilaPropulsora.propulsarXTiempo(tiempo, unaMochilaPropulsora.pesoTotal())
    miConsumoPorPropulsion=unaMochilaPropulsora.consumoPorPropulsion(tiempo,miMochila.pesoTotal())
    miAlturaPorPropulsion=unaMochilaPropulsora.posicionEnEjeZ(tiempo)
  }

  var miConsumoPorPropulsion:Int = 10
  var miAlturaPorPropulsion : Int = 10
  var miTraje:Traje = new TrajeLiviano
  var cuerpoCelesteDondeEstoy : CuerpoCeleste = _
  val miMochila = unaMochila

  def caminarKms(km: Int) = {
    miTraje.caminar(km)
  }

  def capacidadOxigenoFinal(): Double = miTraje.oxigenoDisponible

  def agregarTraje(unTraje: Traje) = miTraje=unTraje

  def recolectarObjeto(objetoRecolectable: ObjetoRecolectable) = {

    miMochila.guardarObjeto(objetoRecolectable)

  }

  def capacidadLibre = miMochila.capacidadLibre()
  def pesoTotal = miMochila.pesoTotal()
  def miEnergia = energia



  def atacar(unArma : Arma) : Int = {
    unArma.usarArma
  }

  def recibirDanho(unDanho : Int) : Unit = {
    energia = energia - proteccionEscudo(unDanho)
  }



  def proteccionEscudo(unDanho : Int) : Int = 0


}
