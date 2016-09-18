package ar.edu.unq.example.personaje

import ar.edu.unq.example.escudos.Escudo
import ar.edu.unq.example.mochilas.{Mochila, MochilaConCapacidadChica, Propulsora}
import ar.edu.unq.example.objetosRecolectables.ObjetoRecolectable
import ar.edu.unq.example.trajes.{Traje, TrajeLiviano}
import ar.edu.unq.example.miscelaneos.CuerpoCeleste

/**
  *
  */
class Personaje(var energia : Int, unaMochila : Mochila  )  {


  var miTraje:Traje = new TrajeLiviano
  var cuerpoCelesteDondeEstoy : CuerpoCeleste = _
  var miMochila = unaMochila
  var miEscudo: Escudo= new Escudo(0)
  var elPorcentajeDeReflexion:Int =0
  var poderDeAtaque : Int = 1

  def reflejarDanho(): Int =  elPorcentajeDeReflexion * energia/100

  def agregarEscudo(unEscudo: Escudo) = miEscudo=unEscudo

  def porcentajeDeReflexion(porcentaje: Int) = elPorcentajeDeReflexion= miEscudo.porcentajeDeReflexion(porcentaje)

  def setCuerpoCeleste(cuerpoCeleste: CuerpoCeleste ) = cuerpoCelesteDondeEstoy = cuerpoCeleste

  def getPoderDeAtaque : Int = poderDeAtaque

  def nivelDeProteccion(): Int = miEscudo.proteccion

  def caminarKms(km: Int): Unit = {
    miTraje.caminar(km,20)
    miTraje.caminar(km, miMochila.pesoTotal)
    miEscudo.recargar(km)
  }

  def capacidadOxigenoFinal(): Double = miTraje.oxigenoDisponible

  def agregarTraje(unTraje: Traje) = miTraje=unTraje

  def recolectarObjeto(objetoRecolectable: ObjetoRecolectable) = miMochila.guardarObjeto(objetoRecolectable)

  def capacidadLibre = miMochila.capacidadLibre()

  def recibirDanhoDe(danho: Int, atacante: Personaje) : Personaje={
    recibirDanho(danho)
    miEscudo.reacciona(danho,atacante,this)
  }

  def atacar(unPersonaje : Personaje) : Personaje = unPersonaje recibirDanhoDe(getPoderDeAtaque, this)

  def recibirDanho(unDanho : Int) : Unit = energia = energia + proteccionEscudo(unDanho)

  def proteccionEscudo(unDanho : Int) : Int =   miEscudo.proteccionEscudoAlRecibirDanhoDe(unDanho)

  def getMochila : Mochila = miMochila

  def getEnergia :Int = {
    if(energia>=0) energia
    else 0
  }

  def combatirAMuerte(atacante :Personaje, defensor :Personaje) :Unit={
    atacante.atacar(defensor)
    if(defensor.getEnergia > 0 && defensor.getCantBalas()>0) {
      println(defensor.getEnergia)
      defensor.combatirAMuerte(defensor, atacante)
    }
    else
      if(defensor.getCantBalas()==0)println("te quedaste sin balas")
      if(defensor.getEnergia<=0)println("El atacado está muerto ")



  }

  def getCantBalas(): Int =1



}
