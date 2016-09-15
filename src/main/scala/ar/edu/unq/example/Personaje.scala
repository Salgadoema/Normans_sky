package ar.edu.unq.example

import scala.xml.Null


/**
  * Created by user on 28/08/2016.
  */
class Personaje(var energia : Int, unaMochila : Mochila  )  {


  def recibirDanhoDe(danho: Int, atacante: Personaje) : Personaje={
    recibirDanho(danho)
    miEscudo.reacciona(danho,atacante)

  }


  def reflejarDanho(): Int = {
    elPorcentajeDeReflexion * energia/100
  }


  var miTraje:Traje = new TrajeLiviano
  var cuerpoCelesteDondeEstoy : CuerpoCeleste = _
  val miMochila = unaMochila
  var miEscudo: Escudo= new Escudo(0)
  var elPorcentajeDeReflexion:Int =0


  def agregarEscudo(unEscudo: Escudo) =
    miEscudo=unEscudo

 def porcentajeDeReflexion(porcentaje: Int) =
   elPorcentajeDeReflexion= miEscudo.porcentajeDeReflexion(porcentaje)




  def setCuerpoCeleste(cuerpoCeleste: CuerpoCeleste ) =
    cuerpoCelesteDondeEstoy = cuerpoCeleste

  def nivelDeProteccion(): Int ={

   miEscudo.proteccion

  }


  def caminarKms(km: Int): Unit = {
    miTraje.caminar(km,20)
    miTraje.caminar(km, miMochila.pesoTotal)

     miEscudo.recargar(km)
  }
  def capacidadOxigenoFinal(): Double = miTraje.oxigenoDisponible

  def agregarTraje(unTraje: Traje) = miTraje=unTraje

  def recolectarObjeto(objetoRecolectable: ObjetoRecolectable) = {
    miMochila.guardarObjeto(objetoRecolectable)
  }

  def capacidadLibre = miMochila.capacidadLibre()





  def atacar(unArma : Arma) : Int = {
    unArma.usarArma
  }

    def recibirDanho(unDanho : Int) : Unit = {
      energia = energia - proteccionEscudo(unDanho)
    }

    def proteccionEscudo(unDanho : Int) : Int = {

      miEscudo.proteccionEscudo(unDanho)
    }



}
