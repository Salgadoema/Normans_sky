package ar.edu.unq.example.mochilas

/**
  *
  */
trait SemiRigida extends Mochila {

  var constDeAbsorbcion : Int

  override def proteccionAlGolpeDe(golpe: Int): Int =  golpe - constDeAbsorbcion

}
