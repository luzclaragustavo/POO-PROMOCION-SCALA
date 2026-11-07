class Sala(val numero: Int, filas: Int, butacasPorFila: Int):
  require(filas > 0 && butacasPorFila > 0, "La sala tiene que tener butacas")

  private val ocupadas = Array.ofDim[Boolean](filas, butacasPorFila)

  def reservar(fila: Int, butaca: Int): Boolean =
    if ocupadas(fila)(butaca) then false
    else
      ocupadas(fila)(butaca) = true
      true