/*
 * java-tron is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * java-tron is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *//*
 * java-tron is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * java-tron is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.tron.command

import org.tron.core.BlockUtils
import org.tron.core.Blockchain
import org.tron.core.BlockchainIterator
import org.tron.peer.Peer
import org.tron.protos.core.TronBlock
import org.fusesource.jansi.Ansi.ansi

class PrintBlockchainCommand() extends Command {
  override def execute(peer: Peer, parameters: Array[String]): Unit = {
    val blockchain = peer.getUTXOSet.getBlockchain
    val bi = new BlockchainIterator(blockchain)
    while ( {
      bi.hasNext
    }) {
      val block = bi.next.asInstanceOf[TronBlock.Block]
      println(BlockUtils.toPrintString(block))
    }
  }

  override def usage(): Unit = {
    println("")
    println(ansi.eraseScreen.render("@|magenta,bold USAGE|@\n\t@|bold printblockchain|@"))
    println("")
    println(ansi.eraseScreen.render("@|magenta,bold DESCRIPTION|@\n\t@|bold The command 'printblockchain' print blockchain.|@"))
    println("")
  }

  override def check(parameters: Array[String]) = true
}