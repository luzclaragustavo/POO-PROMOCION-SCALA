trait Reembolsable:
  private var reembolsado = false

  def montoReembolso: Double

  def reembolsar(): Boolean =
    if reembolsado then false
    else
      reembolsado = true
      true

  def estaReembolsado: Boolean = reembolsado

// no es una Entrada
class Combo(val nombre: String, val precio: Double) extends Reembolsable:
  require(precio > 0, "El precio tiene que ser positivo")
  def montoReembolso: Double = precio
