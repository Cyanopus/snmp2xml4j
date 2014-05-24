

/*
 * Copyright (c) 2014. iTransformers Labs http://itransformers.net
 *
 * snmp2xml is an open source tool written by Vasil Yordanov and Nikolay Milovanov
 * in JAVA programing languadge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.itransformers.snmptoolkit.transport;

import org.apache.log4j.Logger;
import org.snmp4j.TransportMapping;
import org.snmp4j.smi.TransportIpAddress;

import java.io.*;

public class LogBasedTransportMappingFactory implements TransportMappingAbstractFactory{
    private File log;
    private BufferedReader reader;
    static Logger logger = Logger.getLogger(LogBasedTransportMappingFactory.class);

    public LogBasedTransportMappingFactory(File log) {
        this.log = log;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(log)));
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }

    }

    public TransportMapping createTransportMapping(TransportIpAddress transportIpAddress) throws IOException {
        LogBasedTransportMapping logBasedTransportMapping1 = new LogBasedTransportMapping(reader, transportIpAddress);
        return logBasedTransportMapping1;
    }
}
