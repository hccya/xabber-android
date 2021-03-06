/**
 * Copyright (c) 2013, Redsolution LTD. All rights reserved.
 *
 * This file is part of Xabber project; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License, Version 3.
 *
 * Xabber is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License,
 * along with this program. If not, see http://www.gnu.org/licenses/.
 */
package com.xabber.xmpp.vcard;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.xmlpull.v1.XmlSerializer;

import com.xabber.xmpp.SerializerUtils;

public class Address extends AbstractTypedData<AddressType> {

    public static final String ELEMENT_NAME = "ADR";

    protected final Map<AddressProperty, String> properties;

    public Address() {
        super();
        properties = new HashMap<AddressProperty, String>();
    }

    public Map<AddressProperty, String> getProperties() {
        return properties;
    }

    @Override
    protected String getElementName() {
        return ELEMENT_NAME;
    }

    @Override
    protected void writeBody(XmlSerializer serializer) throws IOException {
        for (Entry<AddressProperty, String> entry : properties.entrySet())
            SerializerUtils.addTextTag(serializer, entry.getKey().toString(),
                    entry.getValue());
    }

    @Override
    public boolean isValid() {
        return AddressType.isValid(types);
    }

}
