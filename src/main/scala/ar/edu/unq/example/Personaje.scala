package ar.edu.unq.example

import scala.xml.Null


/**
  * Created by user on 28/08/2016.
  */
class Personaje(var energia : Int, unaMochila : Mochila  )  {


  def reflejarDanho(): Int = {
    elPorcentajeDeReflexion * danhoRecibido/100
  }

var danhoRecibido : Int=0
  var miProteccion:Int =0

  def agregarEscudo(unEscudo: Escudo) =
    miEscudo=unEscudo

  var elPorcentajeDeReflexion:Int =0


  def porcentajeDeReflexion(porcentaje: Int) =
    elPorcentajeDeReflexion= miEscudo.porcentajeDeReflexion(porcentaje)



  var miEscudo: Escudo=_
  def setCuerpoCeleste(cuerpoCeleste: CuerpoCeleste ) =
    cuerpoCelesteDondeEstoy = cuerpoCeleste

  def nivelDeProteccion(): Int ={

   miProteccion= miEscudo.proteccion
    miProteccion
  }

/*
  def propulsarXTiempo(unaMochilaPropulsora: Mochila with Propulsora, tiempo: Int): Unit = {
    unaMochilaPropulsora.propulsarXTiempo(tiempo, unaMochilaPropulsora.)
    miConsumoPorPropulsion=unaMochilaPropulsora.consumoPorPropulsion(tiempo,miMochila.pesoTotal_())
    miAlturaPorPropulsion=unaMochilaPropulsora.posicionEnEjeZ(tiempo)
  }
*/
  var miConsumoPorPropulsion:Int = 10
  var miAlturaPorPropulsion : Int = 10
  var miTraje:Traje = new TrajeLiviano
  var cuerpoCelesteDondeEstoy : CuerpoCeleste = _
  val miMochila = unaMochila

  def caminarKms(km: Int): Unit = {
    miTraje.caminar(km,20)
    //miTraje.caminar(km, miMochila.PesoTotal)
    miEscudo.recargar(km)
  }

  def capacidadOxigenoFinal(): Double = miTraje.oxigenoDisponible

  def agregarTraje(unTraje: Traje) = miTraje=unTraje

  def recolectarObjeto(objetoRecolectable: ObjetoRecolectable) = {

    miMochila.guardarObjeto(objetoRecolectable)

  }

  def capacidadLibre = miMochila.capacidadLibre()
//  def pesoTotal = miMochila.pesoTotal_()
  def miEnergia = energia



  def atacar(unArma : Arma) : Int = {
    unArma.usarArma
  }

  def recibirDanho(unDanho : Int) : Unit = {
    energia = energia - proteccionEscudo(unDanho)
    danhoRecibido = unDanho

  }

  def proteccionEscudo(unDanho : Int) : Int = {

    miEscudo.proteccionEscudo(unDanho)
  }



}
