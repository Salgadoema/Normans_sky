package ar.edu.unq.example

/**
  * Created by user on 02/09/2016.
  */
class TrajeSpec extends BaseSpec{

  "creo un Traje Liviano y cuando le pido su capacidad Maxima " should "1500" in{

    val unTrajeLiviano = new TrajeLiviano
    unTrajeLiviano.capacidadMaxima shouldBe(1500)
  }

  "creo un Traje Pesado y cuando le pido su capacidad Maxima " should "4000" in{

    val unTrajeLiviano = new TrajePesado
    unTrajeLiviano.capacidadMaxima shouldBe(4000)
  }

  "creo un Traje Liviano y cuando le pido la capacidad total luego de recorrer 1km " should "1499.85" in{

    val unTrajeLiviano = new TrajeLiviano
    unTrajeLiviano.capacidadMaxima shouldBe(1500)
    unTrajeLiviano.calcularConsumoAlRecorrerKms(1)
    unTrajeLiviano.capacidadFinal shouldBe(1499.85)
  }

  "creo un Traje Liviano y cuando le pido la capacidad total luego de recorrer 100km " should "1490" in{

    val unTrajeLiviano = new TrajeLiviano
    unTrajeLiviano.capacidadMaxima shouldBe(1500)
    unTrajeLiviano.calcularConsumoAlRecorrerKms(100)
    unTrajeLiviano.capacidadFinal shouldBe(1490)
  }

  "creo un Traje Pesadp y cuando le pido la capacidad total luego de recorrer 50km " should "4000" in{


    val unTrajePesado = new TrajePesado
    unTrajePesado.capacidadMaxima shouldBe(4000)
    unTrajePesado.calcularConsumoAlRecorrerKms(50)
    unTrajePesado.capacidadFinal shouldBe(4000)


  }

  "creo un Traje Pesadp y cuando le pido la capacidad total luego de recorrer 120km " should "3986" in{

    val unTrajePesado = new TrajePesado
    unTrajePesado.capacidadMaxima shouldBe(4000)
    unTrajePesado.calcularConsumoAlRecorrerKms(120)
    unTrajePesado.capacidadFinal shouldBe(3986)
  }
}
