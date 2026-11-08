import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.*

// sin sincronizar
class ContadorInseguro:
  private var vendidas = 0
  def vender(): Unit = vendidas = vendidas + 1
  def total: Int = vendidas

class ContadorSeguro:
  private var vendidas = 0
  def vender(): Unit = synchronized { vendidas = vendidas + 1 }
  def total: Int = synchronized { vendidas }

object Concurrencia:
  def dosBoleterias(vender: () => Unit): Unit =
    val tarea: Runnable = () => for _ <- 1 to 1000000 do vender()
    val boleteria1 = Thread(tarea)
    val boleteria2 = Thread(tarea)
    boleteria1.start(); boleteria2.start()
    boleteria1.join(); boleteria2.join()

  def consultarOcupacion(sala: Int): Future[Int] = Future {
    Thread.sleep(500)
    sala * 10
  }

  def ejecutar(): Unit =
    val inseguro = ContadorInseguro()
    dosBoleterias(() => inseguro.vender())
    println(s"Sin synchronized: ${inseguro.total} ventas (deberian ser 2000000)")

    val seguro = ContadorSeguro()
    dosBoleterias(() => seguro.vender())
    println(s"Con synchronized: ${seguro.total} ventas")

    val inicio = System.currentTimeMillis()
    val consultas = Future.sequence(List(1, 2, 3).map(consultarOcupacion))
    val resultado = Await.result(consultas, 5.seconds)
    val ms = System.currentTimeMillis() - inicio
    println(s"Ocupacion de las 3 salas: $resultado en $ms ms (cada consulta tarda 500 ms; una tras otra serian 1500)")
