package ar.edu.unq.example.potenciadoresDePoderDeAtaque

import ar.edu.unq.example.personaje.Personaje


trait Cancelador extends Personaje{

  override def getPoderDeAtaque: Int = 0
}
