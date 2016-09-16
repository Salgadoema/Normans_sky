package ar.edu.unq.example


trait ExperienciaEnCombate extends Personaje{

  var experiencia :Int = 0

  override def getPoderDeAtaque: Int = {
    super.getPoderDeAtaque + experiencia
  }

  override def atacar(unPersonaje: Personaje): Personaje = {
    var ret = super.atacar(unPersonaje)
    experiencia = experiencia +1
    ret
  }

}
