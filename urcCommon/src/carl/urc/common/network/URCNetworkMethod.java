/*
 *    This file is part of urcRemote. urcRemote turns your mobile phone into
 *    a touch-pad and keyboard for your computer.
 *
 *    Copyright  2010 Carl Lobo <carllobo@gmail.com>
 *
 *    urcRemote is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    urcRemote is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with urcRemote.  If not, see <http://www.gnu.org/licenses/>.
 */
 
package carl.urc.common.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class UrcNetworkMethod {

	protected byte header;

	protected UrcNetworkMethod(byte header) {
		this.header = header;
	}

	protected byte getHeader() {
		return header;
	}

	protected abstract void writePayload(DataOutputStream output)
			throws IOException;

	protected abstract UrcNetworkMethod readPayload(DataInputStream input)
			throws IOException;

	public void write(DataOutputStream output) throws IOException {
		output.writeByte(header);
		writePayload(output);
	}
}