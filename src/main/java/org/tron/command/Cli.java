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
 */
package org.tron.command;

import org.tron.peer.Peer;

import java.util.Arrays;
import java.util.Scanner;

public class Cli {
    public Cli() {
    }

    public void run(Peer peer) {
        Scanner in = new Scanner(System.in);

        while (true) {
            String cmd = in.nextLine();
            cmd = cmd.trim();

            String[] cmdArray = cmd.split("\\s+");

            if (cmdArray.length == 0 || cmdArray[0].equals("")) {
                continue;
            }

            String[] cmdParameters = Arrays.copyOfRange(cmdArray, 1, cmdArray.length);

            switch (cmdArray[0]) {
                case "version":
                    new VersionCommand().execute(peer, cmdParameters);
                    break;
                case "account":
                    new AccountCommand().execute(peer, cmdParameters);
                    break;
                case "getbalance":
                    new GetBalanceCommand().execute(peer, cmdParameters);
                    break;
                case "send":
                    new SendCommand().execute(peer, cmdParameters);
                    break;
                case "printblockchain":
                    new PrintBlockchainCommand().execute(peer, cmdParameters);
                    break;
                case "consensus":
                    new ConcensusCommand().server();
                    break;
                case "getmessage":
                    new ConcensusCommand().getClient(cmdParameters);
                    break;
                case "putmessage":
                    new ConcensusCommand().putClient(cmdParameters);
                    break;
                case "exit":
                case "quit":
                case "bye":
                    new ExitCommand().execute(peer, cmdParameters);
                    break;
                case "help":
                default:
                    new HelpCommand().execute(peer, cmdParameters);
                    break;
            }
        }
    }
}
