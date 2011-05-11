/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gm.core.xml;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;

import com.gm.core.lang.StringUtils;

/**
 * Abstract base class for SAX <code>XMLReader</code> implementations that use StAX as a basis.
 *
 * @author Arjen Poutsma
 * @since 3.0
 * @see #setContentHandler(org.xml.sax.ContentHandler)
 * @see #setDTDHandler(org.xml.sax.DTDHandler)
 * @see #setEntityResolver(org.xml.sax.EntityResolver)
 * @see #setErrorHandler(org.xml.sax.ErrorHandler)
 */
abstract class AbstractStaxXMLReader extends AbstractXMLReader {

	private static final String NAMESPACES_FEATURE_NAME = "http://xml.org/sax/features/namespaces";

	private static final String NAMESPACE_PREFIXES_FEATURE_NAME = "http://xml.org/sax/features/namespace-prefixes";

	private static final String IS_STANDALONE_FEATURE_NAME = "http://xml.org/sax/features/is-standalone";


	private boolean namespacesFeature = true;

	private boolean namespacePrefixesFeature = false;

	private Boolean isStandalone;

	private final Map<String, String> namespaces = new LinkedHashMap<String, String>();

	@Override
	public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
		if (NAMESPACES_FEATURE_NAME.equals(name)) {
			return this.namespacesFeature;
		}
		else if (NAMESPACE_PREFIXES_FEATURE_NAME.equals(name)) {
			return this.namespacePrefixesFeature;
		}
		else if (IS_STANDALONE_FEATURE_NAME.equals(name)) {
			if (this.isStandalone != null) {
				return this.isStandalone;
			}
			else {
				throw new SAXNotSupportedException("startDocument() callback not completed yet");
			}
		}
		else {
			return super.getFeature(name);
		}
	}

	@Override
	public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
		if (NAMESPACES_FEATURE_NAME.equals(name)) {
			this.namespacesFeature = value;
		}
		else if (NAMESPACE_PREFIXES_FEATURE_NAME.equals(name)) {
			this.namespacePrefixesFeature = value;
		}
		else {
			super.setFeature(name, value);
		}
	}

	protected void setStandalone(boolean standalone) {
		this.isStandalone = standalone;
	}

	/**
	 * Indicates whether the SAX feature <code>http://xml.org/sax/features/namespaces</code> is turned on.
	 */
	protected boolean hasNamespacesFeature() {
		return this.namespacesFeature;
	}

	/**
	 * Indicates whether the SAX feature <code>http://xml.org/sax/features/namespaces-prefixes</code> is turned on.
	 */
	protected boolean hasNamespacePrefixesFeature() {
		return this.namespacePrefixesFeature;
	}

	/**
	 * Convert a <code>QName</code> to a qualified name, as used by DOM and SAX.
	 * The returned string has a format of <code>prefix:localName</code> if the
	 * prefix is set, or just <code>localName</code> if not.
	 * @param qName the <code>QName</code>
	 * @return the qualified name
	 */
	protected String toQualifiedName(QName qName) {
		String prefix = qName.getPrefix();
		if (!StringUtils.hasLength(prefix)) {
			return qName.getLocalPart();
		}
		else {
			return prefix + ":" + qName.getLocalPart();
		}
	}


	/**
	 * Parse the StAX XML reader passed at construction-time.
	 * <p><b>NOTE:</b>: The given <code>InputSource</code> is not read, but ignored.
	 * @param ignored is ignored
	 * @throws SAXException a SAX exception, possibly wrapping a <code>XMLStreamException</code>
	 */
	public final void parse(InputSource ignored) throws SAXException {
		parse();
	}

	/**
	 * Parse the StAX XML reader passed at construction-time.
	 * <p><b>NOTE:</b>: The given system identifier is not read, but ignored.
	 * @param ignored is ignored
	 * @throws SAXException A SAX exception, possibly wrapping a <code>XMLStreamException</code>
	 */
	public final void parse(String ignored) throws SAXException {
		parse();
	}

	private void parse() throws SAXException {
		try {
			parseInternal();
		}
		catch (XMLStreamException ex) {
			Locator locator = null;
			if (ex.getLocation() != null) {
				locator = new StaxLocator(ex.getLocation());
			}
			SAXParseException saxException = new SAXParseException(ex.getMessage(), locator, ex);
			if (getErrorHandler() != null) {
				getErrorHandler().fatalError(saxException);
			}
			else {
				throw saxException;
			}
		}
	}

	/**
	 * Template-method that parses the StAX reader passed at construction-time.
	 */
	protected abstract void parseInternal() throws SAXException, XMLStreamException;

	/**
	 * Starts the prefix mapping for the given prefix.
	 * @see org.xml.sax.ContentHandler#startPrefixMapping(String, String)
	 */
	protected void startPrefixMapping(String prefix, String namespace) throws SAXException {
		if (getContentHandler() != null) {
			if (prefix == null) {
				prefix = "";
			}
			if (!StringUtils.hasLength(namespace)) {
				return;
			}
			if (!namespace.equals(namespaces.get(prefix))) {
				getContentHandler().startPrefixMapping(prefix, namespace);
				namespaces.put(prefix, namespace);
			}
		}
	}

	/**
	 * Ends the prefix mapping for the given prefix.
	 * @see org.xml.sax.ContentHandler#endPrefixMapping(String)
	 */
	protected void endPrefixMapping(String prefix) throws SAXException {
		if (getContentHandler() != null) {
			if (namespaces.containsKey(prefix)) {
				getContentHandler().endPrefixMapping(prefix);
				namespaces.remove(prefix);
			}
		}
	}

	/**
	 * Implementation of the <code>Locator</code> interface that is based on a StAX <code>Location</code>.
	 * @see Locator
	 * @see Location
	 */
	private static class StaxLocator implements Locator {

		private Location location;

		protected StaxLocator(Location location) {
			this.location = location;
		}

		public String getPublicId() {
			return location.getPublicId();
		}

		public String getSystemId() {
			return location.getSystemId();
		}

		public int getLineNumber() {
			return location.getLineNumber();
		}

		public int getColumnNumber() {
			return location.getColumnNumber();
		}
	}

}
