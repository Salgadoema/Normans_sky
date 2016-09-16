package ar.edu.unq.example

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

  def atacar(unPersonaje : Personaje) : Personaje = unPersonaje recibirDanhoDe(poderDeAtaque, this)

  def recibirDanho(unDanho : Int) : Unit = energia = energia + proteccionEscudo(unDanho)

  def proteccionEscudo(unDanho : Int) : Int =   miEscudo.proteccionEscudoAlRecibirDanhoDe(unDanho)


}
