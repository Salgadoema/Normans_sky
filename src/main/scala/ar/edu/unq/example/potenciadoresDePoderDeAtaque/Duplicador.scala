package ar.edu.unq.example.potenciadoresDePoderDeAtaque

import ar.edu.unq.example.personaje.Personaje


trait Duplicador extends Personaje{

  def duplicar(valor : Int) : Int = {
    valor * 2
  }

  override def getPoderDeAtaque: Int = {
    duplicar(super.getPoderDeAtaque)
  }
}
